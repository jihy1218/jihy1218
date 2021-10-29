package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Member;

public class MemberDao {

	// JDBC 주요 인터페이스 , 클래스
		// 1. Connection : DB연결 인터페이스 [ DriverManager 클래스 ]
		
	// 1. 필드
		private Connection connection;	// DB 연결 인터페이스 선언
		private PreparedStatement preparedStatement;	// SQL 연결 인터페이스 선언
		private ResultSet resultSet;	// 쿼리(검색결과) 연결 인터페이스 선언
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
				preparedStatement = connection.prepareStatement(sql);
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
		public boolean login(String id , String password) {
			// 1. SQL 작성
			// 특정필드 : select 필드명 from 테이블명 where 조건
			// 모든필드 : select *from 테이블명 where 조건
			// * 조건 and : 이면서 면서 이고 그리고 조건1 and 조건2
				// or : 이거나 거나 또는 하나라도 조건1 or 조건2
			String sql = "select * from member where m_id=? and m_password=?";
			// 2. SQL -> DB 연결
			try {
				preparedStatement = connection.prepareStatement(sql);
				// 3.SQL 설정 [ 현재 메소드내 들어온 인수를 ? 대입 ]
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, password);
				// 4.SQL 실행 [Query : 쿼리 (검색 결과)
					resultSet = preparedStatement.executeQuery();
				// 5.SQL 결과
					if(resultSet.next()) { // 쿼리결과에 다음내용이 있으면 true
						return true;
					}else {
						return false;
					}
				}catch (Exception e) {}
				return false;
		}
		// 3. 아이디찾기 메소드
		public String findid(String name , String email) {
			// 1. SQL 작성
			String sql = "select m_id from member where m_name=? and m_email=?";
			// 2. SQL ->DB 연결
			try {
				preparedStatement = connection.prepareStatement(sql);
				// 3. SQL설정
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, email);
				// 4. SQL 실행 
					resultSet = preparedStatement.executeQuery();
				// 5. SQL 실행 결과
					if(resultSet.next()) {
						// 검색 결과가 있으면
						return resultSet.getString(1); // 쿼리(검색결과)내 첫번쨰 필드를 반환
					}else {
						return null;	// 검색 결과가 없으면
					}	
			} catch (Exception e) {}
			return null;
		}
		// 4. 비밀번호찾기 메소드
		public String findpassword(String id, String email) {
			// 1. SQL 작성
			String sql = "select m_password from member where m_id=? and m_email=?";
			// 2. SQL -> DB 연결
			try {	
				preparedStatement = connection.prepareStatement(sql);
				// 3. SQL 설정
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, email);
				// 4. SQL 실행
					resultSet = preparedStatement.executeQuery();
				// 5. SQL 결과
					if(resultSet.next()) {
						return resultSet.getString(1);
					}else {
						return null;
					}
			} catch (Exception e) {}
			return null;
		}
		
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
