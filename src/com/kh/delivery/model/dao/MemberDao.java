package com.kh.delivery.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.model.dto.DeliMemberDto;

public class MemberDao {
	/**
	 * Check memberId is already exist
	 * This method can validate an memberId
	 * @param session
	 * @param memberId
	 * @return
	 */
	public DeliMemberDto validateId(SqlSession session, String memberId) {
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
	 * For find memberNo that correct memberId and memberPw
	 * @param session
	 * @param member
	 * @return
	 */
	public DeliMemberDto validateMember(SqlSession session, DeliMemberDto member) {
		return session.selectOne("memberMapper.validateMember", member);
	}
	
	/**
	 * Login succeeds if memberId and memberPw are correct
	 * @param session
	 * @param memberNo
	 * @return
	 */
	public int logIn(SqlSession session, int memberNo) {
		return session.insert("memberMapper.logIn", memberNo);
	}
	
	/**
	 * Log out
	 * @param session
	 * @param memberNo
	 * @return
	 */
	public int logOut(SqlSession session, int memberNo) {
		return session.delete("memberMapper.logOut", memberNo);
	}

}
