package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDao {

	// 1. �ʵ�
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	// ��ü
	private static BoardDao boardDao = new BoardDao();
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC" , "root" , "1234");
		} catch (Exception e) {
			System.out.println("DB���� ����: " + e);
		}
	}
	
	// ��ü ��ȯ �޼ҵ�
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	// �޼ҵ�[CRUD]
		// 1. �Խù� ��� �޼ҵ�
	public boolean write(Board board) {
		String sql = "insert into board(b_title , b_contents , b_write ) values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setString(3, board.getB_write());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {}
		return false;
	}
		// 2. �Խù� ��ȸ �޼ҵ�
	public ObservableList<Board> boardlist(){
		// ����Ʈ ����
		ObservableList<Board> boards = FXCollections.observableArrayList();
		String sql = "select * from board";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			// 2. �˻���[����] ���ڵ��� �ϳ��� ��üȭ
			while(resultSet.next()) {
					//���� ����� ���ڵ尡 ������ ���� �ݺ�
				Board board = new Board(
							resultSet.getInt(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4),
							resultSet.getString(5),
							resultSet.getInt(6));
				boards.add(board);
			}
		} catch (Exception e) {}
		return boards;
		
		
		
	}
		// 3. �Խù� ���� �޼ҵ�
	
		// 4. �Խù� ���� �޼ҵ�
		
		// 5. �Խù� ������ȸ �޼ҵ�
	
	
	
	
	
	
	
	
	
	
}

