package com.sinc.greentumbler.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.OrderDetailVO;
import com.sinc.greentumbler.vo.OrderVO;
import com.sinc.greentumbler.vo.TumblerVO;

@Service("orderDAO")
public class OrderDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public OrderVO insertRow(OrderVO order) {
		System.out.println(order);
		return session.selectOne("com.sinc.greentumbler.order.insertRow", order);
	}
	
	public int insertOrderItem(OrderDetailVO od) {
		return session.insert("com.sinc.greentumbler.order.insertOrderItem", od);
	}
}
