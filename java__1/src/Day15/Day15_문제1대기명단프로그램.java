package Day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Day15_문제1대기명단프로그램 {
//		대기명단 프로그램
//		[메뉴]	
//			1.명단 추가 (인원수를 입력받아 대기번호 반환)
//			2.명단 취소 (대기번호를 입력받아 명단 취소)
//			관리자 3.명단 입장(대기 1번부터 입장 없으면 없음출력)
		
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 0. 리스트 객체에 Integer 객체들을 저장
		ArrayList<Integer> list = new ArrayList<>();

		
		while(true) {
			
			System.out.println("---------대기현황--------");
			for(int i = 0 ; i<list.size() ; i++) {
				System.out.println("대기번호 : "+(i+1)+"번 "+" 인원 :"+list.get(i)+"명");
			}
			
			
			System.out.println("1.명단추가 2.명단취소 3.[관리자]명단입장");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("인원수 : ");
				int count = scanner.nextInt();
				
				// 1. 리스트에 객체 저장
				list.add(count);
				System.out.println("고객님의 대기번호 : " + list.size());
			}
			else if(ch==2) {
				System.out.println("취소할 대기 번호 : " );
				int num = scanner.nextInt();
				list.remove(num-1); // -1하는 이유 [ 대기번호는 1부터 // 인덱스는 0번부터 부여 ]
				System.out.println("취소되었습니다");
			}
			else if(ch==3) {
				if(list.isEmpty() ) {
				System.out.println(" 대기중인 고객이 없습니다.");
				}else {
					System.out.println("대기번호 1번 입장");
					list.remove(0);
				}
			}
		} // while end
	} // main end
}	// class end
