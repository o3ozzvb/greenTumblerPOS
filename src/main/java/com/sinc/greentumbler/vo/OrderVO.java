package com.sinc.greentumbler.vo;

import java.util.List;

public class OrderVO {
	private String account_id;
	private int order_id;
	private String order_time;
	private int price;
	private String store_name;
	private int tumbler_id;
	private List<OrderDetailVO> orderList;
	
	public OrderVO() {}
	
	public OrderVO(String account_id, int tumbler_id, int price, List<OrderDetailVO> orderList) {
		this.account_id = account_id;
		this.tumbler_id = tumbler_id;
		this.price = price;
		this.orderList = orderList;
	}
	
	public OrderVO(String account_id, int order_id, String order_time, int price, String store_name, int tumbler_id,
			List<OrderDetailVO> orderList) {
		super();
		this.account_id = account_id;
		this.order_id = order_id;
		this.order_time = order_time;
		this.price = price;
		this.store_name = store_name;
		this.tumbler_id = tumbler_id;
		this.orderList = orderList;
	}
	
	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public List<OrderDetailVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderDetailVO> orderList) {
		this.orderList = orderList;
	}

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public int getTumbler_id() {
		return tumbler_id;
	}
	public void setTumbler_id(int tumbler_id) {
		this.tumbler_id = tumbler_id;
	}

	@Override
	public String toString() {
		return "OrderVO [account_id=" + account_id + ", order_id=" + order_id + ", order_time=" + order_time
				+ ", price=" + price + ", store_name=" + store_name + ", tumbler_id=" + tumbler_id + ", orderList="
				+ orderList + "]";
	}
	
	
}
