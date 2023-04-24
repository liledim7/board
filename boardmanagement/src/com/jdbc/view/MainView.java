package com.jdbc.view;

import java.util.List;
import java.util.Scanner;

import com.jdbc.common.MemberControllerI;
import com.jdbc.controller.BoardController;
import com.jdbc.controller.MemberController;
import com.jdbc.model.dto.Board;
import com.jdbc.model.dto.Member;

public class MainView {
	BoardController bc=new BoardController();
	MemberController mc=new MemberController();

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
				case 1:mc.memberMenu();break;
				case 2:bc.boardMenu();break;
				case 3:System.out.println("프로그램 종료");return;
				default:System.out.println("1~3사이의 값을 입력해주세요");
			}
		}
	}
	
	
	
	public String inputData(String title) {
		Scanner sc=new Scanner(System.in);
		System.out.print(title+" 입력: ");
		return sc.nextLine();
	}
	
	
	
	public void printMembers(List<Member> members) {
		System.out.println("==== 회원 출력 ====");
		members.forEach(m->System.out.println(m));
	}
	public void printMember(Member member) {
		System.out.println(member);
	}
	
	public void printBoards(List<Board> boards) {
		System.out.println("==== 회원 출력 ====");
		boards.forEach(m->System.out.println(m));
	}
	public void printBoard(Board board) {
		System.out.println(board);
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	
}











