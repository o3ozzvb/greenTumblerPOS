package com.sinc.greentumbler.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.service.AccountService;
import com.sinc.greentumbler.service.AlarmService;
import com.sinc.greentumbler.service.MenuService;
import com.sinc.greentumbler.service.OrderService;
import com.sinc.greentumbler.service.PrivateMenuService;
import com.sinc.greentumbler.service.TumblerService;
import com.sinc.greentumbler.vo.AlarmOrderVO;
import com.sinc.greentumbler.vo.AlarmVO;
import com.sinc.greentumbler.vo.MenuVO;
import com.sinc.greentumbler.vo.OrderDetailVO;
import com.sinc.greentumbler.vo.OrderVO;
import com.sinc.greentumbler.vo.PrivateMenuVO;
import com.sinc.greentumbler.vo.RecentOrderVO;
import com.sinc.greentumbler.vo.TumblerVO;


@Controller
@RequestMapping(value="/pos")
public class HomeController extends FCMController {
	@Resource(name="menuService")
	private MenuService  menuService;
	
	@Resource(name="tumblerService")
	private TumblerService tumbService;
	
	@Resource(name="privateMenuService")
	private PrivateMenuService privateMenuService;
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@Resource(name="alarmService")
	private AlarmService alarmService;
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@RequestMapping("/main-test")
	public String mainTest(Model model) {
		List<MenuVO> menu = menuService.selectAll();
		List<TumblerVO> tumbler = (List<TumblerVO>)tumbService.selectAll();
		String menuJson = super.convertToJSON(menu);
		String tumblerJson = super.convertToJSON(tumbler);
		model.addAttribute("menus", menu);
		model.addAttribute("menuJson", menuJson);
		model.addAttribute("tumblers", tumbler);
		model.addAttribute("tumblerJson", tumblerJson);
		return "/pos/main-test";
	}
	
	@RequestMapping("/main")
	public String posMain(Model model) {
		List<MenuVO> menu = menuService.selectAll();
		List<String> category2 = menuService.selectCategory2();
		
		Collections.sort(category2, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.length() - s1.length();
			}
		});
		
		String menuJson = super.convertToJSON(menu);
		model.addAttribute("menus", menuJson);
		System.out.println(menuJson);
		model.addAttribute("category2", category2);
		
		// 샷, 시럽, 
		
		return "/pos/main";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	@ResponseBody
	public TumblerVO getTumbler(String nfcId, HttpSession session) {
		TumblerVO tumbler = (TumblerVO)(tumbService.selectOne(nfcId));
		
		return tumbler;
	}
	
	@RequestMapping(value="/getPrivateMenu", method=RequestMethod.GET)
	@ResponseBody
	public List<PrivateMenuVO> getPrivateMenu(@RequestParam("accountId") String accountId) {
		return privateMenuService.selectAll(accountId);
	}

	@RequestMapping(value="/chargeTumbler", method=RequestMethod.POST)
	@ResponseBody
	public TumblerVO chargeTumbler(TumblerVO tumbler) {
		System.out.println(tumbler);
		tumbler = tumbService.updateRow(tumbler);
		
		// 결제가 정상적으로 이루어 진 경우 알람을 쌓는다.
		System.out.println("Add Alarm");
		
		AlarmVO alarm = new AlarmVO();
		String msg = "";
		String accountId = tumbler.getAccount_id();
		msg += (tumbler.getTumbler_name() + "의 잔액이 " + tumbler.getTumbler_Money() + "원으로 충전되었습니다.");
		alarm.setMsg(msg);
		alarm.setAccount_id(tumbler.getAccount_id());
		alarm.setAlarm_type("charge");
		
		alarmService.insertRow(alarm);
		
		// send message
		super.sendLostMsg(accountId, msg);
		
		return tumbler;
	}
	
	@RequestMapping(value="/pay/{nfcId}", method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public TumblerVO pay(@RequestBody OrderDetailVO[] orderList, @PathVariable String nfcId, HttpSession session) {
		
		TumblerVO tumbler = getTumbler(nfcId, session);
		
		// 잔액이 부족한 경우 고려해야 됨
		
		int price = 0;
		int totalMenuCnt = 0;
		
		for(OrderDetailVO vo : orderList) {
			int menuCnt = vo.getMenu_cnt();
			totalMenuCnt += menuCnt;
			int menuPrice = vo.getPrice();
			int optionSum = vo.getOption_sum();
			price += menuCnt * menuPrice;
			price += optionSum;
		}
		
		if(tumbler.getTumbler_Money() < price) {
			
			return new TumblerVO();
			
		} else {
			OrderVO order = new OrderVO(tumbler.getAccount_id(), tumbler.getTumbler_id(), price, Arrays.asList(orderList));
			order = orderService.insertRow(order);
			
			int orderId = order.getOrder_id();
			
			for(OrderDetailVO od: orderList) { 
				od.setOrder_id(orderId);
				
				orderService.insertOrderItem(od); 
			}
			
			tumbler.setTumbler_Money(tumbler.getTumbler_Money() - order.getPrice());
			tumbler = tumbService.updateRow(tumbler);
			
			if(order.getPrice() == price) {
				// totalMenuCnt 만큼 그린씨드를 추가시켜야 한다.
				int beforeGreenSeed = tumbler.getGreen_seed();
				int afterGreenSeed = tumbler.getGreen_seed() + totalMenuCnt;
				tumbler.setGreen_seed(afterGreenSeed);
				int result = tumbService.updateGreenSeed(tumbler);
				
				
				
				// 결제가 정상적으로 이루어 진 경우 알람을 쌓는다.
				
				AlarmVO alarm = new AlarmVO();
				String accountId = tumbler.getAccount_id();
				
				String msg = "결제가 성공적으로 수행되었습니다.";
				alarm.setMsg(msg);
				alarm.setAccount_id(order.getAccount_id());
				alarm.setAlarm_type("pay");
				alarm.setOrder_id(order.getOrder_id());
				alarm = alarmService.insertRow(alarm);
				
				AlarmOrderVO alarmOrder = new AlarmOrderVO(alarm.getAlarm_id(), order.getOrder_id());
				alarmService.insertAlarmOrder(alarmOrder);
				
				// send fcm message
				super.sendLostMsg(accountId, msg);
				
				if(result > 0 && beforeGreenSeed < 150 && afterGreenSeed >= 150) {
					super.sendLostMsg(accountId, "축하합니다 ! 그린씨드 150개 달성을 성공하였습니다.");
				}
				
			}
			return tumbler;
		}
		
	}
	
	@RequestMapping(value="/getRecentOrder/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public Object getRecntOrder(@PathVariable String accountId) {
		System.out.println(accountId);
		System.out.println((RecentOrderVO)(orderService.selectOne(accountId)));
		return orderService.selectOne(accountId);
	}
	
	@RequestMapping(value="/recipe", method=RequestMethod.GET)
	public String showRecipe(Model model) {
		return "/pos/recipe";
	}
	
	@RequestMapping(value="/recipe-past", method=RequestMethod.GET)
	public String showRecipePast(Model model) {
		return "/pos/recipe_past";
	}
	
	@RequestMapping(value="/getRecipe", method=RequestMethod.POST)
	@ResponseBody
	public RecentOrderVO getRecipe(String nfcId) {
		TumblerVO tumbler = (TumblerVO)(tumbService.selectOne(nfcId));
		RecentOrderVO recntOrder = (RecentOrderVO)(orderService.selectOne(tumbler.getAccount_id()));
		System.out.println(recntOrder);
		return recntOrder;
	}
	
	@RequestMapping(value="/addLostAlarm", method=RequestMethod.POST)
	@ResponseBody
	public AlarmVO addLostAlarm(TumblerVO tumbler) {
		AlarmVO alarm = new AlarmVO();
		String msg = "";
		String accountId = tumbler.getAccount_id();
		
		msg += ("분실된 " + tumbler.getTumbler_name() + " 가 남산스테이트점에서 조회되었습니다.");
		alarm.setMsg(msg);
		alarm.setAccount_id(tumbler.getAccount_id());
		alarm.setAlarm_type("lost");
		
		AlarmVO resultAlarm = alarmService.insertRow(alarm);
		
		super.sendLostMsg(accountId, msg);
		return resultAlarm;
		
	}
	
	
}
