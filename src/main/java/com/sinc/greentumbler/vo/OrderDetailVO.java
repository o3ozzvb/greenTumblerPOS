package com.sinc.greentumbler.vo;

public class OrderDetailVO {
	private int order_id;
	private int line_id;
	private boolean private_menu_yn;
	private int private_menu_id;
	private int menu_id;
	private boolean is_tumbler;
	private int shot;
	private int syrup;
	private boolean whipped_cream;
	private boolean drizzle;
	private String size;
	private int option_sum;
	private int menu_cnt;
	private int price;
	
	private String menu_name;
	private String cup;
	private String category2;
	
	public OrderDetailVO() {}

	public OrderDetailVO(int order_id, int line_id, boolean private_menu_yn, int private_menu_id, int menu_id,
			boolean is_tumbler, int shot, int syrup, boolean whipped_cream, boolean drizzle, String size,
			int option_sum, int menu_cnt, int price, String menu_name, String cup, String category2) {
		super();
		this.order_id = order_id;
		this.line_id = line_id;
		this.private_menu_yn = private_menu_yn;
		this.private_menu_id = private_menu_id;
		this.menu_id = menu_id;
		this.is_tumbler = is_tumbler;
		this.shot = shot;
		this.syrup = syrup;
		this.whipped_cream = whipped_cream;
		this.drizzle = drizzle;
		this.size = size;
		this.option_sum = option_sum;
		this.menu_cnt = menu_cnt;
		this.price = price;
		this.menu_name = menu_name;
		this.cup = cup;
		this.category2 = category2;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}



	public String getCup() {
		return cup;
	}



	public void setCup(String cup) {
		this.cup = cup;
	}



	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getLine_id() {
		return line_id;
	}

	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}

	public boolean getPrivate_menu_yn() {
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

	public boolean getIs_tumbler() {
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

	public boolean getWhipped_cream() {
		return whipped_cream;
	}

	public void setWhipped_cream(boolean whipped_cream) {
		this.whipped_cream = whipped_cream;
	}

	public boolean getDrizzle() {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [order_id=" + order_id + ", line_id=" + line_id + ", private_menu_yn=" + private_menu_yn
				+ ", private_menu_id=" + private_menu_id + ", menu_id=" + menu_id + ", is_tumbler=" + is_tumbler
				+ ", shot=" + shot + ", syrup=" + syrup + ", whipped_cream=" + whipped_cream + ", drizzle=" + drizzle
				+ ", size=" + size + ", option_sum=" + option_sum + ", menu_cnt=" + menu_cnt + ", price=" + price
				+ ", menu_name=" + menu_name + ", cup=" + cup + ", category2=" + category2 + "]";
	}
	
}


