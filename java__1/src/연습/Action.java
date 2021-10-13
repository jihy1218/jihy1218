package 연습;

import java.util.Scanner;

public class Action {

	public static Child[] childs = new Child[3];
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Child child = new Child();
				
		while(true) {
			try {
			scanner = new Scanner(System.in);
			System.out.println("-----------프로그램----------");
			System.out.println("1.로그인|2.회원가입|");
			System.out.println("---------------------------");
			System.out.print("선택 : "); int ch = scanner.nextInt();
			
			
			if(ch==1) {	child.login(); }
			if(ch==2) {	child.signup();	}
			
			}catch(Exception e) {
				System.out.println("예외가 발생했습니다. [ 관리자에게 문의 ]");
				System.out.println("예외정보 : " + e);  
			} 
		} 
	}
}
