package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Board;
import dto.Reply;

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
	// 조회수 증가 메소드
	public boolean boardcount(int b_num) {
		String sql="update board set b_view = b_view+1 where b_num=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 게시물 삭제 메소드
	public boolean delete(int b_num) {
		String sql ="delete from board where b_num=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 게시물 수정 메소드
	public boolean update(Board board) {
		String sql = "update board set b_title=? , b_contents=? , b_file=? , b_file2=? where b_num=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setString(3, board.getB_file());
			preparedStatement.setString(4, board.getB_file2());
			preparedStatement.setInt(5, board.getB_num());
			preparedStatement.executeUpdate();
			return true; 
		}catch (Exception e) {} return false;
	}
	// 검색 게시물
	public ArrayList<Board> boardlist(int startrow, int listsize ,String key, String keyword) {
		ArrayList<Board> boards = new ArrayList<>();
		String sql = null;
		if(key==null&&keyword==null) { // 키워드가 없을경우
			sql ="select * from board order by b_num desc limit ?,?";
		}else{
			if(key.equals("b_writer")) {	// like : 포함된 값 검색
				int m_num = MemberDao.getmemberDao().getmembernum(keyword);
				sql="select * from board where m_num ="+ m_num +" order by b_num desc limit ?,?";
			}else if(key.equals("b_num")) {	// 번호검색 : 일치한 값 검색
				sql="select * from board where b_num="+ keyword +" order by b_num desc limit ?,?";
			}else {							// 제목 혹은 내용 검색 : 포함된 값 검색
				sql="select * from board where "+key+" like '%"+ keyword +"%' order by b_num desc limit ?,?";
			}
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startrow);
			preparedStatement.setInt(2, listsize);
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
	// 게시물 총 갯수
	public int boardcount(String key ,String keyword) {
		String sql = null;
		if(key!=null&&keyword != null) {	// 검색이 있을때 [ 조건 레코드 개수 세기 ]
			if(key.equals("b_writer")) {	// 작성자 검색  : 작성자 -> 회원번호
				int m_num = MemberDao.getmemberDao().getmembernum(keyword);
				sql="select count(*) from board where m_num ="+ m_num;
			}else if(key.equals("b_num")) {	// 번호검색 : 일치한 값 검색
				sql="select count(*) from board where b_num="+ keyword;
			}else {							// 제목혹은 내용 검색 : 포함된 값 검색
				sql="select count(*) from board where "+key+" like '%"+keyword+"%'";
			}
		}else {	// 검색이 없을때		[ 조건없는 모든 레코드 개수 세기 ] 
			sql = "select count(*) from board"; // count(*) 개수를 구하는 함수
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {	} return 0;		
	}
	// 댓글 등록 메소드
	public boolean replywrite(Reply reply) {
		String sql ="insert into reply(r_contents , m_num , b_num) values(?,?,?)";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, reply.getR_contents());
			preparedStatement.setInt(2, reply.getM_num());
			preparedStatement.setInt(3, reply.getB_num());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {} return false;
	}
	// 댓글 출력 메소드
	public ArrayList<Reply> replylist(int b_num, int startrow, int listsize){
		ArrayList<Reply> replys = new ArrayList<>();
		String sql = "select * from reply where b_num=? order by r_num desc limit ?,?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			preparedStatement.setInt(2, startrow);
			preparedStatement.setInt(3, listsize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Reply reply = new Reply(resultSet.getInt(1),
										resultSet.getString(2),
										resultSet.getString(3),
										resultSet.getInt(4),
										resultSet.getInt(5));
				replys.add(reply);
			}
			return replys;
		} catch (Exception e) {	} return null;
	}
	// 댓글 삭제 메소드
	public boolean replydelete(int r_num) {
		String sql = "delete from reply where r_num=?";
		try {
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, r_num);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	//댓글 총 갯수
	public int replycount(int b_num) {
		String sql ="select count(*) from reply where b_num=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {	} return 0;
	}
	
} // class end