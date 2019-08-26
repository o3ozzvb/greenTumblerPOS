package com.sinc.greentumbler.controller.mobile;



import java.util.List;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.service.TumblerService;
import com.sinc.greentumbler.vo.TumblerVO;

@Controller
@RequestMapping("/mobile/tumbler")
public class MTumblerController {
	@Resource(name="tumblerService")
	private TumblerService service;
	
	@RequestMapping(value="/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public List<TumblerVO> getTumbler(@PathVariable String accountId){
		List<TumblerVO> tumblerList = service.selectTumb(accountId);
		
		return tumblerList;
	}
	
	@RequestMapping(value="/payYn", method=RequestMethod.POST)
	@ResponseBody
	public TumblerVO updatePayYn(TumblerVO tumbler){
		TumblerVO result = service.updatePayYn(tumbler);
		return result;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public int addTumbler(TumblerVO tumbler){
		int result = service.addTumbler(tumbler);
		return result;
	}
	
	@RequestMapping(value="/charge", method=RequestMethod.POST)
	@ResponseBody
	public int chargeTumbler(int chargeMoney, TumblerVO tumbler){
		System.out.println("charge money : " + chargeMoney);
		int tumbMoney = tumbler.getTumbler_Money();
		int afterMoney = tumbMoney + chargeMoney;
		tumbler.setTumbler_Money(afterMoney);
		int result = service.chargeTumbler(tumbler);
		return result;
	}
}
