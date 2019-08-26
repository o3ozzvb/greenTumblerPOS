package com.sinc.greentumbler.controller.mobile;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.greentumbler.service.OrderService;
import com.sinc.greentumbler.vo.RecentOrderVO;

@Controller
@RequestMapping("/mobile/orderDetails")
public class MOrderDetailController {
	
	@Resource(name="orderService")
	OrderService orderService;
	
	@RequestMapping("/getOrderDetails/{accountId}")
	@ResponseBody
	public Object getOrderDetailsWithTumbler(@PathVariable String accountId) {
		System.out.println(accountId);
		List<RecentOrderVO> list = orderService.selectOrderList(accountId);
		System.out.println(list);
		return list;
	}
}
