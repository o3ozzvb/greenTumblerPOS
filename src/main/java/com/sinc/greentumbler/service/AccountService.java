package com.sinc.greentumbler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.greentumbler.dao.AccountDAO;
import com.sinc.greentumbler.vo.AccountVO;



@Service("accountService")
public class AccountService implements DefaultService {

	@Resource(name="accountDAO")
	private AccountDAO dao;
	
	@Override
	public List<AccountVO> selectAll() {
		return (List<AccountVO>)dao.selectAll();
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
