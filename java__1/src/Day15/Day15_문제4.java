package Day15;

import java.util.Scanner;
import java.util.Stack;

public class Day15_문제4 {

	// 문제4 : 스택구조용 이용한 문자열 역순 출력
		// [조건1] 스택구조
		// [조건2] 입력받은 문자열을 순서대로 스택에 저장
			// Char // String
		// [조건3] 문자열 반대로 출력
		// 출력 예시
			// 입력 : ABC 
			// 출력 : CBA
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		
		// 1.입력받기
		System.out.println(" 문자열 : "); String 문자열 = scanner.next();
		
		// 2.문자열내 문자 하나씩
		for(int i = 0 ; i<문자열.length() ; i++) {
			stack.push(문자열.charAt(i));
				// 문자열.charAt(인덱스) : 문자열내 i번째 인덱스의 문자 추출
			// 스택명.push(문자) : 해당문자 저장
		}		
		// 꺼내기
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
		
			
	
	
	
}
