package 테스트;

import java.util.Scanner;

public class BankApplication {
	
	// 계좌생성 배열 만들기
	static Account[] accountArray= new Account[100];
	static Scanner scanner = new Scanner(System.in);
	
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
			if(selectNo == 3) { }
			if(selectNo == 4) { }
			if(selectNo == 5) { run = false;}
		}
		System.out.println("프로그램 종료");
	}
	
	//계좌생성 createAccount
		// 입력받기
	static void createAccount() {
		System.out.println("==============");
		System.out.println("====계좌생성====");
		System.out.println("==============");
		
		System.out.println(">> 계좌번호 "); String ano = scanner.next();
		System.out.println(">> 성명 "); 	 String owner = scanner.next();
		System.out.println(">> 최초입금액 "); int balance = scanner.nextInt(); // 정수니까
		
		//객체 생성
		Account account = new Account(ano, owner, balance);
		//배열 저장
		for(int i = 0 ; i<accountArray.length; i++) {
			if( accountArray[i] == null ) { //[i] 가 비어있으면
				accountArray[i] = account; 	//[i]에 account를 넣어라
				System.out.println("계좌가 개설되었습니다");
				break;
			}
		}
	}
	//계좌목록	accountList
	static void accountList() {
		System.out.println("==============");
		System.out.println("====계좌목록====");
		System.out.println("==============");
		
		for( int i = 0 ; i<accountArray.length; i++) {
			if( accountArray[i] == null )	break;
			
			System.out.println(accountArray[i].getAno() + "\t" 
							+ accountArray[i].getOwner() + "\t"
							+ accountArray[i].getBalance() );
			
		}
	}
	static Account findAccount(String ano) {
			Account account = null;
			for(int i = 0 ; i<accountArray.length ; i++ ) {
				if(accountArray != null ) {
					if(accountArray[i].getAno().equals(ano)) {
						account = accountArray[i];
						break;
					}
				}
			} return account;
	}
	//예금 deposit
	static void deposit() {
		System.out.println("=============");
		System.out.println("=====예금=====");
		System.out.println("=============");
		
		//입력받기 
		System.out.println(">> 계좌번호 "); String ano = scanner.next();
		System.out.println(">> 예금액 "); int balance = scanner.nextInt();
		//객체 생성
		Account account = findAccount(ano);
		
		
	}
	//출금 withdraw
}
