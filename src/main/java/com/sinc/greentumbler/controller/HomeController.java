package com.sinc.greentumbler.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.service.MenuService;
import com.sinc.greentumbler.service.OrderService;
import com.sinc.greentumbler.service.PrivateMenuService;
import com.sinc.greentumbler.service.TumblerService;
import com.sinc.greentumbler.vo.MenuVO;
import com.sinc.greentumbler.vo.OrderDetailVO;
import com.sinc.greentumbler.vo.OrderVO;
import com.sinc.greentumbler.vo.PrivateMenuVO;
import com.sinc.greentumbler.vo.TumblerVO;


@Controller
@RequestMapping(value="/pos")
public class HomeController extends ApplicationController {
	@Resource(name="menuService")
	private MenuService  menuService;
	
	@Resource(name="tumblerService")
	private TumblerService tumbService;
	
	@Resource(name="privateMenuService")
	private PrivateMenuService privateMenuService;
	
	@Resource(name="orderService")
	private OrderService orderService;
	
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
		
		String menuJson = null;
		try {
			menuJson = new ObjectMapper().writeValueAsString(menu);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("menus", menuJson);
		model.addAttribute("category2", category2);
		
		// 샷, 시럽, 
		
		return "/pos/main";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	@ResponseBody
	public TumblerVO getTumbler(String nfcId, HttpSession session) {
		TumblerVO tumbler = (TumblerVO)(tumbService.selectOne(nfcId));
		
		// updateTumblerInfo(tumbler, session);
		
		String tumblerJson = "";
		try {
			tumblerJson = new ObjectMapper().writeValueAsString(tumbler);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.removeAttribute("tumblerJson");
		session.removeAttribute("tumbler");
		session.setAttribute("tumblerJson", tumblerJson);
		session.setAttribute("tumbler", tumbler);
		
		return tumbler;
	}
	
	@RequestMapping(value="/getPrivateMenu", method=RequestMethod.GET)
	@ResponseBody
	// public List<PrivateMenuVO> getPrivateMenu(TumblerVO tumbler) {
	public List<PrivateMenuVO> getPrivateMenu(@RequestParam("accountId") String accountId) {
		//return privateMenuService.selectAll(tumbler.getAccount_id());
		System.out.println(accountId);
		return privateMenuService.selectAll(accountId);
	}

	@RequestMapping(value="/chargeTumbler", method=RequestMethod.POST)
	@ResponseBody
	public TumblerVO chargeTumbler(TumblerVO tumbler) {
		System.out.println(tumbler);
		return tumbService.updateRow(tumbler);
	}
	
	@RequestMapping(value="/pay", method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public TumblerVO pay(@RequestBody OrderDetailVO[] orderList, HttpSession session) {
		
		// 잔액이 부족한 경우 고려해야 됨
		
		int price = 0;
		for(OrderDetailVO vo : orderList) {
			int menuCnt = vo.getMenu_cnt();
			int menuPrice = vo.getPrice();
			price += menuCnt * menuPrice;
		}
		
		TumblerVO tumbler = (TumblerVO) session.getAttribute("tumbler");
		
		if(tumbler.getTumbler_Money() < price) {
			
			return new TumblerVO();
			
		} else {
			OrderVO order = new OrderVO(tumbler.getAccount_id(), tumbler.getTumbler_id(), price, Arrays.asList(orderList));
			order = orderService.insertRow(order);
			int orderId = order.getOrder_id();
			
			//
			/*
			 * for(OrderDetailVO od: orderList) { od.setOrder_id(orderId);
			 * System.out.println(od); orderService.insertOrderItem(od); }
			 */
			
			orderList[0].setOrder_id(orderId);
			orderService.insertOrderItem(orderList[0]);
			tumbler.setTumbler_Money(tumbler.getTumbler_Money() - order.getPrice());
			return tumbService.updateRow(tumbler);
			
		}
		
	}
	
	public void updateTumblerInfo(TumblerVO tumbler, HttpSession session) {
		String tumblerJson = "";
		try {
			tumblerJson = new ObjectMapper().writeValueAsString(tumbler);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.removeAttribute("tumblerJson");
		session.removeAttribute("tumbler");
		session.setAttribute("tumblerJson", tumblerJson);
		session.setAttribute("tumbler", tumbler);
	}
}
