package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.AlarmDAO;
import com.sinc.greentumbler.vo.AlarmVO;

@Service("alarmService")
public class AlarmService implements DefaultService { 
	
	@Resource(name="alarmDAO")
	AlarmDAO dao;
	
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
		return dao.insertRow((AlarmVO)(obj));
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
