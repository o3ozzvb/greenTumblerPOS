package com.sinc.greentumbler.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.MenuVO;

@Service("menuDAO")
public class MenuDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public List<MenuVO> selectAll() {
		return session.selectList("com.sinc.greentumbler.menu.selectAll");
	}
	
	public List<String> selectCategory2() {
		return session.selectList("com.sinc.greentumbler.menu.selectCategory2");
	}
}
