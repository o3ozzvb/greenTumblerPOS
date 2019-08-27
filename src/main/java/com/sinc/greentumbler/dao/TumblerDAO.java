package com.sinc.greentumbler.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.TumblerVO;

@Service("tumblerDAO")
public class TumblerDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public List<TumblerVO> selectAll() {
		return session.selectList("com.sinc.greentumbler.tumbler.selectAll");
	}
	
	public TumblerVO selectOne(String nfcId) {
		return session.selectOne("com.sinc.greentumbler.tumbler.selectOne", nfcId);
	}
	
	public TumblerVO updateRow(TumblerVO tumbler) {
		System.out.println(session.selectOne("com.sinc.greentumbler.tumbler.updateRow", tumbler));
		return session.selectOne("com.sinc.greentumbler.tumbler.updateRow", tumbler);
	}
	
	public List<TumblerVO> selectTumb(String accountId) {
		System.out.println(session.selectList("com.sinc.greentumbler.tumbler.selectTumb", accountId));
		return session.selectList("com.sinc.greentumbler.tumbler.selectTumb", accountId);
	}
	
	public TumblerVO updatePayYn(TumblerVO tumbler) {
		System.out.println(session.selectOne("com.sinc.greentumbler.tumbler.updatePayYn",tumbler));
		return session.selectOne("com.sinc.greentumbler.tumbler.updatePayYn",tumbler);
	}
	
	public int addTumbler(TumblerVO tumbler) {
		System.out.println(session.update("com.sinc.greentumbler.tumbler.addTumbler",tumbler));
		return session.update("com.sinc.greentumbler.tumbler.addTumbler",tumbler);
	}
	
	public int chargeTumbler(TumblerVO tumbler) {
		System.out.println(session.update("com.sinc.greentumbler.tumbler.chargeTumbler",tumbler));
		return session.update("com.sinc.greentumbler.tumbler.chargeTumbler",tumbler);
	}
	
	public TumblerVO selectOneById(int tumblerId) {
		return session.selectOne("com.sinc.greentumbler.tumbler.selectOneById", tumblerId);
	}
	public int lostTumbler(int tumblerId) {
		System.out.println(session.update("com.sinc.greentumbler.tumbler.lostTumbler",tumblerId));
		return session.update("com.sinc.greentumbler.tumbler.lostTumbler",tumblerId);
	}
	
}
