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

	// 1. 필드
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	// 객체
	private static BoardDao boardDao = new BoardDao();
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC" , "root" , "1234");
		} catch (Exception e) {
			System.out.println("DB연동 실패: " + e);
		}
	}
	
	// 객체 반환 메소드
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	// 메소드[CRUD]
		// 1. 게시물 등록 메소드
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
		// 2. 게시물 조회 메소드
	public ObservableList<Board> boardlist(){
		// 리스트 선언
		ObservableList<Board> boards = FXCollections.observableArrayList();
		String sql = "select * from board";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			// 2. 검색된[쿼리] 레코드이 하나씩 객체화
			while(resultSet.next()) {
					//쿼리 결과내 레코드가 없을떄 까지 반복
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
		// 3. 게시물 삭제 메소드
	
		// 4. 게시물 수정 메소드
		
		// 5. 게시물 개별조회 메소드
	
	
	
	
	
	
	
	
	
	
}

