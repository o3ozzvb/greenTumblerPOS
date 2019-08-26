package com.sinc.greentumbler.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.AccountVO;
import com.sinc.greentumbler.vo.MenuVO;

@Service("accountDAO")
public class AccountDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public List<AccountVO> selectAll() {
		System.out.println("AccountDAO#selectAll");
		return session.selectList("com.sinc.greentumbler.account.selectAll");
	}
	public AccountVO selectOne(String accountId) {
		System.out.println("AccountDAO#selectOne");
		return session.selectOne("com.sinc.greentumbler.account.selectOne", accountId);
	}
	public List<MenuVO> getMyMenus(String accountId) {
		System.out.println("AccountDAO#getMyMenus");
		return session.selectList("com.sinc.greentumbler.account.getMyMenus", accountId);
	}
}
