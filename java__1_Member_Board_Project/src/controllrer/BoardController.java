package controllrer;

import java.util.ArrayList;

import database.File;
import model.Board;

public class BoardController {

	// 1.
	public static ArrayList<Board> boardList = new ArrayList<>();
		// static 없을 경우 해당 필드 호출시 [ BoardController 객체 생성 ]
		// static 있을 경우 해당 필드 바로 호출 가능

	// 2. 메소드
	// 게시물 등록 메소드
	public static boolean add(Board board) {

		// 1. 유효성 검사x
		// 2. 중복체크 x
		// 3. 리스트저장
		boardList.add(board);
		// 4. 파일처리
		File.filesave(2);
		
		return true;
	}

	// 게시물 상세페이지 메소드
	public static Board detail(int index) {
		try {
		Board board = boardList.get(index);
		return board; // 입력한 게시물 반환
		}catch (Exception e) {
			return null;
		}
	}

	// 게시물 삭제 메소드
	public static boolean delete(int index) {
		return true;
	}

	// 게시물 수정 메소드
	public static boolean update(int index, String title, String contents) {
		return true;
	}
}
