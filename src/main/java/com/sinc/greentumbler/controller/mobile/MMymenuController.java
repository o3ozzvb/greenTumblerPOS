package com.sinc.greentumbler.controller.mobile;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.service.AccountService;
import com.sinc.greentumbler.service.MenuService;
import com.sinc.greentumbler.service.PrivateMenuService;
import com.sinc.greentumbler.vo.MenuVO;
import com.sinc.greentumbler.vo.PrivateMenuVO;

@Controller
@RequestMapping("/mobile/myMenu")
public class MMymenuController {
	
	@Resource(name="accountService")
	AccountService accountService;
	
	@Resource(name="menuService")
	MenuService menuService;
	
	@Resource(name="privateMenuService")
	PrivateMenuService privateMenuService;
	
	@RequestMapping(value="/getMyMenus/{accountId}", method=RequestMethod.POST)
	@ResponseBody
	public List<PrivateMenuVO> getMyMenus(@PathVariable String accountId){
		List<PrivateMenuVO> myMenus = privateMenuService.selectAll(accountId);
		return myMenus;
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	@ResponseBody
	public List<MenuVO> newPrivateMenu(){
		List<MenuVO> menu = menuService.selectAll();
		return menu;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public int createPrivateMenu(PrivateMenuVO privateMenu){
		int optionPrice = 600;
		MenuVO menu = (MenuVO)menuService.selectOne(privateMenu.getMenu_id());
		int price = menu.getPrice();
		int optionSum = 0;
		optionSum += (privateMenu.getShot() * optionPrice);
		optionSum += (privateMenu.getSyrup() * optionPrice);
		optionSum += (privateMenu.isWhipped_cream() ? 600 : 0);
		optionSum += (privateMenu.isDrizzle() ? 600 : 0);
		price += optionSum;
		
		privateMenu.setOption_sum(optionSum);
		privateMenu.setPrice(price);
		
		return privateMenuService.insertRow(privateMenu);
	}
	
	
	
}
