package com.sinc.greentumbler.vo;

public class MenuVO {
	private int menu_id;
	private String category1;
	private String category2;
	private String menu_name;
	private String size;
	private String image;
	private int price;
	
	
	public MenuVO() {}
	
	public MenuVO(int menu_id, String category1, String category2, String menu_name, String size, String image,
			int price) {
		super();
		this.menu_id = menu_id;
		this.category1 = category1;
		this.category2 = category2;
		this.menu_name = menu_name;
		this.size = size;
		this.image = image;
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "MenuVO [menu_id=" + menu_id + ", category1=" + category1 + ", category2=" + category2 + ", menu_name="
				+ menu_name + ", size=" + size + ", image=" + image + ", price=" + price + "]";
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
