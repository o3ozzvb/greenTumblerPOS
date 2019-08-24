package com.sinc.greentumbler.vo;

public class MenuVO {
	private int menu_id;
	private String category1;
	private String category2;
	private String menu_name;
	private int size;
	private int price;
	
	
	public MenuVO() {}
	
	public MenuVO(int menu_id, String category1, String category2, String menu_name, int size, int price) {
		super();
		this.menu_id = menu_id;
		this.category1 = category1;
		this.category2 = category2;
		this.menu_name = menu_name;
		this.size = size;
		this.price = price;
	}
	

	@Override
	public String toString() {
		return "MenuVO [menu_id=" + menu_id + ", category1=" + category1 + ", category2=" + category2 + ", menu_name="
				+ menu_name + ", size=" + size + ", price=" + price + "]";
	}

	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
