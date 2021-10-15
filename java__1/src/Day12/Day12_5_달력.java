package Day12;

import java.util.Calendar;
import java.util.Scanner;

public class Day12_5_달력 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("연도 : " ); int year = scanner.nextInt();
		System.out.println("월 : "); int month = scanner.nextInt();
		
		//메소드 호출
		달력보기(year, month);
	}
	// 메소드 선언 : 접근제한자 키워드 반환타입 메소드명( 인수1 , 인수2 ~~` ){}
	public static void 달력보기(int year , int month ) {
		
		// 1. 캘린더 객체 선언 => new[x], 클래스내 객체 호출
		Calendar calendar = Calendar.getInstance();
		// 2. 연도 , 월 , 일
	//	int year = calendar.get(Calendar.YEAR);
	//	int month = calendar.get(calendar.MONTH)+1; // 0: 1월 이라서 +1
	//	int day = calendar.get(calendar.DAY_OF_MONTH);
			// 사용자 정의 캘린더
			calendar.set(year, month-1 , 1);
			// 해당 월의 1일 요일 찾기
			int sweek = calendar.get(calendar.DAY_OF_WEEK);
			// 해당 월의 마지막 일 찾기
			int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		// 3. 달력 출력
		System.out.println("==================== "+year+"년"+month+"월=====================");
		System.out.println(" 일\t월\t화\t수\t목\t금\t토");
		
		// 4. 현재 월 1일의 위치 앞에 공백 채우기
		for(int i = 1 ; i<sweek ; i++) {
			System.out.print("  \t");
		}
		// 5. 1일 부터 마지막날까지 출력
		for(int i = 1 ; i<=eday ; i++) {
			System.out.print(i+"\t");
			// 요일이 토요일마다 줄바꿈 [ sweek가 7의 배수마다 ]
			if(sweek%7==0) System.out.println();
			sweek++;	// 요일증가
		}
	}
	// 과제 달력 범위 출력
	// 시작연도/ 월 입력받기
	// 끝 연도/ 월 입력받기
			// 시작 날짜부터 끝날짜까지의 모든 달력 출력
			// 예 2021.08 ~ 2022.10 모두 출력
}
