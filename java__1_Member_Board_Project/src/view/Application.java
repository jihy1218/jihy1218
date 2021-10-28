package view;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import controllrer.BoardController;
import controllrer.MemberController;
import controllrer.ReplyController;
import database.File;
import model.Board;
import model.Member;
import model.Reply;

public class Application {

	//  0. 설정 [main 밖에 만드는 이유?? : ]
	public static Scanner scanner = new Scanner(System.in);
		// public :
		// static : 
	
	public static void main(String[] args) {
		
		// 0 . 프로그램 파일 로딩
		File.fileload(1);
		File.fileload(2);
		mainmenu(); // 메인 메뉴 메소드 호출
	}
	// 1. 메인 메뉴 메소드
	public static void mainmenu() {
		// void
		
		while(true) {
			try {
				System.out.println("===============회원 커뮤니티===================");
				System.out.println("1.로그인|2.회원가입|3.아이디찾기|4.비밀번호찾기");
				System.out.print("\t 선택 : "); int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("===============로그인 페이지===================");
					System.out.println("ID : "); String id = scanner.next();
					System.out.println("Password : "); String password = scanner.next();
					
					boolean result = MemberController.login(id, password);
					if(result) {// 로그인 성공시
						System.out.println("[알림] : 로그인 성공");
						membermenu(id); // 회원메뉴 메소드 호출
					}else { // 로그인 실패시
						System.out.println("[알림] : 로그인 실패 [ 동일한 회원정보가 없습니다.]");
					}
				}else if(ch==2) {
					System.out.println("===============회원가입 페이지===================");
					// 입력받기 -> 변수 저장 -> 변수가 여러개 -> 객체 -> 객체 여러개 -> 배열/컬렉션 저장
					System.out.println("ID[4글자이상] : "); String id = scanner.next();
					System.out.println("Password[4글자만] : "); String password = scanner.next();
					System.out.println("Name[2글자이상] : "); String name = scanner.next();
					System.out.println("Email[@형식] : "); String email = scanner.next();
					
					// 4개 변수를 따로따로 저장하면 힘들어짐 => 4개 변수를 묶어줄 객체화
					Member member = new Member(id, password, name, email, 0);
					
					// Controller 전달[ 다른클래스내 호출하는방법
					boolean result = MemberController.signup(member);
					if(result) {
						System.out.println("[알림] : 회원가입 성공");
					}else {
						System.out.println("[알림] : 회원가입 실패");
					}
					System.out.println("=========================================");
				}else if(ch==3) {
					System.out.println("===============아이디 찾기 페이지===================");
					System.out.println("Name : "); String name = scanner.next();
					System.out.println("Email : "); String email = scanner.next();
					
					boolean result = MemberController.forgotid(name, email);
					if(result) {
						System.out.println("[알림] : 회원님의 아이디를 이메일로 전송했습니다.");
					}else {
						System.out.println("[알림] : 동일한 회원정보가 없습니다.");
					}
				}else if(ch==4) {
					System.out.println("===============비밀번호 찾기 페이지===================");
					System.out.println("ID : "); String id = scanner.next();
					System.out.println("Email : "); String email = scanner.next();
					
					boolean result = MemberController.forgotpassword(id, email);
					if(result) {
						System.out.println("[알림] : 회원님의 비밀번호를 이메일로 전송했습니다.");
					}else {
						System.out.println("[알림] : 동일한 회원정보가 없습니다.");
					}
				}else {
					System.out.println("[알림] : 알수없는 행동 입니다.[관리자에게문의]");
				}
			}
			catch(Exception e) {
				System.out.println(" [알림] : 메뉴페이지 오류[관리자호출]");
				scanner = new Scanner(System.in); // 입력객체 초기화
						// new : 메모리 초기화 
			}
		}
	}
	// 2. 회원 메뉴 메소드
	public static void membermenu(String id) {
		while (true) {
			try {
				System.out.println("===============회원 페이지===================");
				System.out.println("1.회원정보|2.커뮤니티|3.로그아웃");
				System.out.println("=========================================");
				System.out.print("\t 선택 : "); int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("===============회원 정보 페이지===================");
					
					System.out.println("=========================================");
				}
				if(ch==2) {
					boardmenu(id); // 게시판 메소드 호출
				}
				if(ch==3) {
					//break; // 가장가까운 반복문 탈출
					return; // 현재 메소드 리턴[반환] 끝내기
				}
			} catch (Exception e) {
				System.out.println(" [알림] : 메뉴페이지 오류[관리자호출]");
				scanner = new Scanner(System.in); // 입력객체 초기화
						// new : 메모리 초기화 
			} 
		} // while 종료
	} // void 종료
		// 3. 게시판 메뉴 메소드

	public static void boardmenu(String id) {
		while (true) {
			try {
				// 게시물 출력
				System.out.println("===============게시판 페이지===================");
				System.out.printf("번호\t타이틀\t\t작성자\t작성일\t조회수\n");

				int i = 1; // for 반복횟수 i=> 게시물번호
				for (Board board : BoardController.boardList) {
					System.out.println(i + "\t" + board.getTitle() + "\t\t" + board.getWriter() + board.getDate() + "\t"
							+ board.getView());
					i++;
				}
				System.out.println("=========================================");
				System.out.println("1.게시물등록|2.상세보기|3.뒤로가기");
				System.out.println("=========================================");
				System.out.print("\t 선택 : ");
				int ch = scanner.nextInt();
				if (ch == 1) {
					System.out.println("===============게시물 등록 ==================");
					// 입력받기 -> 변수 저장 -> 객체 -> 리스트 -> 파일
					scanner.nextLine(); // next 다음에 nextLine 을
					System.out.println(" 제목 : ");
					String title = scanner.nextLine();
					System.out.println(" 내용 : ");
					String contents = scanner.nextLine();
					System.out.println("=========================================");

					Board board = new Board(title, contents, id);
					BoardController.add(board);

				}
				if (ch == 2) {
					System.out.println(">> 게시물번호 : ");
					int index = scanner.nextInt();
					Board board = BoardController.detail(index - 1);
					if (board == null) {
						System.out.println("[알림] : 선택한 게시물 번호가 존재하지 않습니다.");
					} else {
						System.out.println("===============게시물 상세페이지================");
						System.out.println(" 제목 : " + board.getTitle());
						System.out.println(" 내용 : " + board.getContents());
						System.out.println(" 작성자 : " + board.getWriter());
						System.out.println(" 작성일 : " + board.getDate());
						System.out.println(" 조회수 : " + board.getView());
						System.out.println("-----------------댓 글----------------------");
						System.out.println("작성자\t댓글내용\t\t작성일");
						for (Reply reply : board.getReplylist()) {
							System.out.println(reply.getWriter()+"\t"+
											reply.getContents()+"\t\t"+reply.getDate());
						}
						System.out.println("============================================");
						System.out.print("1.댓글쓰기|2.뒤로가기");
						if(board.getWriter().equals(id)) {	// 게시물작성자 == 로그인된id
							System.out.println("3.게시물삭제|4.게시물수정");
						}
						int ch2 = scanner.nextInt();
						if (ch2 == 1) {	// 댓글쓰기
							scanner.nextLine();
							System.out.println(" 내용 : ");	String contents = scanner.nextLine();
							Reply reply = new Reply(contents, id);
							boolean result = ReplyController.add(index - 1, reply);
							if (result) {
								System.out.println("[알림] : 댓글 등록 완료");
							} else {
								System.out.println(" [알림] : 게시물번호가 존재하지않습니다.");
							}
						}
						if(ch==2) {return;}
						if(ch==3) {}
						if(ch==4) {}
						
					}
				}
				if (ch == 3) {
					return; // 현재 메소드 리턴[반환] 끝내기
				}
			} catch (Exception e) {
				System.out.println(" [알림] : 메뉴페이지 오류[관리자호출]");
				scanner = new Scanner(System.in); // 입력객체 초기화
				// new : 메모리 초기화
			}
		} // while 종료
	} // void 종료

}
