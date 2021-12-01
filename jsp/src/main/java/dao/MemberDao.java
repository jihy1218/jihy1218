package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDao {

	// 1. 빌드패스 -> 라이브러리 추가
	// 2. 프로젝트내 web-inf -> lib -> 라이브러리 추가
	
	// 	1. 자주사용하는 인터페이스 
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsp?serverTimezone=UTC","root","1234");
			System.out.println("DB연동성공");
		} catch (Exception e) {
			System.out.println("DB연동실패");
		}
		
	}
	public static MemberDao memberDao= new MemberDao();	// 3. dao 객체 생성
	public static MemberDao getmemberDao() {return memberDao;}	// 4. dao 객체 반환
	
	// 회원가입 메소드
	public boolean membersignup(Member member) {
		String sql = "insert into member (m_id,m_password,m_name,m_birth,m_sex,m_phone,m_address) values (?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getM_id() );
			preparedStatement.setString(2, member.getM_password() );
			preparedStatement.setString(3, member.getM_name() );
			preparedStatement.setString(4, member.getM_birth() );
			preparedStatement.setString(5, member.getM_sex() );
			preparedStatement.setString(6, member.getM_phone() );
			preparedStatement.setString(7, member.getM_address() );
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 로그인 메소드
	public boolean memberlogin(String id , String password) {
		String sql = "select * from member where m_id=? and m_password=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {} return false;
	}
}
