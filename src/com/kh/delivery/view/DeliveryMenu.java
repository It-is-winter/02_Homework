package com.kh.delivery.view;

import java.util.List;
import java.util.Scanner;

import com.kh.delivery.controller.MemberController;
import com.kh.delivery.controller.RestaurantController;
import com.kh.delivery.model.dto.DeliMemberDto;
import com.kh.delivery.model.dto.MenuDto;
import com.kh.delivery.model.dto.RestaurantDto;

public class DeliveryMenu {
	Scanner sc = new Scanner(System.in);
	MemberController memberController = new MemberController();
	RestaurantController resController = new RestaurantController();
	
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println("*****배달 서비스에 오신걸 환영합니다*****");
			selectRestaurantList();
			System.out.println("1. 가게 메뉴 보기 ");
			System.out.println("2. 카테고리 별 검색하기 ");
			System.out.println("3. 회원가입하기");
			System.out.println("4. 로그인하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("원하시는 메뉴 번호를 입력해주세요 >");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : selectRestaurant(); break;
			case "2" : selectRestaurantByCategory(); break;
			case "3" : signUp(); break;
			case "4" : logIn(); break;
			case "0" : sc.close(); return;
				default : System.out.println("해당하는 메뉴번호가 없습니다. 다시 입력해주세요.");
			}
		}
	}
	
	private void selectRestaurantList() {
		System.out.println("======================================================");
		List<RestaurantDto> list = resController.selectRestaurantList();
		if(list.isEmpty()) {
			System.out.println("조회할 수 있는 가게가 없습니다.");
		} else {
			for(RestaurantDto res : list) {
				System.out.println(res);
			}
		}
		System.out.println("======================================================");
	}
	
	private void selectRestaurant() {
		selectRestaurantList();
		System.out.print("조회하고 싶으신 가게번호를 선택해주세요 >");
		String res = sc.nextLine();
		int resNo = 0;
		try {
			resNo = Integer.parseInt(res);
		} catch(NumberFormatException e) {
			System.out.println("숫자로 입력해주세요.");
		}
		
		RestaurantDto result = resController.selectRestaurant(resNo);
		if(result != null) {
			System.out.println(result.getRestName() + "의 메뉴들");
			List<MenuDto> menuDtos = result.getMenus();
			for(MenuDto menuDto : menuDtos) {
				System.out.println(menuDto);
			}
		} else {
			System.out.println("해당 가게번호에 대한 정보가 없습니다.");
		}
	}
	
	private void selectRestaurantByCategory() {
		System.out.print("검색하고 싶으신 카테고리를 입력해주세요 >");
		String category = sc.nextLine();
		List<RestaurantDto> list = resController.selectRestaurantByCategory(category);
		if(list.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		} else {
			for(RestaurantDto res : list) {
				System.out.println(res);
			}
		}
	}
	
	private void signUp() {
		System.out.println("======================================================");
		System.out.println("\t\t회원가입 서비스입니다.");
		System.out.println("======================================================");
		String memberId = "";
		String memberPw = "";
		String memberName = "";
		String address = "";
		while(true) {
			System.out.print("아이디를 입력해주세요 >");
			memberId = sc.nextLine();
			int result = memberController.validateId(memberId);
			if(result > 0) {
				System.out.println("해당아이디가 존재합니다. 다른 아이디를 입력해주세요.");
			} else {
				System.out.print("비밀번호를 입력해주세요 >");
				memberPw = sc.nextLine();
				System.out.print("이름을 입력해주세요 >");
				memberName = sc.nextLine();
				System.out.print("주소를 입력해주세요 >");
				address = sc.nextLine();
				break;
			}
		}
		int result = memberController.signUp(new DeliMemberDto(memberId, memberPw, memberName, address));
		if(result > 0) {
			System.out.println("회원가입 성공하였습니다.");
		} else {
			System.out.println("회원가입 실패하였습니다.");
		}
	}
	
	private void logIn() {
		System.out.println("======================================================");
		System.out.println("\t\t로그인서비스입니다.");
		System.out.println("======================================================");
		DeliMemberDto result = null;
		while(true) {
			System.out.print("아이디를 입력해주세요 >");
			String memberId = sc.nextLine();
			System.out.print("비밀번호를 입력해주세요 >");
			String memberPw = sc.nextLine();
			
			result = memberController.logIn(new DeliMemberDto(memberId, memberPw));
			if(result != null) {
				System.out.println("로그인 성공!");
				break;
			} else {
				System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
			}
		}
		loggedIn(result);
	}
	
	private void loggedIn(DeliMemberDto result) {
		System.out.println("======================================================");
		System.out.println("\t**"+ result.getMemberName() + "님 환영합니다**");
		System.out.println("======================================================");
		while(true) {
			System.out.println("1. 주문하기");
			System.out.println("2. 내 주문내역보기");
			System.out.println("3. 주문취소하기");
			System.out.println("4. 로그아웃하기");
			System.out.print("원하시는 메뉴번호를 선택해주세요 >");
			String menu = sc.nextLine();
			
			switch(menu) {
//			case "1" : orderFood(); break;
			case "2" :
			case "3" :
			case "4" : return;
				default : System.out.println("해당하는 메뉴번호가 없습니다. 다시 입력해주세요.");
			}
		}
	}

}
