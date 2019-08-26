package com.sinc.greentumbler.vo;

import org.springframework.stereotype.Service;

@Service("tumblerVO")
public class TumblerVO {
	//tumbler attributes
	
	private String tumbler_id;
	private String nfc_id;
	private String account_id;
	private String tumbler_name;
	private String tumbler_pin;
	private int size;
	private int tumbler_Money;
	private int green_seed; 
	private boolean lost_yn;
	private boolean pay_yn;
	private int private_menu_id;	
	
	private String nickName;
	
	public TumblerVO() {
		
	}

	public TumblerVO(String tumbler_id, String nfc_id, String account_id, String tumbler_name, String tumbler_pin,
			int size, int tumbler_Money, int green_seed, boolean lost_yn, boolean pay_yn, int private_menu_id,
			String nickName) {
		super();
		this.tumbler_id = tumbler_id;
		this.nfc_id = nfc_id;
		this.account_id = account_id;
		this.tumbler_name = tumbler_name;
		this.tumbler_pin = tumbler_pin;
		this.size = size;
		this.tumbler_Money = tumbler_Money;
		this.green_seed = green_seed;
		this.lost_yn = lost_yn;
		this.pay_yn = pay_yn;
		this.private_menu_id = private_menu_id;
		this.nickName = nickName;
	}

	public String getTumbler_id() {
		return tumbler_id;
	}

	public void setTumbler_id(String tumbler_id) {
		this.tumbler_id = tumbler_id;
	}

	public String getNfc_id() {
		return nfc_id;
	}

	public void setNfc_id(String nfc_id) {
		this.nfc_id = nfc_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getTumbler_name() {
		return tumbler_name;
	}

	public void setTumbler_name(String tumbler_name) {
		this.tumbler_name = tumbler_name;
	}

	public String getTumbler_pin() {
		return tumbler_pin;
	}

	public void setTumbler_pin(String tumbler_pin) {
		this.tumbler_pin = tumbler_pin;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTumbler_Money() {
		return tumbler_Money;
	}

	public void setTumbler_Money(int tumbler_Money) {
		this.tumbler_Money = tumbler_Money;
	}

	public int getGreen_seed() {
		return green_seed;
	}

	public void setGreen_seed(int green_seed) {
		this.green_seed = green_seed;
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

	public int getPrivate_menu_id() {
		return private_menu_id;
	}

	public void setPrivate_menu_id(int private_menu_id) {
		this.private_menu_id = private_menu_id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "TumblerVO [tumbler_id=" + tumbler_id + ", nfc_id=" + nfc_id + ", account_id=" + account_id
				+ ", tumbler_name=" + tumbler_name + ", tumbler_pin=" + tumbler_pin + ", size=" + size
				+ ", tumbler_Money=" + tumbler_Money + ", green_seed=" + green_seed + ", lost_yn=" + lost_yn
				+ ", pay_yn=" + pay_yn + ", private_menu_id=" + private_menu_id + ", nickName=" + nickName + "]";
	}

}
