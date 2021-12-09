package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	
	// public : 단어 뜻 그대로 외부 클래스가 자유롭게 사용할 수 있도록 합니다.
	// protected : 같은 패키지 또는 자식 클래스에서 사용할 수 있도록 합니다.
	// private : 단어 뜻 그대로 개인적인 것이라 외부에서 사용될 수 없도록 합니다.
	// default : 위 3가지 접근제한자가 적용되지 않으면 기본 적용
	//			같은 패키지에 소속된 클래스에서만 사용할 수 있도록 합니다.
	
	// 생성자
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsp?serverTimezone=UTC","root","1234");
		} catch (Exception e) {	System.out.println("DB연동실패");}
	}
}
