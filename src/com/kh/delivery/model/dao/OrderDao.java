package com.kh.delivery.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.model.dto.MenuDto;
import com.kh.delivery.model.dto.OrderDto;

public class OrderDao {
	public int insertOrder(SqlSession session, OrderDto order) {
		return session.insert("orderMapper.insertOrder", order);
	}
	
	public MenuDto isSoldOutByMenuNo(SqlSession session, int menuNo) {
		return session.selectOne("orderMapper.isSoldOutByMenuNo", menuNo);
	}
	
	public List<OrderDto> selectOrderList(SqlSession session, int memberNo) {
		return session.selectList("orderMapper.selectOrderList", memberNo);
	}

}
