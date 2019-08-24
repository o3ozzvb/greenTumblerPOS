package com.sinc.greentumbler.service;

import java.util.List;

public interface DefaultService {
	public List<? extends Object> selectAll();
	public Object 	selectOne(Object obj);
	public int 		insertRow(Object obj);
	public int 		deleteRow(Object obj);
	public int 		updateRow(Object obj);
}