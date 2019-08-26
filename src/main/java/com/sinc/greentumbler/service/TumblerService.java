package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.TumblerDAO;
import com.sinc.greentumbler.vo.TumblerVO;

@Service("tumblerService")
public class TumblerService implements DefaultService{

	@Resource(name="tumblerDAO")
	private TumblerDAO dao;
	
	@Override
	public List<? extends Object> selectAll() {
		return null;
	}

	@Override
	public Object selectOne(Object obj) {
		return dao.selectOne((String)obj);
	}

	@Override
	public int insertRow(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public TumblerVO updateRow(TumblerVO tumbler) {
		return dao.updateRow(tumbler);
	}

	@Override
	public int updateRow(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	//get Tumbler List
	public List<TumblerVO> selectTumb(String accountId) {
		System.out.println("service selectTumb");
		return dao.selectTumb(accountId);
	}
	
	//update payYn column 
	public TumblerVO updatePayYn(TumblerVO tumbler) {
		System.out.println("service updatePayYn");
		return dao.updatePayYn(tumbler);
	}
	
	//add new Tumbler
	public int addTumbler(TumblerVO tumbler) {
		System.out.println("service addTumbler");
		return dao.addTumbler(tumbler);
	}

	// charge moeny to Tumbler
	public int chargeTumbler(TumblerVO tumbler) {
		System.out.println("service chargeTumbler");
		return dao.chargeTumbler(tumbler);
	}
	
	
	public TumblerVO selectOneById(int tumblerId) {
		return dao.selectOneById(tumblerId);
	}
	public int lostTumbler(int tumblerId) {
		System.out.println("service lostTumbler");
		return dao.lostTumbler(tumblerId);
	}
}
