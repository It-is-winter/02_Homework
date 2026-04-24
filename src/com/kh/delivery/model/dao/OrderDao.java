package com.kh.delivery.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.model.dto.MenuDto;
import com.kh.delivery.model.dto.OrderDto;

public class OrderDao {
	/**
	 * Insert new Order when menu is not sold_out
	 * @param session
	 * @param order
	 * @return
	 */
	public int insertOrder(SqlSession session, OrderDto order) {
		return session.insert("orderMapper.insertOrder", order);
	}
	
	/**
	 * Validate that menu's SOLD_OUT value is 'Y' or 'N'
	 * @param session
	 * @param menuNo
	 * @return
	 */
	public MenuDto isSoldOutByMenuNo(SqlSession session, int menuNo) {
		return session.selectOne("orderMapper.isSoldOutByMenuNo", menuNo);
	}
	
	/**
	 * Retrieve all orders for a member
	 * @param session
	 * @param memberNo
	 * @return
	 */
	public List<OrderDto> selectOrderList(SqlSession session, int memberNo) {
		return session.selectList("orderMapper.selectOrderList", memberNo);
	}
	
	/**
	 * Delete orders with status '주문접수'
	 * @param session
	 * @param orderNo
	 * @return
	 */
	public int deleteOrder(SqlSession session, int orderNo) {
		return session.delete("orderMapper.deleteOrder", orderNo);
	}

}
