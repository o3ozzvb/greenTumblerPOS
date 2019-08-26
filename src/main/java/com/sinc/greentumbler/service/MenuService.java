package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.MenuDAO;
import com.sinc.greentumbler.vo.MenuVO;

@Service("menuService")
public class MenuService implements DefaultService {

	@Resource(name="menuDAO")
	private MenuDAO dao;
	
	public List<String> selectCategory2() {
		return dao.selectCategory2();
	}
	
	@Override
	public List<MenuVO> selectAll() {
		return (List<MenuVO>)dao.selectAll();
	}

	@Override
	public Object selectOne(Object obj) {
		int menuId = (Integer)obj;
		
		return dao.selectOne(menuId);
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

	@Override
	public int updateRow(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
