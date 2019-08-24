package com.sinc.greentumbler.vo;

public class PrivateMenuVO {
	private String cup;
	private String account_id;
	private int menu_id;
	private int shot;
	private int syrup;
	private boolean whipped_cream;
	private boolean drizzle;
	private String size;
	private int option_sum;
	private int price;
	private String menu_name;
	
	public PrivateMenuVO() {}
	
	public PrivateMenuVO(String cup, String account_id, int menu_id, int shot, int syrup, boolean whipped_cream,
	        boolean drizzle, String size, int option_sum, int price, String menu_name) {
		super();
		this.cup = cup;
		this.account_id = account_id;
		this.menu_id = menu_id;
		this.shot = shot;
		this.syrup = syrup;
		this.whipped_cream = whipped_cream;
		this.drizzle = drizzle;
		this.size = size;
		this.option_sum = option_sum;
		this.price = price;
		this.menu_name = menu_name;
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
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PrivateMenuVO [cup=" + cup + ", account_id=" + account_id + ", menu_id=" + menu_id + ", shot=" + shot
		        + ", syrup=" + syrup + ", whipped_cream=" + whipped_cream + ", drizzle=" + drizzle + ", size=" + size
		        + ", option_sum=" + option_sum + ", price=" + price + ", menu_name=" + menu_name + "]";
	}
	
}
