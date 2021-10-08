package 연습;

import java.util.Scanner;

public class BankApplication {

	
	// 계좌객체를 저장할수있는 배열 선언
	
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
		// private : 현재 클래스 내에서만 호출가능
			// static : 프로그램 전반에 걸쳐 수명 유지
	
	public static void main(String[] args) {
		
		boolean run = true;
		while(run) {
			System.out.println("=================================");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("=================================");
			System.out.print("선택하십시요 >>");
			int selectNo = scanner.nextInt();
			if(selectNo == 1) { createAccount();}
			if(selectNo == 2) { accountList();}
			if(selectNo == 3) {}
			if(selectNo == 4) { }
			if(selectNo == 5) { run = false;}
			
		}
		System.out.println("프로그램 종료");
	}
	
	// 계좌생성 [ 인수x 반환x ]
	private static void createAccount() {
		System.out.println("================");
		System.out.println("=====계좌생성======");
		System.out.println("================");
		//입력받기
		System.out.println(">> 계좌번호 : " ); String ano = scanner.next();
		System.out.println(">> 성명 : "); String owner = scanner.next();
		System.out.println(">> 최초입금액 : "); int balance = scanner.nextInt();
		
		//객체생성 [입력 받은 변수값을 객체 생성자에 넣어서 객체 만들기]
		Account account = new Account(ano, owner, balance);
		//배열저장 [배열내 빈공간[null]을 찾아서 빈공간 인덱스에 객체 저장]
		for( int i = 0 ; i<accountArray.length ; i++ ) {
			if( accountArray[i] == null ) { // i번째 인덱스가 비어있으면
				accountArray[i] = account;	// i번째 인덱스의 객체 넣기
				System.out.println("결과 : 계좌가 개설되었습니다.");
				break; // 반복문종료
			}
		}
	}
	// 계좌목록
	private static void accountList() {
		System.out.println("===============");
		System.out.println("====계좌목록======");
		System.out.println("===============");
		
		// 배열내 모든 인덱스를 호출 [ null 제외 ]
		for(int i = 0 ; i<accountArray.length ; i++) {
			if(accountArray[i] == null) break;
			
			System.out.println( accountArray[i].getAno() + "\t" 
						+ accountArray[i].getOwner() + "\t"
						+ accountArray[i].getBalance() );
		}
	}
	// 예금
	
	// 출금
	

	
	
	
}
