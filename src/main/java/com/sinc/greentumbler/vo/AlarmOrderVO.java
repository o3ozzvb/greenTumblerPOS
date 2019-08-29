package com.sinc.greentumbler.vo;

public class AlarmOrderVO {
	private int alarm_order_id;
	private int alarm_id;
	private int order_id;
	
	public AlarmOrderVO() {}

	public AlarmOrderVO(int alarm_order_id, int alarm_id, int order_id) {
		super();
		this.alarm_order_id = alarm_order_id;
		this.alarm_id = alarm_id;
		this.order_id = order_id;
	}
	
	public AlarmOrderVO(int alarm_id, int order_id) {
		super();
		this.alarm_id = alarm_id;
		this.order_id = order_id;
	}

	public int getAlarm_order_id() {
		return alarm_order_id;
	}

	public void setAlarm_order_id(int alarm_order_id) {
		this.alarm_order_id = alarm_order_id;
	}

	public int getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "AlarmOrderVO [alarm_order_id=" + alarm_order_id + ", alarm_id=" + alarm_id + ", order_id=" + order_id
		        + "]";
	}
	
}
