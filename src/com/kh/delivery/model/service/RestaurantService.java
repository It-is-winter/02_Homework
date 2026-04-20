package com.kh.delivery.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.model.dao.RestaurantDao;
import com.kh.delivery.model.dto.RestaurantDto;

public class RestaurantService {
	public List<RestaurantDto> selectRestaurantList() {
		SqlSession session = Template.getSqlSession();
		List<RestaurantDto> list = new RestaurantDao().selectRestaurantList(session);
		session.close();
		return list;
	}
	
	public RestaurantDto selectRestaurant(int restNo) {
		SqlSession session = Template.getSqlSession();
		RestaurantDto restaurantDto = new RestaurantDao().selectRestaurant(session, restNo);
		session.close();
		return restaurantDto;
	}
	
	public List<RestaurantDto> selectRestaurantByCategory(String category) {
		SqlSession session = Template.getSqlSession();
		List<RestaurantDto> list = new RestaurantDao().selectRestaurantByCategory(session, category);
		session.close();
		return list;
	}

}
