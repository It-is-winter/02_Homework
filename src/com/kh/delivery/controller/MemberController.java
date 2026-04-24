package com.kh.delivery.controller;

import com.kh.delivery.model.dto.DeliMemberDto;
import com.kh.delivery.model.service.MemberService;

public class MemberController {
	public DeliMemberDto validateId(String memberId) {
		return new MemberService().validateId(memberId);
	}
	
	public int signUp(DeliMemberDto member) {
		return new MemberService().signUp(member);
	}
	
	public int logIn(DeliMemberDto member) {
		return new MemberService().logIn(member);
	}

}
