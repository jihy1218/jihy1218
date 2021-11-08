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
		public boolean update(String id , String name , String email) {
			// 1. SQL �ۼ�
			String sql = "update member set m_name=? , m_email=? where m_id = ?";
						// update ���̺��� set �����ʵ�=�� , �����ʵ�2 = ��2 where ����
			// 2. SQL -> DB����
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
		// 6. ȸ��Ż�� �޼ҵ�
		public boolean delete(String loginid) {
			// 1. SQL �ۼ�
			String sql = " delete from member where m_id=?";
						// delete from ���̺��
						// delete from ���̺�� where ����
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, loginid);
				preparedStatement.executeUpdate();
				return true;	// Ż�� ������
			} catch (Exception e) {}
			return false;
		}
		// 7. ȸ����ȸ �޼ҵ� [ȸ�� ���̵� �μ��� �޾� ȸ������ ��ȯ]
		public Member getmember(String loginid) {
			// 1.SQL �ۼ�
			String sql = "select * from member where m_id=?";
			// 2.SQL->DB ����
			try {
				preparedStatement = connection.prepareStatement(sql);
				// 3.SQL ����
				preparedStatement.setString(1, loginid);	
				// 4.SQL ����
				resultSet = preparedStatement.executeQuery();
				// 5.SQL ���
				if(resultSet.next()) {
					// �н����带 ������ ȸ������ ���
					Member member = new Member(resultSet.getString(2), " ", resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
					return member;
				}else {
					return null;
				}
			} catch (Exception e) {}
			return null; // db����
		}
		// 8. ���̵� üũ �޼ҵ�
		public boolean idcheck(String id) {
			String sql = "select m_id from member where m_id=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {return true;}	// ���� ���̵� �����ϸ�
				else {return false;}		// ���� ���̵� �������� ������
			} catch (Exception e) {}
			return true;
		}
		
		// 9. ����Ʈ ���� �޼ҵ�
		public boolean pointupdate (String id, int point) {
			String sql = "update member set m_point = m_point + ? where m_id=?";
						// update ���̺�� set �������ʵ�� = �����Ұ� where ����
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, point);
				preparedStatement.setString(2, id);
				preparedStatement.executeUpdate();
				return true;
			} catch (Exception e) {}
			return false;
			
		}
		// 10. ȸ��id�� ȸ����ȣ ã�� �޼ҵ�
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
		
		// 11. ȸ����ȣ�� ȸ��id ã�� �޼ҵ�
		public String midcheck(int m_no) {
			String sql = "select m_id from member where m_no=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, m_no);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {return resultSet.getString(1);}	// ���� ���̵� �����ϸ�
				else {return "";}		// ���� ���̵� �������� ������
			} catch (Exception e) {}
			return "";
		}
		
		// 12. ȸ�� �� ��ȯ �޼ҵ�
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
		/*	 �Խ��� ����
			// 1. DB����
					// �Խù���ȣ 				int
					// �Խù����� 				String
					 * �Խù�����				String
					 * �Խù��ۼ���[�α��ε� id]	String
					 * �Խù� �ۼ���[�ڵ� ����]	String
					 * �Խù� ��ȸ��			int
					 
			// 2. DTO ����
			// 3. DAO ����
			// 4. FXML �ۼ�
			// 5. Controller �ۼ�
			// 6. DAO �ۼ�
		
			// DDL : ���Ǿ�
		 		* create table DB�� ���̺��
		 		* 	�ʵ��1 �ڷ��� �Ӽ�,
		 		*	�ʵ��2 �ڷ��� �Ӽ�,
		 		*	�ʵ��3 �ڷ��� �Ӽ�
		 		Drop ����
		 		Alter
		 	*�ڷ���
		 	*	int : ������
		 	*	varchar : ���ڿ�	(����Ʈ)
		 	*	timestamp : ��¥/�ð� (4����Ʈ)
		 	
			�Ӽ�
				primary key : �⺻Ű[pk]
				auto increment : �ڵ���ȣ ����[ai]
				not null : null�� ����
				default : �ʱⰪ
			�Լ�
				now : ���糯¥/�ð�
				ȸ�� 					�Խ���			���
				ȸ����ȣ				�Խù���ȣ			��۹�ȣ
				ȸ�����̵�				�Խù�����			��۳���
				ȸ����й�ȣ			�Խù�����			����ۼ���
				ȸ���̸�				ȸ����ȣ			����ۼ���
									�Խù��ۼ���			
				ȸ���̸���				�Խù��ۼ���		�Խù���ȣ
				ȸ������Ʈ				�Խù���ȸ��
				PK					FK				FK
				
				ȸ����ȣ[PK]--------->ȸ����ȣ[FK]
									�Խù���ȣ[PK]---->�Խù���ȣ[FK]
				pk : �ĺ� ������ Ű [ �ĺ� �ʵ� : �ߺ�x null x ]
						��) �ֹε�Ϲ�ȣ , ���, �й�, ī���ȣ , ������ȣ , �ּ� ��
						�ٸ� ���̺�� ����� ���Ǵ� �ĺ�Ű [ ��κ�1]
				fk : pk�� ����� �ʵ�
					* �ܷ�Ű
					* �ٸ����̺� pk�� ����� �ʵ� ��κ�[M]
					* 
					
				DB�Լ�[�޼ҵ�]
				now() : �ý��۳�¥/�ð�
				count(�ʵ�) : �ش� �ʵ��� ���ڵ� ��
				
				������ 
				XYchart.Series ������ : new XYChart.Series<>();
				�迭�̸� 
				�迭��.setName
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
