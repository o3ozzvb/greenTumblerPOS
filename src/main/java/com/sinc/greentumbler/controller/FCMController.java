package com.sinc.greentumbler.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

@Controller
@RequestMapping("/fcm")
public class FCMController {

	@RequestMapping(value="/fcmTest", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
    public void fcmTest() throws Exception {
        try {    
            
            // String path = "classpath:google/starbucks-greentumbler-firebase-adminsdk-055c3-1535f9c042.json";   
            
            ClassPathResource resource = new ClassPathResource("google/starbucks-greentumbler-firebase-adminsdk-055c3-1535f9c042.json");
            String path = resource.getPath();
            File file = resource.getFile();
            InputStream fileStream = new FileInputStream(file);
            System.out.println(path);
            String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
            String[] SCOPES = { MESSAGING_SCOPE };
            
            //GoogleCredential googleCredential = GoogleCredential.fromStream(new FileInputStream(path)).createScoped(Arrays.asList(SCOPES));
            GoogleCredential googleCredential = GoogleCredential.fromStream(fileStream).createScoped(Arrays.asList(SCOPES));
           
            googleCredential.refreshToken();
                                
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type" , MediaType.APPLICATION_JSON_VALUE);
            headers.add("Authorization", "Bearer " + googleCredential.getAccessToken());
            
            JSONObject notification = new JSONObject();
            notification.put("body", "분실 메세지");
            notification.put("title", "알림메세지");
            
            JSONObject message = new JSONObject();
            message.put("token", "csv18gJFRoM:APA91bHXSQ_sYIjDvb5-fbaI8fI2p8mZPylGWks6CuzjZQec-ecmvy37BxYhVke8po14qwHu3gkt3J6_SWlD5Ihrw9mkhY03-oytRN9MsV1M3Z6JcJv6oCoAfwlM_YFY8TAXXXvkTl2N");
            message.put("notification", notification);
            
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
