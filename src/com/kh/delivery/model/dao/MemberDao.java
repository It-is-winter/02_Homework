package com.kh.delivery.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.model.dto.DeliMemberDto;

public class MemberDao {
	/**
	 * Check memberId is already exist
	 * @param session
	 * @param memberId
	 * @return
	 */
	public int validateId(SqlSession session, String memberId) {
		return session.selectOne("memberMapper.validateId", memberId);
	}
	
	/**
	 * Insert new member
	 * @param session
	 * @param member
	 * @return
	 */
	public int signUp(SqlSession session, DeliMemberDto member) {
		return session.insert("memberMapper.signUp", member);
	}
	
	/**
	 * Login succeeds if memberId and memberPw are correct
	 * @param session
	 * @param member
	 * @return
	 */
	public DeliMemberDto logIn(SqlSession session, DeliMemberDto member) {
		return session.selectOne("memberMapper.logIn", member);
	}

}
