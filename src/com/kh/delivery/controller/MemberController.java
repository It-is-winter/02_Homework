package com.kh.delivery.controller;

import com.kh.delivery.model.dto.DeliMemberDto;
import com.kh.delivery.model.service.MemberService;

public class MemberController {
	public int validateId(String memberId) {
		return new MemberService().validateId(memberId);
	}
	
	public int signUp(DeliMemberDto member) {
		return new MemberService().signUp(member);
	}
	
	public DeliMemberDto logIn(DeliMemberDto member) {
		return new MemberService().logIn(member);
	}

}
