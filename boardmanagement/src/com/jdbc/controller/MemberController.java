package com.jdbc.controller;

import java.util.List;

import com.jdbc.common.MemberControllerI;
import com.jdbc.model.dto.Member;
import com.jdbc.model.service.MemberService;
import com.jdbc.view.MainView;
import com.jdbc.view.MemberView;

public class MemberController implements MemberControllerI {
	

	MemberService service=new MemberService();
	@Override
	public void memberMenu() {
		new MemberView().memberMenu();
		
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
		Member member=new MemberView().insertMember();
		int result=service.insertMember(member);
		new MainView().printMsg(result>0?"가입성공":"가입실패");
	}

	@Override
	public void updateMember() {
		int idx=Integer.parseInt(new MainView().inputData("수정할 회원 idx"));
		Member m=new MemberView().updateMember();
		int result=service.updateMember(m,idx);
		new MainView().printMsg(result>0?"수정성공":"수정실패");
	}

	@Override
	public void deleteMember() {
		int idx=Integer.parseInt(new MainView().inputData("탈퇴할 회원 idx"));
		int result=service.deleteMember(idx);
		new MainView().printMsg(result>0?"탈퇴성공":"탈퇴실패");
	}
}
