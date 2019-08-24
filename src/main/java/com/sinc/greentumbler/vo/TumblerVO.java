package com.sinc.greentumbler.vo;

import org.springframework.stereotype.Service;

@Service("tumblerVO")
public class TumblerVO {
	private int tumbler_Money;
	private String account_id;
	private String nickName;
	private boolean lost_yn;
	private boolean pay_yn;
	
	//where condition
	private int tumbler_id;
	private String nfc_id;
	
	public TumblerVO() {
		
	}

	public TumblerVO(int tumbler_Money, String account_id, String nickName, boolean lost_yn, boolean pay_yn,
			int tumbler_id, String nfc_id) {
		super();
		this.tumbler_Money = tumbler_Money;
		this.account_id = account_id;
		this.nickName = nickName;
		this.lost_yn = lost_yn;
		this.pay_yn = pay_yn;
		this.tumbler_id = tumbler_id;
		this.nfc_id = nfc_id;
	}

	public int getTumbler_Money() {
		return tumbler_Money;
	}

	public void setTumbler_Money(int tumbler_Money) {
		this.tumbler_Money = tumbler_Money;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isLost_yn() {
		return lost_yn;
	}

	public void setLost_yn(boolean lost_yn) {
		this.lost_yn = lost_yn;
	}

	public boolean isPay_yn() {
		return pay_yn;
	}

	public void setPay_yn(boolean pay_yn) {
		this.pay_yn = pay_yn;
	}

	public int getTumbler_id() {
		return tumbler_id;
	}

	public void setTumbler_id(int tumbler_id) {
		this.tumbler_id = tumbler_id;
	}

	public String getNfc_id() {
		return nfc_id;
	}

	public void setNfc_id(String nfc_id) {
		this.nfc_id = nfc_id;
	}

	@Override
	public String toString() {
		return "TumblerVO [tumbler_Money=" + tumbler_Money + ", account_id=" + account_id + ", nickName=" + nickName
				+ ", lost_yn=" + lost_yn + ", pay_yn=" + pay_yn + ", tumbler_id=" + tumbler_id + ", nfc_id=" + nfc_id
				+ "]";
	}
	
	
	
	
}
