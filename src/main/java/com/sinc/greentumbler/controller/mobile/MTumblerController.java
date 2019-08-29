package com.sinc.greentumbler.controller.mobile;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.controller.FCMController;
import com.sinc.greentumbler.service.AccountService;
import com.sinc.greentumbler.service.AlarmService;
import com.sinc.greentumbler.service.TumblerService;
import com.sinc.greentumbler.vo.AlarmVO;
import com.sinc.greentumbler.vo.TumblerVO;

@Controller
@RequestMapping("/mobile/tumbler")
public class MTumblerController extends FCMController {
	@Resource(name="tumblerService")
	private TumblerService service;
	@Resource(name="accountService")
	private AccountService accountService;
	@Resource(name="alarmService")
	private AlarmService alarmService;
	
	@RequestMapping(value="/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public List<TumblerVO> getTumbler(@PathVariable String accountId){
		List<TumblerVO> tumblerList = service.selectTumb(accountId);
		
		return tumblerList;
	}
	
	@RequestMapping(value="getTumblerById/{tumblerId}", method=RequestMethod.POST)
	@ResponseBody
	public TumblerVO getTumblerById(@PathVariable int tumblerId){
		TumblerVO tumbler = service.selectOneById(tumblerId);
		
		return tumbler;
	}
	
	@RequestMapping(value="/payYn", method=RequestMethod.POST)
	@ResponseBody
	public TumblerVO updatePayYn(TumblerVO tumbler){
		TumblerVO result = service.updatePayYn(tumbler);
		return result;
	}
	
	@RequestMapping(value="/create/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public int addTumbler(@PathVariable String accountId, TumblerVO tumbler){
		System.out.println("tumbler : " + tumbler);
		tumbler.setAccount_id(accountId);
		int result = service.addTumblerWithPIN(tumbler);
		return result;
	}
	
	@RequestMapping(value="/create-nfc/{accountId}/{tumblerId}", method=RequestMethod.POST)
	@ResponseBody
	public int addTumblerWithNFC(@PathVariable String accountId, @PathVariable int tumblerId){
		TumblerVO tumbler = service.selectOneByTumblerId(tumblerId);
		tumbler.setAccount_id(accountId);
		int result = service.addTumbler(tumbler);
		return result;
	}
	
	@RequestMapping(value="/charge/{chargeMoney}", method=RequestMethod.POST)
	@ResponseBody
	public int chargeTumbler(@PathVariable int chargeMoney, TumblerVO tumbler){
		System.out.println("charge money : ");
		int tumbMoney = tumbler.getTumbler_Money();
		int afterMoney = tumbMoney + chargeMoney;
		tumbler = service.selectOneById(tumbler.getTumbler_id());
		tumbler.setTumbler_Money(afterMoney);
		int result = service.chargeTumbler(tumbler);
		
		// KHJ 8월 29일 추가
		AlarmVO alarm = new AlarmVO();
		String accountId = tumbler.getAccount_id();
		String msg = (tumbler.getTumbler_name() + "의 잔액이 " + tumbler.getTumbler_Money() + "원으로 충전되었습니다.");
		alarm.setMsg(msg);
		alarm.setAccount_id(tumbler.getAccount_id());
		alarm.setAlarm_type("charge");
		alarmService.insertRow(alarm);
		
		super.sendLostMsg(accountId, msg);
		
		return result;
	}
	
	@RequestMapping(value="/greenSeed/{tumblerId}", method=RequestMethod.POST)
	@ResponseBody
	public int getGreenSeed(@PathVariable int tumblerId){
		System.out.println("tumblerId : " + tumblerId);
		TumblerVO tumbler = service.selectOneById(tumblerId);
		return tumbler.getGreen_seed();
	}
	@RequestMapping(value="/lost", method=RequestMethod.POST)
	@ResponseBody
	public int lostTumbler(int tumblerId){
		int result = service.lostTumbler(tumblerId);
		return result;
	}
}
