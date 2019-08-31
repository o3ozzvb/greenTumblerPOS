package com.sinc.greentumbler.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.sinc.greentumbler.service.AccountService;
import com.sinc.greentumbler.vo.AccountVO;

@Controller
@RequestMapping("/fcm")
public class FCMController {
	
	@Resource(name="accountService")
	AccountService accountService;
	
	@RequestMapping(value="/sendLostMsg", method=RequestMethod.POST)
	@ResponseBody
	public Object sendLostMsg(String accountId, String msg) {
		
		AccountVO account = (AccountVO)(accountService.selectOne(accountId));
		String fcmToken = account.getFcm_token();
		Object result = null;
		try {
			result = doSend(fcmToken, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Async
	@ResponseBody
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
    public Object doSend(String fcmToken, String msg) throws Exception {
        try {    
            System.out.println(msg);
            System.out.println("Send Message Called");
            System.out.println(fcmToken);
            ClassPathResource resource = new ClassPathResource("google/starbucks-greentumbler-firebase-adminsdk-055c3-1535f9c042.json");
            String path = resource.getPath();
            File file = resource.getFile();
            InputStream fileStream = new FileInputStream(file);
            System.out.println(path);
            String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
            String[] SCOPES = { MESSAGING_SCOPE };
            
            GoogleCredential googleCredential = GoogleCredential.fromStream(fileStream).createScoped(Arrays.asList(SCOPES));
           
            googleCredential.refreshToken();
                                
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type" , MediaType.APPLICATION_JSON_VALUE);
            headers.add("Authorization", "Bearer " + googleCredential.getAccessToken());
            
            JSONObject notification = new JSONObject();
            
            notification.put("title", "스타벅스");
            notification.put("body", msg);
            
            JSONObject message = new JSONObject();
            
            
            message.put("token", fcmToken);
            message.put("notification", notification);
            //message.put("data", notification);
            
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("message", message);
            
            HttpEntity<JSONObject> httpEntity = new HttpEntity<JSONObject>(jsonParams, headers);
            RestTemplate rt = new RestTemplate();            
            
            ResponseEntity<String> res = rt.exchange("https://fcm.googleapis.com/v1/projects/starbucks-greentumbler/messages:send"
                    , HttpMethod.POST
                    , httpEntity
                    , String.class);
        
            if (res.getStatusCode() != HttpStatus.OK) {
                System.out.println("FCM-Exception");
                System.out.println(res.getStatusCode().toString());
                System.out.println(res.getHeaders().toString());
                System.out.println(res.getBody().toString());
                
            } else {
                System.out.println(res.getStatusCode().toString());
                System.out.println(res.getHeaders().toString());
                System.out.println(res.getBody().toLowerCase());
                
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	protected String convertToJSON(Object obj) {
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
