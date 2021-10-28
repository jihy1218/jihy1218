package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import controllrer.BoardController;
import controllrer.MemberController;
import model.Board;
import model.Member;

public class File {

	// 필드 
		// 1. 회원정보를 저장하는 파일의 경로
	private static String memberpath =
			"D:/JavaWeb/java__1_Member_Board_Project/src/database/memberlist.txt";
		// 2. 게시물을 저장하는 파일의 경로
	private static String boardpath =
			"D:/JavaWeb/java__1_Member_Board_Project/src/database/boardlist.txt";
	
	// 메소드
	public static boolean filesave(int type) {
		try {
								// type : 1.회원저장 2. 게시물저장 3. 댓글저장
			FileOutputStream fileOutputStream = null; // 선언만
			if(type==1) { // 회원저장
				// 1. 파일객체에 경로 설정
				fileOutputStream = new FileOutputStream(memberpath);
				// 2. 반복문을 이요한 회원리스트에서 하나씩 회원 가져오기
				for(Member member : MemberController.memberlist) {
					// 3. 각 회원마다 필드[,]와 회원[\n] 구분
					String outstring = member.getId()+","+member.getPassword()+","+
										member.getName()+","+member.getEmail()+","+
										member.getPoint()+"\n";
					// 4. 바이트로 내보내기
					fileOutputStream.write( outstring.getBytes());
				}
				// 5. 스트림 사용후 초기화
				fileOutputStream.flush();	// 파일 스트림내 존재하는 바이트 제거
				fileOutputStream.close();	// 파일 스트림 닫기
				
				return true; // 파일 저장 성공시
			}
			if(type==2) {
				// 1. 파일객체에 경로 설정
				fileOutputStream = new FileOutputStream(boardpath);
				// 2. 반복문을 이용한 회원리스트에서 하나씩 회원 가져오기
				for(Board board : BoardController.boardList) {
					// 3. 각 회원마다 필드[,]와 회원[\n] 구분
					String outstring = board.getTitle()+","+board.getContents()+","+
										board.getWriter()+","+board.getDate()+","+
										board.getView()+"\n";
					// 4. 바이트로 내보내기
					fileOutputStream.write( outstring.getBytes());
				}
				// 5. 스트림 사용후 초기화
				fileOutputStream.flush();	// 파일 스트림내 존재하는 바이트 제거
				fileOutputStream.close();	// 파일 스트림 닫기
				
				return true; // 파일 저장 성공시
			}
			if(type==3) {}
			
		}catch(Exception e) {
			System.out.println("[알림] : 파일 저장 오류 발생 [ 관리자에게 문의 ]");
		}
		return false; // 파일처리 실패
	}
	
	public static boolean fileload(int type) {
		try {
			FileInputStream fileInputStream = null;
			// 외워서쓰기
		
			if(type==1) {
				// 1. 입력스트림 경로 설정
				fileInputStream = new FileInputStream(memberpath);
				// 2. 스트림 (단위 : 바이트) 바이트배열 선언
				byte[] bytes = new byte[10000];
				// 3. 입력스트림에서 바이트 읽어와서 배열에 저장
				fileInputStream.read(bytes);
				// 4. 바이트배열 -> 문자열 변환
				String inString = new String(bytes);
				// 5. 회원분리하기 \n
				String[] members = inString.split("\n");
				// 6. 반복문을 이용한 회원별 필드 분리하기
				for(int i = 0 ; i<members.length-1 ; i++) { // -1 은 공백회원제외
					// 회원별 필드 분리
					String[] field = members[i].split(",");
					// 분리된 필드 객체화  String -> int
					Member member =  new Member(field[0], field[1], field[2], field[3], Integer.parseInt(field[4]));
					// 객체
					MemberController.memberlist.add(member);
				}
				fileInputStream.close(); // 스트림 닫기
				return true; // 파일 불러오기 성공
			}
			if(type==2) {
				fileInputStream = new FileInputStream(boardpath);
				byte[] bytes = new byte[10000];
				fileInputStream.read(bytes);
				String inString = new String(bytes);
				String[] boards = inString.split("\n");
				// 6. 반복문을 이용한 회원별 필드 분리하기
				for(int i = 0 ; i<boards.length-1 ; i++) { // -1 은 마지막게시물제외
					// 회원별 필드 분리
					String[] field = boards[i].split(",");
					// 분리된 필드 객체화  String -> int
					Board board =  new Board(field[0], field[1], field[2], field[3], Integer.parseInt(field[4]));
					// 객체
					BoardController.boardList.add(board);
				}
				fileInputStream.close(); // 스트림 닫기
				return true; // 파일 불러오기 성공
			}
			if(type==3) {}
			
		}
		catch(Exception e) {
			System.out.println("[알림] : 파일 불러오기 오류 발생[관리자에게 문의]");
		}
		return true; // 파일 불러오기 성공시
	}
}
