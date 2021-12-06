package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Board;

public class BoardDao {

	// 인터페이스 
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	// 생성자
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsp?serverTimezone=UTC","root","1234");
		} catch (Exception e) {	System.out.println("게시물DB연동실패");}
	}
	public static BoardDao boardDao = new BoardDao();	// dao 객체 생성
	public static BoardDao getboardDao() {return boardDao;}	// dao 객체 반환
	
	// 게시물 등록 메소드
	public boolean boardwrite(Board board) {
		String sql = "insert into board (b_title,b_contents,m_num,b_file,b_file2) values(?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setInt(3, board.getM_num());
			preparedStatement.setString(4, board.getB_file());
			preparedStatement.setString(5, board.getB_file2());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {} return false;
	}
	// 모든게시물 출력 메소드
	public ArrayList<Board> boardlist() {
		String sql="select * from board order by b_num desc";
		ArrayList<Board> boards = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Board board = new Board(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getInt(8),
						resultSet.getInt(9));
				boards.add(board);
			}
			return boards;
		} catch (Exception e) {	} return null;
	}
	// 해당 게시물 가져오기
	public Board getboard(int b_num) {
		String sql ="select * from board where b_num=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Board board = new Board(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getInt(8),
						resultSet.getInt(9));
						return board;
			}
		} catch (Exception e) {	} return null;
	}
	
}
