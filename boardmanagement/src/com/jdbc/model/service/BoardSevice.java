package com.jdbc.model.service;

import java.sql.Connection;
import java.util.List;
import static com.jdbc.common.JDBCTemplate.*;

import com.jdbc.model.dao.BoardDao;
import com.jdbc.model.dto.Member;

public class BoardSevice {
	BoardDao bd=new BoardDao();
	public List<Member>selectMemberAll(){
		Connection conn=getConnection();
		List<Member> members=bd.selectMemberAll(conn);
		close(conn);
		return members;
	}
	
	public Member selectMemberById(String id) {
		Connection conn=getConnection();
		Member member=bd.selectMemberById(conn,id);
		close(conn);
		return member;
	}
	
	public List<Member> selectMemberByName(String name){
		Connection conn=getConnection();
		List<Member> members=bd.selectMemberByName(conn,name);
		close(conn);
		return members;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=bd.insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}







