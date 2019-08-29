package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.OrderDAO;
import com.sinc.greentumbler.vo.OrderDetailVO;
import com.sinc.greentumbler.vo.OrderVO;
import com.sinc.greentumbler.vo.RecentOrderVO;

@Service("orderService")
public class OrderService implements DefaultService {

	@Resource(name="orderDAO")
	OrderDAO dao;
	
	
	public OrderVO insertRow(OrderVO order) {
		return dao.insertRow(order);
	}
	
	public int insertOrderItem(OrderDetailVO od) {
		return dao.insertOrderItem(od);
	}
	
	public List<OrderDetailVO> selectOrderListWithOrderId(int orderId) {
		return dao.selectOrderListWithOrderId(orderId);
	}
	
	public OrderVO selectOneOrder(int orderId) {
		return dao.selectOneOrder(orderId);
	}
	
	@Override
	public List<? extends Object> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectOne(Object obj) {
		return dao.selectOne((String)obj);
	}
	
	public List<RecentOrderVO> selectOrderListWithAccountId(String account_id) {
		return dao.selectOrderListWithAccountId(account_id);
	}
	
	public List<RecentOrderVO> selectOrderListWithTumblerId(int tumbler_id) {
		return dao.selectOrderListWithTumblerId(tumbler_id);
	}

	@Override
	public int insertRow(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
