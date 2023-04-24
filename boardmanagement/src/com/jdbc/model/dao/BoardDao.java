package com.jdbc.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.jdbc.common.JDBCTemplate.*;

import com.jdbc.model.dto.Board;

public class BoardDao {
	Properties sql=new Properties();
	{
		try {
			String path=BoardDao.class.getResource("/sql/board/manage_sql.properties").getPath();
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Board> selectBoardAll(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectBoardAll");
		List<Board> boards=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				boards.add(getBoard(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return boards;
	}
	
	public int insertBoard(Connection conn,Board b) {
		PreparedStatement pstmt=null;
		String sql=this.sql.getProperty("insertBoard");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b.getIdv());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContents());
			pstmt.setInt(4, b.getIdx());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public List<Board> selectBoardByWriter(Connection conn, int idx){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectBoardByWriter");
		List<Board> boards=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				boards.add(getBoard(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return boards;
	}
	
	public List<Board> selectBoardByTitle(Connection conn,String title){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> boards=new ArrayList<>();
		String sql=this.sql.getProperty("selectBoardByTitle");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				boards.add(getBoard(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return boards;
	}
	
	public int updateBoard(Connection conn,Board b, int idx) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=this.sql.getProperty("updateBoard");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,b.getTitle());
			pstmt.setString(2, b.getContents());
			pstmt.setInt(3, idx);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int deleteBoard(Connection conn, int idx) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=this.sql.getProperty("deleteBoard");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	private Board getBoard(ResultSet rs) throws SQLException{
		Board b=new Board();
		b.setIdx(rs.getInt("idx"));
		b.setIdv(rs.getString("idv"));
		b.setTitle(rs.getString("title"));
		b.setContents(rs.getString("contents"));
		b.setWriter(rs.getInt("writer"));
		b.setWrite_date(rs.getDate("write_date"));
		return b;
	}

}















