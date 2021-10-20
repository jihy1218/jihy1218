package Day15;

import java.util.Hashtable;
import java.util.Scanner;

public class Day15_4 {

	public static void main(String[] args) {
		
		// Hashtable // 회원가입 // 로그인
		// 0. 입력객체
		Scanner scanner = new Scanner(System.in);
		// 0. map 컬렉션 선언
		Hashtable<String, String> hashtable =  new Hashtable<>();
				// 아이디 , 비밀번호
		
		// 메뉴
		while(true) {
			System.out.println("1.회원가입 2.로그인");	int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("아이디 : ");		String id =  scanner.next();
				System.out.println("비밀번호 : ");		String password = scanner.next();
				
					// 중복체크
					if(hashtable.containsKey(id)) {
						System.out.println("==이미 사용중인 아이디 입니다.==");
					}else {
						// 1. map 에 객체 넣기
						hashtable.put(id, password); 
						System.out.println("==가입성공==");
					}
			}
			if(ch==2) {
				System.out.println("아이디 : ");		String id =  scanner.next();
				System.out.println("비밀번호 : ");		String password = scanner.next();
				if(hashtable.containsKey(id)) {
			
					if(hashtable.get(id).equals(password)) {
						System.out.println("로그인성공");
					}else {
						System.out.println("패스워드가 다릅니다.");
					}
					
				}else {
					System.out.println("아이디가 다릅니다.");
				}
			}
		}
	} 
}
