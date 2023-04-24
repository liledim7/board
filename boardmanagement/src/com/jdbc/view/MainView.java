package com.jdbc.view;

import java.util.List;
import java.util.Scanner;

import com.jdbc.controller.BoardController;
import com.jdbc.model.dto.Member;

public class MainView {
	BoardController bc=new BoardController();

	public void mainMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("==== 메인메뉴 ====");
			System.out.println("1. 회원관리");
			System.out.println("2. 게시판관리");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1:bc.memberMenu();break;
				case 2:bc.boardMenu();break;
				case 3:System.out.println("프로그램 종료");return;
				default:System.out.println("1~3사이의 값을 입력해주세요");
			}
		}
	}
	
	public void memberMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("==== 회원관리메뉴 ====");
			System.out.println("1. 전체회원조회");
			System.out.println("2. 회원 아이디로 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원가입");
			System.out.println("5. 회원정보수정(주소, 전화번호, 이메일)");
			System.out.println("6. 회원탈퇴");
			System.out.println("7. 메인메뉴로");
			System.out.print("메뉴 선택: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1: bc.selectMemberAll();break;
				case 2: bc.selectMemberById();break;
				case 3: bc.selectMemberByName();break;
				case 4: bc.insertMember();break;
				case 5: bc.updateMember();break;
				case 6: bc.deleteMember();break;
				case 7: System.out.println("메인메뉴로 돌아갑니다");return;
				default: System.out.println("1~7사이의 값을 입력해주세요");
			}
		}
	}
	
	public String inputData(String title) {
		Scanner sc=new Scanner(System.in);
		System.out.print(title+" 입력: ");
		return sc.nextLine();
	}
	
	public Member insertMember() {
		Scanner sc=new Scanner(System.in);
		Member m=new Member();
		System.out.print("아이디: ");
		m.setMemberId(sc.nextLine());
		System.out.print("비밀번호: ");
		m.setMemberPwd(sc.nextLine());
		System.out.print("이름: ");
		m.setMemberName(sc.nextLine());
		System.out.print("이메일: ");
		m.setEmail(sc.nextLine());
		System.out.print("주소: ");
		m.setAddress(sc.nextLine());
		System.out.print("핸드폰번호: ");
		m.setPhone(sc.nextLine());
		return m;
	}
	
	public Member updateMember() {
		Scanner sc=new Scanner(System.in);
		Member m=new Member();
		System.out.print("새 주소:");
		m.setAddress(sc.nextLine());
		System.out.print("새 전화번호:");
		m.setPhone(sc.nextLine());
		System.out.print("새 이메일:");
		m.setEmail(sc.nextLine());
		return m;
	}
	
	public void printMembers(List<Member> members) {
		System.out.println("==== 회원 출력 ====");
		members.forEach(m->System.out.println(m));
	}
	public void printMember(Member member) {
		System.out.println(member);
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	
}











