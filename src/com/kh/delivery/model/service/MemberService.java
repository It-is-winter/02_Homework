package com.kh.delivery.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.model.dao.MemberDao;
import com.kh.delivery.model.dto.DeliMemberDto;

public class MemberService {
	public int validateId(String memberId) {
		SqlSession session = Template.getSqlSession();
		int result = new MemberDao().validateId(session, memberId);
		session.close();
		return result;
	}
	
	public int signUp(DeliMemberDto member) {
		SqlSession session = Template.getSqlSession();
		int result = new MemberDao().signUp(session, member);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public DeliMemberDto logIn(DeliMemberDto member) {
		SqlSession session = Template.getSqlSession();
		DeliMemberDto result = new MemberDao().logIn(session, member);
		session.close();
		return result;
	}

}
