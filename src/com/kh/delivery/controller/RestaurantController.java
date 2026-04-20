package com.kh.delivery.controller;

import java.util.List;

import com.kh.delivery.model.dto.RestaurantDto;
import com.kh.delivery.model.service.RestaurantService;

public class RestaurantController {
	public List<RestaurantDto> selectRestaurantList() {
		return new RestaurantService().selectRestaurantList();
	}
	
	public RestaurantDto selectRestaurant(int restNo) {
		return new RestaurantService().selectRestaurant(restNo);
	}
	
	public List<RestaurantDto> selectRestaurantByCategory(String category) {
		return new RestaurantService().selectRestaurantByCategory(category);
	}

}
