package com.sinc.greentumbler.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.PrivateMenuVO;

@Service("privateMenuDAO")
public class PrivateMenuDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public List<PrivateMenuVO> selectAll(String accountId) {
		return session.selectList("com.sinc.greentumbler.privateMenu.selectAll", accountId);
	}
}
