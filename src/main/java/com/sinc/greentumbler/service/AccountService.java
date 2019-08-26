package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.AccountDAO;
import com.sinc.greentumbler.vo.AccountVO;
import com.sinc.greentumbler.vo.MenuVO;



@Service("accountService")
public class AccountService implements DefaultService {

	@Resource(name="accountDAO")
	private AccountDAO dao;
	
	@Override
	public List<AccountVO> selectAll() {
		return (List<AccountVO>)dao.selectAll();
	}
	
	public List<MenuVO> getMyMenus(String accountId) {
		return (List<MenuVO>)dao.getMyMenus(accountId);
	}

	@Override
	public Object selectOne(Object obj) {
		String accountId = (String)obj;
		return dao.selectOne(accountId);
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
