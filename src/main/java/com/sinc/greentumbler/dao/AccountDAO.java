package com.sinc.greentumbler.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.AccountVO;

@Service("accountDAO")
public class AccountDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public List<AccountVO> selectAll() {
		System.out.println("AccountDAO#selectAll");
		return session.selectList("com.sinc.greentumbler.account.selectAll");
	}
}
