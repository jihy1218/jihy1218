package controllrer;

import java.util.ArrayList;

import database.File;
import model.Board;

public class BoardController {

	// 1.
	public static ArrayList<Board> boardList = new ArrayList<>();
		// static ���� ��� �ش� �ʵ� ȣ��� [ BoardController ��ü ���� ]
		// static ���� ��� �ش� �ʵ� �ٷ� ȣ�� ����

	// 2. �޼ҵ�
	// �Խù� ��� �޼ҵ�
	public static boolean add(Board board) {

		// 1. ��ȿ�� �˻�x
		// 2. �ߺ�üũ x
		// 3. ����Ʈ����
		boardList.add(board);
		// 4. ����ó��
		File.filesave(2);
		
		return true;
	}

	// �Խù� �������� �޼ҵ�
	public static Board detail(int index) {
		try {
		Board board = boardList.get(index);
		return board; // �Է��� �Խù� ��ȯ
		}catch (Exception e) {
			return null;
		}
	}

	// �Խù� ���� �޼ҵ�
	public static boolean delete(int index) {
		return true;
	}

	// �Խù� ���� �޼ҵ�
	public static boolean update(int index, String title, String contents) {
		return true;
	}
}
