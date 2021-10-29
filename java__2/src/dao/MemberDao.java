package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Member;

public class MemberDao {

	// JDBC �ֿ� �������̽� , Ŭ����
		// 1. Connection : DB���� �������̽� [ DriverManager Ŭ���� ]
		
	// 1. �ʵ�
		private Connection connection;	// DB ���� �������̽� ����
		private PreparedStatement preparedStatement;	// SQL ���� �������̽� ����
		private ResultSet resultSet;	// ����(�˻����) ���� �������̽� ����
		// ���� Ŭ������ ��ü �����
		private static MemberDao memberDao = new MemberDao();
	// 2. ������
		public MemberDao() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC" , "root" , "1234");
			} catch (Exception e) {
				System.out.println("DB���� ����: " + e);
			}
		}
	// 3. �޼ҵ�
		public static MemberDao getMemberDao() {return memberDao;}
		
		// ��� �޼ҵ�
		// 1.ȸ������ �޼ҵ�
		public boolean signup(Member member) {
			
			// 1. SQL �ۼ� [ SQL : DB ������ DML ]
			// Ư���ʵ� : INSERT INTO ���̺��(�ʵ��1, �ʵ��2 , �ʵ��3) values(��1 , ��2 , ��3)
			// ����ʵ� : INSERT INTO ���̺�� values(��1 , ��2 , ��3)
			String sql = "insert into member(m_id,m_password,m_name,m_email,m_point) values( ? , ? , ? , ? , ? )";
			
			try {
				// 2. SQL -> DB����
				preparedStatement = connection.prepareStatement(sql);
				// 3. SQL ����
					preparedStatement.setString(1, member.getM_id());
					preparedStatement.setString(2, member.getM_password() );
					preparedStatement.setString(3, member.getM_name());
					preparedStatement.setString(4, member.getM_email());
					preparedStatement.setInt(5, member.getM_point());
					
				// 4. SQL ����
					preparedStatement.executeUpdate();
				// 5. SQL ���
					return true;
			} 
			catch (Exception e) {} 
			return false;
		}
		// 2. �α��� �޼ҵ�
		public boolean login(String id , String password) {
			// 1. SQL �ۼ�
			// Ư���ʵ� : select �ʵ�� from ���̺�� where ����
			// ����ʵ� : select *from ���̺�� where ����
			// * ���� and : �̸鼭 �鼭 �̰� �׸��� ����1 and ����2
				// or : �̰ų� �ų� �Ǵ� �ϳ��� ����1 or ����2
			String sql = "select * from member where m_id=? and m_password=?";
			// 2. SQL -> DB ����
			try {
				preparedStatement = connection.prepareStatement(sql);
				// 3.SQL ���� [ ���� �޼ҵ峻 ���� �μ��� ? ���� ]
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, password);
				// 4.SQL ���� [Query : ���� (�˻� ���)
					resultSet = preparedStatement.executeQuery();
				// 5.SQL ���
					if(resultSet.next()) { // ��������� ���������� ������ true
						return true;
					}else {
						return false;
					}
				}catch (Exception e) {}
				return false;
		}
		// 3. ���̵�ã�� �޼ҵ�
		public String findid(String name , String email) {
			// 1. SQL �ۼ�
			String sql = "select m_id from member where m_name=? and m_email=?";
			// 2. SQL ->DB ����
			try {
				preparedStatement = connection.prepareStatement(sql);
				// 3. SQL����
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, email);
				// 4. SQL ���� 
					resultSet = preparedStatement.executeQuery();
				// 5. SQL ���� ���
					if(resultSet.next()) {
						// �˻� ����� ������
						return resultSet.getString(1); // ����(�˻����)�� ù���� �ʵ带 ��ȯ
					}else {
						return null;	// �˻� ����� ������
					}	
			} catch (Exception e) {}
			return null;
		}
		// 4. ��й�ȣã�� �޼ҵ�
		public String findpassword(String id, String email) {
			// 1. SQL �ۼ�
			String sql = "select m_password from member where m_id=? and m_email=?";
			// 2. SQL -> DB ����
			try {	
				preparedStatement = connection.prepareStatement(sql);
				// 3. SQL ����
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, email);
				// 4. SQL ����
					resultSet = preparedStatement.executeQuery();
				// 5. SQL ���
					if(resultSet.next()) {
						return resultSet.getString(1);
					}else {
						return null;
					}
			} catch (Exception e) {}
			return null;
		}
		
		// 5. ȸ������ �޼ҵ�
		
		// 6. ȸ��Ż�� �޼ҵ�
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// DB���� �׽�Ʈ
	/*
	public static void main(String[] args) {
		
		try {
			// 1. mysql ����̺� Ȯ��
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. ����̺� �������� ����");
			// 2. DB����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC" , "root" , "1234");
				System.out.println("2. DB���� ����");
		} catch (Exception e) {
			System.out.println("DB ���� ����");
		}
		
	}
	*/
}
