package com.kh.delivery.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.model.dao.MemberDao;
import com.kh.delivery.model.dao.OrderDao;
import com.kh.delivery.model.dto.OrderDto;

public class OrderService {
	public int insertOrder(String memberId, OrderDto order) {
		SqlSession session = Template.getSqlSession();
		char isSoldOut = new OrderDao().isSoldOutByMenuNo(session, order.getMenuNo()).getSoldOut();
		int result = 0;
		if(isSoldOut != 'Y') {
			int memberNo = new MemberDao().memberById(session, memberId).getMemberNo();
			order.setMemberNo(memberNo);
			result = new OrderDao().insertOrder(session, order);
		}
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public List<OrderDto> selectOrderList(String memberId) {
		SqlSession session = Template.getSqlSession();
		int memberNo = new MemberDao().memberById(session, memberId).getMemberNo();
		List<OrderDto> orders = new OrderDao().selectOrderList(session, memberNo);
		session.close();
		return orders;
	}

}
