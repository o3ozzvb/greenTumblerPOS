package com.sinc.greentumbler.vo;

public class AlarmVO {
	private int alarm_id;
	private String msg;
	private String account_id;
	private String alarm_type;
	private String alarm_time;

	private int order_id;
	
	public AlarmVO() {}
	
	public AlarmVO(int alarm_id, String msg, String account_id, String alarm_type, String alarm_time, int order_id) {
		super();
		this.alarm_id = alarm_id;
		this.msg = msg;
		this.account_id = account_id;
		this.alarm_type = alarm_type;
		this.alarm_time = alarm_time;
		this.order_id = order_id;
	}

	public String getAlarm_time() {
		return alarm_time;
	}

	public void setAlarm_time(String alarm_time) {
		this.alarm_time = alarm_time;
	}



	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getAlarm_type() {
		return alarm_type;
	}

	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}

	@Override
	public String toString() {
		return "AlarmVO [alarm_id=" + alarm_id + ", msg=" + msg + ", account_id=" + account_id + ", alarm_type="
		        + alarm_type + ", alarm_time=" + alarm_time + ", order_id=" + order_id + "]";
	}

}
