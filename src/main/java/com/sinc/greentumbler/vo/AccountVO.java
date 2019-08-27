package com.sinc.greentumbler.vo;

import org.springframework.stereotype.Service;

@Service("accountVO")
public class AccountVO {
	private String account_id;
	private String pwd;
	private String nickname;
	private String star_type;
	private int star_cnt;
	private String fcm_token;
	
	public AccountVO() {}

	

	public AccountVO(String account_id, String pwd, String nickname, String star_type, int star_cnt, String fcm_token) {
		super();
		this.account_id = account_id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.star_type = star_type;
		this.star_cnt = star_cnt;
		this.fcm_token = fcm_token;
	}

	public String getFcm_token() {
		return fcm_token;
	}

	public void setFcm_token(String fcm_token) {
		this.fcm_token = fcm_token;
	}



	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getStar_type() {
		return star_type;
	}

	public void setStar_type(String star_type) {
		this.star_type = star_type;
	}

	public int getStar_cnt() {
		return star_cnt;
	}

	public void setStar_cnt(int star_cnt) {
		this.star_cnt = star_cnt;
	}



	@Override
	public String toString() {
		return "AccountVO [account_id=" + account_id + ", pwd=" + pwd + ", nickname=" + nickname + ", star_type="
		        + star_type + ", star_cnt=" + star_cnt + ", fcm_token=" + fcm_token + "]";
	}

	

}
