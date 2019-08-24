package com.sinc.greentumbler.dto;

import org.springframework.stereotype.Service;

@Service("accountDTO")
public class AccountDTO {
	private String id;
	private String pwd;
	
	public AccountDTO() {}

	public AccountDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", pwd=" + pwd + "]";
	}
}
