package com.jdbc.model.service;

import static com.jdbc.common.JDBCTemplate.close;
import static com.jdbc.common.JDBCTemplate.commit;
import static com.jdbc.common.JDBCTemplate.getConnection;
import static com.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.dto.Member;

public class MemberService {

	MemberDao bd=new MemberDao();
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
	
	public int updateMember(Member m, int idx) {
		Connection conn=getConnection();
		int result=bd.updateMember(conn,m,idx);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteMember(int idx) {
		Connection conn=getConnection();
		int result=bd.deleteMemeber(conn,idx);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
