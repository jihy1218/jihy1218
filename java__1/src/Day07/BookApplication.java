package Day07;

import java.util.Scanner;

public class BookApplication {

	// 0 . 배열
	public static Member[] members = new Member[100];
	public static Book[] books = new Book[100];
	// 1. 입력객체
	public static Scanner scanner = new Scanner(System.in);
	
	// main 메소드 => 코드실행 시작지점
	public static void main(String[] args) {
		main_menu(); // 메소드 호출
	}
	
	// 1. 메인메뉴 메소드
	public static void main_menu() {
		while(true) {	
			System.out.println("\n\n ========= 로그인 페이지 ==========");
			System.out.println("1.로그인|2.회원가입|3.아이디찾기|4.비밀번호찾기");
			System.out.print(">>> 선택 : "); int ch = scanner.nextInt();
			if(ch==1) {
				// 로그인 메소드 호출
				String loginid = Member.login();
					// login 메소드의 반환값에 따른 제어
				// 1. 로그인 실패
				if(loginid == null ) {System.out.println("[[알림]] 동일한 회원정보가 없습니다");	}
				// 2. 관리자 메뉴
				else if( loginid.equals("admin") ) {admin_menu();}
				// 3. 일반회원 메뉴
				else {member_menu( loginid );}
			}
			if(ch==2) {
				// 회원 가입 메소드 호출
					// 1. 다른 클래스 메소드 호출 방법
						// 1. 객체생성후 객체로 부터 멤버 접근
//				Member member = new Member();
//				Member.signup();
						// 2. 해당 메소드 static
				Member.signup();
			}
			if(ch==3) {
				// 아이디 찾기 메소드 호출
				String findid = Member.findid();
				if(findid == null) {
					System.out.println("[[알림]] 동일한 회원정보가 없습니다");	
				}else {
					System.out.println("[[알림]] 회원님의 아이디는 "+findid +" 입니다");	
				}
			}
			if(ch==4) {
			// 비밀번호 찾기 메소드호출
				String findpw = Member.findpw();
				if(findpw == null) {
					System.out.println("[[알림]] 동일한 회원정보가 없습니다");	
				}else {
					System.out.println("[[알림]] 회원님의 비밀번호는 "+findpw +" 입니다");	
				}
			}
		}
	}
	// 2. 로그인시 메뉴 메소드
	public static void member_menu(String loginid) { 
		Book book = new Book(); // Book 임시객체 : 메소드 호출용
		while(true) {
			System.out.println("============MENU===========");
			System.out.println("1.도서목록|2.대여|3.반납|4.로그아웃");
			System.out.print(">> 선택 : ");		int ch = scanner.nextInt();
			if( ch == 1 ) { book.book_list();}
			if( ch == 2 ) { book.book_rental(loginid);}
			if( ch == 3 ) { book.book_return(loginid);}
			if( ch == 4 ) { System.out.println("[[알림]] 로그아웃 되었습니다."); return; }
		}
		
		
		
	}
	// 3. 관리자 메뉴 메소드
	public static void admin_menu() {
		Book book = new Book(); // Book 임시객체 : 메소드 호출용
		while(true) {
			System.out.println("=====Admin Menu======");
			System.out.println("1.도서등록|2.도서목록|3.로그아웃");
			System.out.print(">> 선택 : "); int ch = scanner.nextInt();
			if( ch == 1 ) { book.book_add();}
			if( ch == 2 ) { book.book_list();}
			if( ch == 3 ) { System.out.println("[[알림]] 로그아웃 되었습니다."); return;}
		}
	
	}
}
