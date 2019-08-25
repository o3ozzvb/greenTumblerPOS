package com.sinc.greentumbler.controller.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.vo.AccountVO;

@Controller
@RequestMapping("/mobile")
public class MHomeController {
	@RequestMapping(value="/main/{accountId}", method=RequestMethod.GET)
	@ResponseBody
	public Object Main(@PathVariable String accountId) {
		System.out.println(accountId);
		AccountVO vo = new AccountVO();
		vo.setId("TEST");
		return vo;
	}
}
