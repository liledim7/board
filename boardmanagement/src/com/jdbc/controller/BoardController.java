package com.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import com.jdbc.common.Controller;
import com.jdbc.model.dto.Member;
import com.jdbc.model.service.BoardSevice;
import com.jdbc.view.MainView;
import static com.jdbc.common.JDBCTemplate.*;

public class BoardController implements Controller{

	BoardSevice service=new BoardSevice();
	public void mainMenu() {
		new MainView().mainMenu();
	}
	@Override
	public void memberMenu() {
		new MainView().memberMenu();
		
	}

	@Override
	public void boardMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectMemberAll() {
		List<Member>members=service.selectMemberAll();
		new MainView().printMembers(members);
		
	}

	@Override
	public void selectMemberById() {
		String id=new MainView().inputData("회원 아이디");
		Member member=service.selectMemberById(id);
		new MainView().printMember(member);
	}

	@Override
	public void selectMemberByName() {
		String name=new MainView().inputData("회원 이름");
		List<Member> members=service.selectMemberByName(name);
		new MainView().printMembers(members);
		
	}

	@Override
	public void insertMember() {
		Member member=new MainView().insertMember();
		int result=service.insertMember(member);
		new MainView().printMsg(result>0?"가입성공":"가입실패");
	}

	@Override
	public void updateMember() {
		int idx=Integer.parseInt(new MainView().inputData("수정할 회원 idx"));
		Member m=new MainView().updateMember();
		int result=service.updateMember(m,idx);
		new MainView().printMsg(result>0?"수정성공":"수정실패");
	}

	@Override
	public void deleteMember() {
		int idx=Integer.parseInt(new MainView().inputData("탈퇴할 회원 idx"));
		int result=service.deleteMember(idx);
		new MainView().printMsg(result>0?"탈퇴성공":"탈퇴실패");
	}

	@Override
	public void selectBoardAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectBoardByWriter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectBoardByTitle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard() {
		// TODO Auto-generated method stub
		
	}

}
