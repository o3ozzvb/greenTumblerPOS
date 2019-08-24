package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.OrderDAO;
import com.sinc.greentumbler.vo.OrderDetailVO;
import com.sinc.greentumbler.vo.OrderVO;
import com.sinc.greentumbler.vo.TumblerVO;

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
	
	@Override
	public List<? extends Object> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectOne(Object obj) {
		// TODO Auto-generated method stub
		return null;
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
