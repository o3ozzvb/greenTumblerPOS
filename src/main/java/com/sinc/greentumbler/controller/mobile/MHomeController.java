package com.sinc.greentumbler.controller.mobile;

import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.controller.FCMController;
import com.sinc.greentumbler.service.AccountService;
import com.sinc.greentumbler.service.TumblerService;
import com.sinc.greentumbler.vo.AccountVO;
import com.sinc.greentumbler.vo.AlarmVO;
import com.sinc.greentumbler.vo.TumblerVO;

@Controller
@RequestMapping("/mobile/main")
public class MHomeController extends FCMController {
	
	@Resource(name="accountService")
	AccountService accountService;
	
	@Resource(name="tumblerService")
	TumblerService tumblerService;
	
	@RequestMapping(value="/accounts/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public Object Main(@PathVariable String accountId, Model model) {
		
		AccountVO account = (AccountVO)(accountService.selectOne(accountId));
		TumblerVO tumbler = (TumblerVO)(tumblerService.selectTumb(accountId)).get(0);
		
		model.addAttribute("account", account);
		model.addAttribute("tumbler", tumbler);
		
		return model;
	}
	
	@RequestMapping(value="/getMyAlarms/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public List<AlarmVO> getMyAlarms(@PathVariable String accountId) {
		System.out.println(accountId);
		return accountService.getMyAlarms(accountId);
	}
}
