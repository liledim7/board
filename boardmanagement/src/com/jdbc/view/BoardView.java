package com.jdbc.view;

import java.util.Scanner;

import com.jdbc.controller.BoardController;
import com.jdbc.model.dto.Board;

public class BoardView {
	BoardController bc=new BoardController();

	public void boardMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1. 게시판전체 검색");
			System.out.println("2. 게시물 등록");
			System.out.println("3. 작성자로 검색");
			System.out.println("4. 제목으로 검색");
			System.out.println("5. 게시물 수정(제목, 내용)");
			System.out.println("6. 게시물 삭제");
			System.out.println("7. 메인메뉴로");
			System.out.print("메뉴입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1:bc.selectBoardAll();break;
				case 2:bc.insertBoard();break;
				case 3:bc.selectBoardByWriter();break;
				case 4:bc.selectBoardByTitle();break;
				case 5:bc.updateBoard();break;
				case 6:bc.deleteBoard();break;
				case 7:System.out.println("메인메뉴로 돌아갑니다");return;
				default:System.out.println("1~7사이의 번호를 입력해주세요");
			}
		}
	}
	
	public Board insertBoard() {
		Scanner sc=new Scanner(System.in);
		Board b=new Board();
		System.out.print("(공지,일반,비밀): ");
		b.setIdv(sc.nextLine());
		System.out.print("제목: ");
		b.setTitle(sc.nextLine());
		System.out.print("내용: ");
		b.setContents(sc.nextLine());
		System.out.print("작성자 idx: ");
		b.setIdx(sc.nextInt());
		return b;
	}
	
	public Board updateBoard() {
		Scanner sc=new Scanner(System.in);
		Board b=new Board();
		System.out.print("새 제목: ");
		b.setTitle(sc.nextLine());
		System.out.print("새 내용: ");
		b.setContents(sc.nextLine());
		return b;
	}
	
}














