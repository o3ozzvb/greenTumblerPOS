package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.PrivateMenuDAO;
import com.sinc.greentumbler.vo.PrivateMenuVO;

@Service("privateMenuService")
public class PrivateMenuService implements DefaultService {

	@Resource(name="privateMenuDAO")
	private PrivateMenuDAO dao;
	
	public List<PrivateMenuVO> selectAll(String accountId) {
		return dao.selectAll(accountId);
	}
	
	@Override
	public List<Object> selectAll() {
		return null;
	}

	@Override
	public Object selectOne(Object obj) {
		return null;
	}

	@Override
	public int insertRow(Object obj) {
		PrivateMenuVO privateMenu = (PrivateMenuVO)obj;
		return dao.insertRow(privateMenu);
	}

	@Override
	public int deleteRow(Object object) {
		return 0;
	}

	@Override
	public int updateRow(Object object) {
		return 0;
	}

}
