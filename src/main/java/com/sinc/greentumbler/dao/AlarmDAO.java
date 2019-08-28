package com.sinc.greentumbler.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.greentumbler.vo.AlarmVO;

@Service("alarmDAO")
public class AlarmDAO {
	
	@Resource(name="sqlSession")
	SqlSession session;
	
	public int insertRow(AlarmVO alarm) {
		return session.insert("com.sinc.greentumbler.alarm.insertRow", alarm);
	}
}
