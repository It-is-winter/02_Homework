package com.kh.delivery.model.dto;

public class MenuDto {
	private Integer menuNo;
	private Integer restNo;
	private String menuName;
	private int price;
	private Character soldOut;
	public MenuDto() {
		super();
	}
	public MenuDto(Integer menuNo, String menuName, int price, Character soldOut) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.price = price;
		this.soldOut = soldOut;
	}
	public MenuDto(Integer menuNo, Integer restNo, String menuName, int price, Character soldOut) {
		super();
		this.menuNo = menuNo;
		this.restNo = restNo;
		this.menuName = menuName;
		this.price = price;
		this.soldOut = soldOut;
	}
	public Integer getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(Integer menuNo) {
		this.menuNo = menuNo;
	}
	public Integer getRestNo() {
		return restNo;
	}
	public void setRestNo(Integer restNo) {
		this.restNo = restNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Character getSoldOut() {
		return soldOut;
	}
	public void setSoldOut(Character soldOut) {
		this.soldOut = soldOut;
	}
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", menuName=" + menuName + ", price=" + price
				+ ", soldOut=" + soldOut + "]";
	}

}
