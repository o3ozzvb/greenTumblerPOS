package com.sinc.greentumbler.vo;

public class RecentOrderVO {
	private int order_id;
	private String account_id;
	private String order_time;
	private int price;
	private String store_name;
	private int tumbler_id;
	
	private int line_id;
	private boolean private_menu_yn;
	private int private_menu_id;
	private int menu_id;
	private String menu_name;
	private boolean is_tumbler;
	private int shot;
	private int syrup;
	private boolean whipped_cream;
	private boolean drizzle;
	private String size;
	private int option_sum;
	private int menu_cnt;
	private int detail_price;
	
	public RecentOrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public RecentOrderVO(int order_id, String account_id, String order_time, int price, String store_name, int tumbler_id,
			int line_id, boolean private_menu_yn, int private_menu_id, int menu_id, String menu_name,
			boolean is_tumbler, int shot, int syrup, boolean whipped_cream, boolean drizzle, String size,
			int option_sum, int menu_cnt, int detail_price) {
		super();
		this.order_id = order_id;
		this.account_id = account_id;
		this.order_time = order_time;
		this.price = price;
		this.store_name = store_name;
		this.tumbler_id = tumbler_id;
		this.line_id = line_id;
		this.private_menu_yn = private_menu_yn;
		this.private_menu_id = private_menu_id;
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.is_tumbler = is_tumbler;
		this.shot = shot;
		this.syrup = syrup;
		this.whipped_cream = whipped_cream;
		this.drizzle = drizzle;
		this.size = size;
		this.option_sum = option_sum;
		this.menu_cnt = menu_cnt;
		this.detail_price = detail_price;
	}



	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
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

	public int getLine_id() {
		return line_id;
	}

	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}

	public boolean isPrivate_menu_yn() {
		return private_menu_yn;
	}

	public void setPrivate_menu_yn(boolean private_menu_yn) {
		this.private_menu_yn = private_menu_yn;
	}

	public int getPrivate_menu_id() {
		return private_menu_id;
	}

	public void setPrivate_menu_id(int private_menu_id) {
		this.private_menu_id = private_menu_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}


	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	public boolean isIs_tumbler() {
		return is_tumbler;
	}

	public void setIs_tumbler(boolean is_tumbler) {
		this.is_tumbler = is_tumbler;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public int getSyrup() {
		return syrup;
	}

	public void setSyrup(int syrup) {
		this.syrup = syrup;
	}

	public boolean isWhipped_cream() {
		return whipped_cream;
	}

	public void setWhipped_cream(boolean whipped_cream) {
		this.whipped_cream = whipped_cream;
	}

	public boolean isDrizzle() {
		return drizzle;
	}

	public void setDrizzle(boolean drizzle) {
		this.drizzle = drizzle;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getOption_sum() {
		return option_sum;
	}

	public void setOption_sum(int option_sum) {
		this.option_sum = option_sum;
	}

	public int getMenu_cnt() {
		return menu_cnt;
	}

	public void setMenu_cnt(int menu_cnt) {
		this.menu_cnt = menu_cnt;
	}

	public int getDetail_price() {
		return detail_price;
	}

	public void setDetail_price(int detail_price) {
		this.detail_price = detail_price;
	}

	@Override
	public String toString() {
		return "OrderVO [order_id=" + order_id + ", account_id=" + account_id + ", order_time=" + order_time
				+ ", price=" + price + ", store_name=" + store_name + ", tumbler_id=" + tumbler_id + ", line_id="
				+ line_id + ", private_menu_yn=" + private_menu_yn + ", private_menu_id=" + private_menu_id
				+ ", menu_id=" + menu_id + ", is_tumbler=" + is_tumbler + ", shot=" + shot + ", syrup=" + syrup
				+ ", whipped_cream=" + whipped_cream + ", drizzle=" + drizzle + ", size=" + size + ", option_sum="
				+ option_sum + ", menu_cnt=" + menu_cnt + ", detail_price=" + detail_price + "]";
	}
	
	
}