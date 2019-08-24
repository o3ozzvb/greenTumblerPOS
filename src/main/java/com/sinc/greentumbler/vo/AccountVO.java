package com.sinc.greentumbler.vo;

import org.springframework.stereotype.Service;

@Service("accountVO")
public class AccountVO {
	private String id;
	private String pwd;
	private String nickName;
	private String starType;
	private int starCnt;
	
	public AccountVO() {}
	
	public AccountVO(String id, String pwd, String nickName, String starType, int starCnt) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nickName = nickName;
		this.starType = starType;
		this.starCnt = starCnt;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStarType() {
		return starType;
	}

	public void setStarType(String starType) {
		this.starType = starType;
	}

	public int getStarCnt() {
		return starCnt;
	}

	public void setStarCnt(int starCnt) {
		this.starCnt = starCnt;
	}

	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", pwd=" + pwd + ", nickName=" + nickName + ", starType=" + starType
				+ ", starCnt=" + starCnt + "]";
	}

}
