package Day15;

import java.util.HashSet;
import java.util.Scanner;

public class Day15_문제2로또프로그램 {

//	문제 2 : set 컬렉션
//	로또 프로그램
//	1. 6개를 입력받아 set컬렉션에 저장하여 출력
//	2. 중복값 허용x
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		
		while(true) {
			System.out.println("1~45 숫자 선택(중복불가) : ");
			int num = scanner.nextInt();
			
			if(num<1 || num > 45) {
				System.out.println("선택할수없는 번호입니다.");
			}else {
				//중복확인
				if(set.contains(num)) {
					System.out.println("중복번호입니다.");
				}
				set.add(num);
				System.out.println("확인"+set);
			}
			// 무한루프 끝나는 조건 : 6개 모두 입력 되었을때
			if(set.size() == 6) break;
		}
		
		
	}
	
	
}
