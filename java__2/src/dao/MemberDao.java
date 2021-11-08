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
		public boolean update(String id , String name , String email) {
			// 1. SQL 작성
			String sql = "update member set m_name=? , m_email=? where m_id = ?";
						// update 테이블ㄹ명 set 변경필드=값 , 변경필드2 = 값2 where 조건
			// 2. SQL -> DB연결
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, id);
				preparedStatement.executeUpdate();
				return true;
			} catch (Exception e) {}
			return false;
		}
		// 6. 회원탈퇴 메소드
		public boolean delete(String loginid) {
			// 1. SQL 작성
			String sql = " delete from member where m_id=?";
						// delete from 테이블명
						// delete from 테이블명 where 조건
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, loginid);
				preparedStatement.executeUpdate();
				return true;	// 탈퇴 성공시
			} catch (Exception e) {}
			return false;
		}
		// 7. 회원조회 메소드 [회원 아이디를 인수로 받아 회원정보 반환]
		public Member getmember(String loginid) {
			// 1.SQL 작성
			String sql = "select * from member where m_id=?";
			// 2.SQL->DB 연결
			try {
				preparedStatement = connection.prepareStatement(sql);
				// 3.SQL 설정
				preparedStatement.setString(1, loginid);	
				// 4.SQL 실행
				resultSet = preparedStatement.executeQuery();
				// 5.SQL 결과
				if(resultSet.next()) {
					// 패스워드를 제외한 회원정보 출력
					Member member = new Member(resultSet.getString(2), " ", resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
					return member;
				}else {
					return null;
				}
			} catch (Exception e) {}
			return null; // db오류
		}
		// 8. 아이디 체크 메소드
		public boolean idcheck(String id) {
			String sql = "select m_id from member where m_id=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {return true;}	// 현재 아이디가 존재하면
				else {return false;}		// 현재 아이디가 존재하지 않으면
			} catch (Exception e) {}
			return true;
		}
		
		// 9. 포인트 증감 메소드
		public boolean pointupdate (String id, int point) {
			String sql = "update member set m_point = m_point + ? where m_id=?";
						// update 테이블명 set 변경할필드명 = 변경할값 where 조건
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, point);
				preparedStatement.setString(2, id);
				preparedStatement.executeUpdate();
				return true;
			} catch (Exception e) {}
			return false;
			
		}
		// 10. 회원id의 회원번호 찾기 메소드
		public int mnocheck(String id) {
			String sql = "select m_no from member where m_id =?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {return resultSet.getInt(1);}
				else {return 0;}
			} catch (Exception e) {} return 0;
		}
		
		// 11. 회원번호의 회원id 찾기 메소드
		public String midcheck(int m_no) {
			String sql = "select m_id from member where m_no=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, m_no);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {return resultSet.getString(1);}	// 현재 아이디가 존재하면
				else {return "";}		// 현재 아이디가 존재하지 않으면
			} catch (Exception e) {}
			return "";
		}
		
		// 12. 회원 수 반환 메소드
		public int membercount() {
			String sql = "select count(*) from member ";
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getInt(1);	
				}
				
			} catch (Exception e) {	} return 0;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
		/*	 게시판 설계
			// 1. DB설계
					// 게시물번호 				int
					// 게시물제목 				String
					 * 게시물내용				String
					 * 게시물작성자[로그인된 id]	String
					 * 게시물 작성일[자동 주입]	String
					 * 게시물 조회수			int
					 
			// 2. DTO 설계
			// 3. DAO 설계
			// 4. FXML 작성
			// 5. Controller 작성
			// 6. DAO 작성
		
			// DDL : 정의어
		 		* create table DB명 테이블명
		 		* 	필드명1 자료형 속성,
		 		*	필드명2 자료형 속성,
		 		*	필드명3 자료형 속성
		 		Drop 삭제
		 		Alter
		 	*자료형
		 	*	int : 정수형
		 	*	varchar : 문자열	(바이트)
		 	*	timestamp : 날짜/시간 (4바이트)
		 	
			속성
				primary key : 기본키[pk]
				auto increment : 자동번호 주입[ai]
				not null : null값 제외
				default : 초기값
			함수
				now : 현재날짜/시간
				회원 					게시판			댓글
				회원번호				게시물번호			댓글번호
				회원아이디				게시물제목			댓글내용
				회원비밀번호			게시물내용			댓글작성자
				회원이름				회원번호			댓글작성일
									게시물작성자			
				회원이메일				게시물작성일		게시물번호
				회원포인트				게시물조회수
				PK					FK				FK
				
				회원번호[PK]--------->회원번호[FK]
									게시물번호[PK]---->게시물번호[FK]
				pk : 식별 가능한 키 [ 식별 필드 : 중복x null x ]
						예) 주민등록번호 , 사번, 학번, 카드번호 , 사업장번호 , 주소 등
						다른 테이블과 연결시 사용되는 식별키 [ 대부분1]
				fk : pk와 연결된 필드
					* 외래키
					* 다른테이블에 pk와 연결된 필드 대부분[M]
					* 
					
				DB함수[메소드]
				now() : 시스템날짜/시간
				count(필드) : 해당 필드의 레코드 수
				
				값설정 
				XYchart.Series 변수명 : new XYChart.Series<>();
				계열이름 
				계열명.setName
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
