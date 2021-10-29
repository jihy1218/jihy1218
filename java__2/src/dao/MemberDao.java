package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import domain.Member;

public class MemberDao {

	// JDBC 주요 인터페이스 , 클래스
		// 1. Connection : DB연결 인터페이스 [ DriverManager 클래스 ]
		
	// 1. 필드
		private Connection connection;
		// 현재 클래스내 객체 만들기
		private static MemberDao memberDao = new MemberDao();
	// 2. 생성자
		public MemberDao() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC" , "root" , "1234");
			} catch (Exception e) {
				System.out.println("DB연동 실패: " + e);
			}
		}
	// 3. 메소드
		public static MemberDao getMemberDao() {return memberDao;}
		
		// 기능 메소드
		// 1.회원가입 메소드
		public boolean signup(Member member) {
			
			// 1. SQL 작성 [ SQL : DB 조작이 DML ]
			// 특정필드 : INSERT INTO 테이블명(필드명1, 필드명2 , 필드명3) values(값1 , 값2 , 값3)
			// 모든필드 : INSERT INTO 테이블명 values(값1 , 값2 , 값3)
			String sql = "insert into member(m_id,m_password,m_name,m_email,m_point) values( ? , ? , ? , ? , ? )";
			
			try {
				// 2. SQL -> DB연결
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				// 3. SQL 설정
					preparedStatement.setString(1, member.getM_id());
					preparedStatement.setString(2, member.getM_password() );
					preparedStatement.setString(3, member.getM_name());
					preparedStatement.setString(4, member.getM_email());
					preparedStatement.setInt(5, member.getM_point());
					
				// 4. SQL 실행
					preparedStatement.executeUpdate();
				// 5. SQL 결과
					return true;
			} 
			catch (Exception e) {} 
			return false;
		}
		// 2. 로그인 메소드
		
		// 3. 아이디찾기 메소드
		
		// 4. 비밀번호찾기 메소드
		
		// 5. 회원수정 메소드
		
		// 6. 회원탈퇴 메소드
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// DB연동 테스트
	/*
	public static void main(String[] args) {
		
		try {
			// 1. mysql 드라이브 확인
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이브 가져오기 성공");
			// 2. DB연동
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC" , "root" , "1234");
				System.out.println("2. DB연동 성공");
		} catch (Exception e) {
			System.out.println("DB 연동 실패");
		}
		
	}
	*/
}
