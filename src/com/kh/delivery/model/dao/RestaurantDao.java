package com.kh.delivery.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.model.dto.RestaurantDto;

public class RestaurantDao {
	/**
	 * Select all of restaurants
	 * @param session
	 * @return
	 */
	public List<RestaurantDto> selectRestaurantList(SqlSession session) {
		return session.selectList("restaurantMapper.selectRestaurantList"); 
	}
	
	/**
	 * Select restaurant by restNo
	 * @param session
	 * @param restNo
	 * @return
	 */
	public RestaurantDto selectRestaurant(SqlSession session, int restNo) {
		return session.selectOne("restaurantMapper.selectRestaurant", restNo);
	}
	
	/**
	 * Select a list of restaurants by category or view all
	 * @param session
	 * @param category
	 * @return
	 */
	public List<RestaurantDto> selectRestaurantByCategory(SqlSession session, String category) {
		return session.selectList("restaurantMapper.selectRestaurantByCategory", category);
	}

}
