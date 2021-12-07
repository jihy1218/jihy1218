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
	
	// 생성자
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsp?serverTimezone=UTC","root","1234");
		} catch (Exception e) {	System.out.println("DB연동실패");}
		
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
	// 아이디 체크 메소드
	public boolean idcheck(String userid) {
		String sql ="select m_id from member where m_id=? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;	// 아이디 존재함
			}
		} catch (Exception e) {	} return false; // 아이디존재하지않음
		
	}
	// 로그인 메소드
	public boolean memberlogin(String id , String password) {
		String sql = "select * from member where m_id=? and m_password=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) { return true;}
		} catch (Exception e) {} return false;
	}
	// 회원탈퇴 메소드 
	public boolean delete(String id , String password) {
		String sql1 = "select * from member where m_id=? and m_password=?";		// 회원 검사용
		String sql2 ="delete from member where m_id=? and m_password=?";			// 회원 삭제용
		try {
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {	// 아이디와 비밀번호가 동일한경우의 결과가 있을때만 회원삭제
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setString(1, id);
				preparedStatement2.setString(2, password);
				preparedStatement2.executeUpdate();
				return true;
			}
		} catch (Exception e) {	} return false;
	}
	// 회원정보 출력 메소드
	public Member getMember(String id) {
		String sql="select * from member where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Member member = new Member(
						resultSet.getInt(1),
						resultSet.getString(2),
						null,
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getInt(9),
						resultSet.getString(10));
				return member;
			}
		} catch (Exception e) {} return null;
	}
	/*
	// 회원 이름 수정 메소드
		public boolean infoupdate(String type , String id) {
			String sql ="update member set "+type+"=? where m_id=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, type);
				preparedStatement.setString(2, id);
				preparedStatement.executeUpdate();
				return true;
			} catch (Exception e) {	} return false;
		}
	*/
	// 회원 이름 수정 메소드
	public boolean nameupdate(String name, String id) {
		String sql ="update member set m_name=? where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 회원 비밀번호 수정메소드
	public boolean passwordupdate(String password, String id) {
		String sql ="update member set m_password=? where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 회원 성별 수정 메소드
	public boolean sexupdate(String sex, String id) {
		String sql ="update member set m_sex=? where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sex);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 회원 생년월일 수정 메소드
	public boolean birthupdate(String birth, String id) {
		String sql ="update member set m_birth=? where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, birth);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 회원 연락처 수정 메소드
	public boolean phoneupdate(String phone, String id) {
		String sql ="update member set m_phone=? where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 회원 주소 수정 메소드
	public boolean addressupdate(String address, String id) {
		String sql ="update member set m_address=? where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, address);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 회원번호 검색 메소드
	public int getmembernum(String m_id) {
		String sql = "select m_num from member where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, m_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {	} return 0;
	}
	// 회원아이디 검색 메소드
		public String getmemberid(int m_num) {
			String sql = "select m_id from member where m_num=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, m_num);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getString(1);
				}
			} catch (Exception e) {	} return null;
		}
}
