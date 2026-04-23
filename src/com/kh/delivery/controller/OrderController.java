package com.kh.delivery.controller;

import java.util.List;

import com.kh.delivery.model.dto.OrderDto;
import com.kh.delivery.model.service.OrderService;

public class OrderController {
	public int insertOrder(String memberId, OrderDto order) {
		return new OrderService().insertOrder(memberId, order);
	}
	
	public List<OrderDto> selectOrderList(String memberId) {
		return new OrderService().selectOrderList(memberId);
	}
	
	public int deleteOrder(int orderNo) {
		return new OrderService().deleteOrder(orderNo);
	}

}
