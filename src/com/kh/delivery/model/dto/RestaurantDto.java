package com.kh.delivery.model.dto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDto {
	private Integer restNo;
	private String restName;
	private String category;
	private int minPrice;
	private int deliveryFee;
	private List<MenuDto> menus = new ArrayList();
	public RestaurantDto() {
		super();
	}
	public RestaurantDto(Integer restNo) {
		super();
		this.restNo = restNo;
	}
	public RestaurantDto(Integer restNo, String category) {
		super();
		this.restNo = restNo;
		this.category = category;
	}
	public RestaurantDto(Integer restNo, String restName, String category, int minPrice, int deliveryFee) {
		super();
		this.restNo = restNo;
		this.restName = restName;
		this.category = category;
		this.minPrice = minPrice;
		this.deliveryFee = deliveryFee;
	}
	public RestaurantDto(Integer restNo, String restName, String category, int minPrice, int deliveryFee,
			List<MenuDto> menus) {
		super();
		this.restNo = restNo;
		this.restName = restName;
		this.category = category;
		this.minPrice = minPrice;
		this.deliveryFee = deliveryFee;
		this.menus = menus;
	}
	public Integer getRestNo() {
		return restNo;
	}
	public void setRestNo(Integer restNo) {
		this.restNo = restNo;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public List<MenuDto> getMenus() {
		return menus;
	}
	public void setMenuDtos(List<MenuDto> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "Restaurant [restNo=" + restNo + ", restName=" + restName + ", category=" + category + ", minPrice="
				+ minPrice + ", deliveryFee=" + deliveryFee + "]";
	}

}
