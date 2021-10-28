package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import controllrer.BoardController;
import controllrer.MemberController;
import model.Board;
import model.Member;

public class File {

	// �ʵ� 
		// 1. ȸ�������� �����ϴ� ������ ���
	private static String memberpath =
			"D:/JavaWeb/java__1_Member_Board_Project/src/database/memberlist.txt";
		// 2. �Խù��� �����ϴ� ������ ���
	private static String boardpath =
			"D:/JavaWeb/java__1_Member_Board_Project/src/database/boardlist.txt";
	
	// �޼ҵ�
	public static boolean filesave(int type) {
		try {
								// type : 1.ȸ������ 2. �Խù����� 3. �������
			FileOutputStream fileOutputStream = null; // ����
			if(type==1) { // ȸ������
				// 1. ���ϰ�ü�� ��� ����
				fileOutputStream = new FileOutputStream(memberpath);
				// 2. �ݺ����� �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
				for(Member member : MemberController.memberlist) {
					// 3. �� ȸ������ �ʵ�[,]�� ȸ��[\n] ����
					String outstring = member.getId()+","+member.getPassword()+","+
										member.getName()+","+member.getEmail()+","+
										member.getPoint()+"\n";
					// 4. ����Ʈ�� ��������
					fileOutputStream.write( outstring.getBytes());
				}
				// 5. ��Ʈ�� ����� �ʱ�ȭ
				fileOutputStream.flush();	// ���� ��Ʈ���� �����ϴ� ����Ʈ ����
				fileOutputStream.close();	// ���� ��Ʈ�� �ݱ�
				
				return true; // ���� ���� ������
			}
			if(type==2) {
				// 1. ���ϰ�ü�� ��� ����
				fileOutputStream = new FileOutputStream(boardpath);
				// 2. �ݺ����� �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
				for(Board board : BoardController.boardList) {
					// 3. �� ȸ������ �ʵ�[,]�� ȸ��[\n] ����
					String outstring = board.getTitle()+","+board.getContents()+","+
										board.getWriter()+","+board.getDate()+","+
										board.getView()+"\n";
					// 4. ����Ʈ�� ��������
					fileOutputStream.write( outstring.getBytes());
				}
				// 5. ��Ʈ�� ����� �ʱ�ȭ
				fileOutputStream.flush();	// ���� ��Ʈ���� �����ϴ� ����Ʈ ����
				fileOutputStream.close();	// ���� ��Ʈ�� �ݱ�
				
				return true; // ���� ���� ������
			}
			if(type==3) {}
			
		}catch(Exception e) {
			System.out.println("[�˸�] : ���� ���� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false; // ����ó�� ����
	}
	
	public static boolean fileload(int type) {
		try {
			FileInputStream fileInputStream = null;
			// �ܿ�������
		
			if(type==1) {
				// 1. �Է½�Ʈ�� ��� ����
				fileInputStream = new FileInputStream(memberpath);
				// 2. ��Ʈ�� (���� : ����Ʈ) ����Ʈ�迭 ����
				byte[] bytes = new byte[10000];
				// 3. �Է½�Ʈ������ ����Ʈ �о�ͼ� �迭�� ����
				fileInputStream.read(bytes);
				// 4. ����Ʈ�迭 -> ���ڿ� ��ȯ
				String inString = new String(bytes);
				// 5. ȸ���и��ϱ� \n
				String[] members = inString.split("\n");
				// 6. �ݺ����� �̿��� ȸ���� �ʵ� �и��ϱ�
				for(int i = 0 ; i<members.length-1 ; i++) { // -1 �� ����ȸ������
					// ȸ���� �ʵ� �и�
					String[] field = members[i].split(",");
					// �и��� �ʵ� ��üȭ  String -> int
					Member member =  new Member(field[0], field[1], field[2], field[3], Integer.parseInt(field[4]));
					// ��ü
					MemberController.memberlist.add(member);
				}
				fileInputStream.close(); // ��Ʈ�� �ݱ�
				return true; // ���� �ҷ����� ����
			}
			if(type==2) {
				fileInputStream = new FileInputStream(boardpath);
				byte[] bytes = new byte[10000];
				fileInputStream.read(bytes);
				String inString = new String(bytes);
				String[] boards = inString.split("\n");
				// 6. �ݺ����� �̿��� ȸ���� �ʵ� �и��ϱ�
				for(int i = 0 ; i<boards.length-1 ; i++) { // -1 �� �������Խù�����
					// ȸ���� �ʵ� �и�
					String[] field = boards[i].split(",");
					// �и��� �ʵ� ��üȭ  String -> int
					Board board =  new Board(field[0], field[1], field[2], field[3], Integer.parseInt(field[4]));
					// ��ü
					BoardController.boardList.add(board);
				}
				fileInputStream.close(); // ��Ʈ�� �ݱ�
				return true; // ���� �ҷ����� ����
			}
			if(type==3) {}
			
		}
		catch(Exception e) {
			System.out.println("[�˸�] : ���� �ҷ����� ���� �߻�[�����ڿ��� ����]");
		}
		return true; // ���� �ҷ����� ������
	}
}
