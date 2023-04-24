package com.jdbc.model.service;

import java.sql.Connection;
import java.util.List;
import static com.jdbc.common.JDBCTemplate.*;

import com.jdbc.model.dao.BoardDao;
import com.jdbc.model.dto.Board;


public class BoardSevice {
	BoardDao bd=new BoardDao();
	public List<Board> selectBoardAll(){
		Connection conn=getConnection();
		List<Board> boards=bd.selectBoardAll(conn);
		close(conn);
		return boards;
	}
	
	public int insertBoard(Board board) {
		Connection conn=getConnection();
		int result=bd.insertBoard(conn,board);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public List<Board> selectBoardByWriter(int idx){
		Connection conn=getConnection();
		List<Board> boards=bd.selectBoardByWriter(conn, idx);
		close(conn);
		return boards;
	}
	
	public List<Board> selectBoardByTitle(String title){
		Connection conn=getConnection();
		List<Board> boards=bd.selectBoardByTitle(conn, title);
		close(conn);
		return boards;
	}
	
	public int updateBoard(Board b, int idx) {
		Connection conn=getConnection();
		int result=bd.updateBoard(conn, b, idx);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteBoard(int idx) {
		Connection conn=getConnection();
		int result=bd.deleteBoard(conn, idx);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}


}







