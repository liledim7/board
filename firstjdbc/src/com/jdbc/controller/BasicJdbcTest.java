package com.jdbc.controller;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.vo.Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasicJdbcTest {

	public static void main(String[] args) {
		//jdbc를 이용해서 오라클과 연동해보기
		//1. 오라클에서 제광하는 ojbc.jar파일을 버전에 맞춰서 다운로드
		//2. 이클립스에서 프로젝트를 생성하고 생성된 프로젝트 라이브러리에 다운받은 jar파일을 추가한다
		//프로젝트(애플리케이션)에서 DB에 접속하기
		//1. jar파일이 제공하는 클래스가 있는지 확인하기
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DriverManager클래스를 이용해서 접속하는 객체를 만들어준다.
			//DriverManager클래스가 제공하는 getConnection() static메소드를 이용해서 Connection객체를 가져온다.
			//getConnection은 3개의 매개변수가 필요
			//1-접속할 DB의 주소, 버전정보, 포트번호 String 오라클패턴: jdbc:oracle:thin:@ip주소:포트번호:버전
			//2-DB접속 계정명 String
			//3-DB접속 계정 비밀번호 String
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			//트랜잭션을 개발자가 직접 처리
			conn.setAutoCommit(false);
			System.out.println("DB접속 확인 완료");
			//3. 접속된 DB에 sql문을 실행하고 결과를 가져와야함
			//sql문을 실행하기 위해서 실행할 객체가 필요함
			//Statement, preparedStatement : 문자열로 작성한 sql구문을 연결된 DB에서 실행하는 객체
			//sql문을 실행하려면 Statement의 멤버메소드 executeQuery(), executeUpdate()메소드를 이용한다.
			// SELECT : executeQuery()실행 -> ResultSet객체를 반환
			// INSERT, UPDATE, DELETE : executeUpdate()실행 -> int반환
			//1)쿼리문 작성하기
			//member테이블에 있는 아이디가 admin인 사원 조회하기
			//문자열 변수에 sql문을 저장할때는 ;을 생략한다.
			//String sql="SELECT * FROM MEMBER WHERE MEMBER_ID = 'admin'";
			String sql="SELECT * FROM MEMBER";
			//2) Statement객체 가져오기
			//Connection클래스가 제공하는 멤버메소드인 createStatement()메소드를 이용
			stmt = conn.createStatement();
			// 3) 쿼리문 실행시키기
			// Statement제공하는 executeQuery()실행하고 반환은 ResultSet객체로 받는다
			rs = stmt.executeQuery(sql); 
			System.out.println(rs);
			List<Member> st = new ArrayList();
			//4. ResultSet이용하기
			//반환된 SELECT문의 실행결과는 RestulSet객체가 제공하느 ㄴ메소드를 이용해서 컬럼별 값을 가져온다.
			//next() : 데이터의 row를 지정 -> row데이터를 가져온 반환형 ; boolean
			//get자료형
			//getStirng(): char, varchar2, nchar, nvarchar2 자료형을 가져올때
			//getInt()/getDouble() : num자료형을 가져올때
			//getDate() / getTimeStamp(): date, timeStamp
			while(rs.next()) {
				String memberId=rs.getString(1);
				String memberPwd=rs.getString(2);
				String memberName=rs.getString(3);
				String gender=rs.getString(4);
				int age=rs.getInt(5);
				String email=rs.getString(6);
				String phone=rs.getString(7);
				String address=rs.getString(8);
				String hobby=rs.getString(9);
				Date enrollDate=rs.getDate("enroll_date");
				st.add(new Member(memberId,memberPwd,memberName,gender,age,email,phone,address,hobby,enrollDate));
			}
//			System.out.println(st);
			st.forEach((m)->System.out.println(m));
			
			//DB의 row를 가져왔을때 자바에서는 클래스로 저장해서 관리
//			Member m = new Member();
//			if(rs.next()) {
//				String memberId=rs.getString("member_id");
//				m.setMemberId(memberId);
			//.....
//			}
			//DML구문 실행하기
			//insert, update, delete문
			//트랜잭션처리를 해줘야한다.
			//1. sql문 작성 -> 리터럴형태에 맞춰서 작성
			sql="INSERT INTO MEMBER VALUES('inhoru','inhoru'," +"'최인호','M',26,'inhoru@inhoru.com',"+"'0101234145','금천구','영화감상,애니감상,코딩',SYSDATE)";
			int result=stmt.executeUpdate(sql);
			if(result>0) conn.commit();
			else conn.rollback();
			
			System.out.println(result);
			//5.생성한 객체를 반드시 반환해줘야한다
			//Connection, Statement, [ResultSet]
			//close()메소드를 이용해서 반환을 한다.
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
