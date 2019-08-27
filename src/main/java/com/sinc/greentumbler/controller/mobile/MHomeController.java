package com.sinc.greentumbler.controller.mobile;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.service.AccountService;
import com.sinc.greentumbler.vo.AccountVO;

@Controller
@RequestMapping("/mobile/main")
public class MHomeController {
	
	@Resource(name="accountService")
	AccountService accountService;
	
	@RequestMapping(value="/accounts/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public Object Main(@PathVariable String accountId) {
		System.out.println(accountId);
		AccountVO vo = (AccountVO)(accountService.selectOne(accountId));
		System.out.println(vo);
		
		return vo;
	}
}
