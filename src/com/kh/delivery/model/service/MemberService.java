package com.kh.delivery.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.model.dao.MemberDao;
import com.kh.delivery.model.dto.DeliMemberDto;

public class MemberService {
	public DeliMemberDto validateId(String memberId) {
		SqlSession session = Template.getSqlSession();
		DeliMemberDto member = new MemberDao().validateId(session, memberId);
		session.close();
		return member;
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
	
	public int logIn(DeliMemberDto member) {
		SqlSession session = Template.getSqlSession();
		DeliMemberDto md = new MemberDao().validateMember(session, member);
		int result = 0;
		if(md != null) {
			result = new MemberDao().logIn(session, md.getMemberNo());
		}
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public int logOut(String memberId) {
		SqlSession session = Template.getSqlSession();
		DeliMemberDto member = new MemberDao().validateId(session, memberId);
		int result = 0;
		if(member != null) {
			result = new MemberDao().logOut(session, member.getMemberNo());
		}
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
