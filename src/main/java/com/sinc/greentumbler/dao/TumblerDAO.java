package com.sinc.greentumbler.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.TumblerVO;

@Service("tumblerDAO")
public class TumblerDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public TumblerVO selectOne(String nfcId) {
		return session.selectOne("com.sinc.greentumbler.tumbler.selectOne", nfcId);
	}
	
	public TumblerVO updateRow(TumblerVO tumbler) {
		System.out.println(session.selectOne("com.sinc.greentumbler.tumbler.updateRow", tumbler));
		return session.selectOne("com.sinc.greentumbler.tumbler.updateRow", tumbler);
	}
	
}
