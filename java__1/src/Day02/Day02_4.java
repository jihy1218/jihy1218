package Day02;

import java.util.Scanner;

public class Day02_4 {

	
	public static void main(String[] args) {
		
		// 문제 1 
		
		// 1. 입력객체 선언 = Scanner 클래스를 이용한 객체 선언
		Scanner 입력객체 = new Scanner(System.in);
		
		/*
		// 2. 입력객체에 저장된 값을 변수로 옮기기
		System.out.println(" 기본급 : "); int 기본급 = 입력객체.nextInt();
		System.out.println(" 수당 : "); int 수당 = 입력객체.nextInt();
		// 3. 계산
			// 100% = 1  	10%=0.1 	1% = 0.01
		double 세금 = (기본급*0.1); // int*double
		System.out.println("실수령액 : " + (기본급+수당-세금) );
		
		// 문제 2
		
		// 1. 지폐 입력받기
		System.out.println(" 금액 : "); int 금액 = 입력객체.nextInt();
			// 1. 십만원 권
			System.out.println(" 십만원 : " + (금액/100000)+"장");
				//금액 -= 금액 - (금액/100000)*100000; 십만원단위제거
				금액 -= (금액/100000)*100000;	
			// 2. 만원 권
			System.out.println(" 만원 : " + (금액/10000) + "장");
				금액 -= (금액/10000)*10000;
			// 3. 천원 권
			System.out.println(" 천원 : " + (금액/1000) + "장");
				금액 -= (금액/1000)*1000;
			// 4. 백원
			System.out.println(" 백원 : " + (금액/100) + "개");
				금액 -= (금액/100)*100;
				
		
		// 문제 3
		
		System.out.println("문제3의 정수 입력 : "); int 문제3 = 입력객체.nextInt();
		// 배수찾기
			// 값 % 수 == 0 나머지가 0이면 값은 그 수의 배수
		
		System.out.println(" 7의 배수인지 : " + ( 문제3%7 == 0) ); 
		
		//문제 4
		System.out.println("문제4의 정수 입력 : "); int 문제4 = 입력객체.nextInt();
		// 홀수 찾기
			// 값 * 2 == 1  나누기 2 를 했을때 나머지가 0이면 짝수 1이면 홀수
		System.out.println("홀수 인지 : " + (문제4%2 == 1) );
		
		//문제 5 
			System.out.println(" 문제5 정수 입력 : "); int 문제5 = 입력객체.nextInt();
			System.out.println("7의 배수 이면서 짝수 인지 : " + ( 문제5%7==0 && 문제5%2==0) );
		
		// 문제 6
			System.out.println(" 문제6 정수1 입력 : "); int 문제6_1 = 입력객체.nextInt();
			System.out.println(" 문제6 정수2 입력 : "); int 문제6_2 = 입력객체.nextInt();
			System.out.println(" 정수1 > 정수2 크다 : " + (문제6_1 > 문제6_2) );
			
		// 문제7 
			System.out.println(" 문제7 반지름 입력 : "); double 반지름= 입력객체.nextDouble();
			System.out.println(" 원 넓이는 : " + (반지름*반지름*3.14) );

			
		// 문제 8
			System.out.println(" 문제8 실수1 입력 : "); double 문제8_1= 입력객체.nextDouble();
			System.out.println(" 문제8 실수2 입력 : "); double 문제8_2= 입력객체.nextDouble();
			double 비율 = (문제8_1/문제8_2)*100;
			System.out.println(" 실수1의 실수2의 백분율 : " + 비율 +"%");
			// 소수점 단위를 형식 변경
			System.out.printf(" 실수1의 실수2의 백분율 : %.2f%%", 비율 );
							// 형식문자 : %f [ 실수 ]
							// %.숫자f [ 숫자 : 소수점 자리수 ]
							// %.2f [ 소수점 2자리수 ]
			
				
		// 문제 9
			System.out.println(" 문제9 윗변 입력 : "); double 문제9_1 = 입력객체.nextDouble();
			System.out.println(" 문제9 밑변 입력 : "); double 문제9_2 = 입력객체.nextDouble();
			System.out.println(" 문제9 높이 입력 : "); double 문제9_3 = 입력객체.nextDouble();
			System.out.println(" 사다리꼴 계산식 : %.3f\n" + (문제9_1*문제9_2)*문제9_3 /2 );
			
		// 문제 10 
			System.out.println(" 문제10 키 입력 : "); double 키 = 입력객체.nextDouble();
			System.out.println(" 표준체중 계산식 : " + (키-100) * 0.9 );
			
		// 문제 11 
			System.out.println(" 문제11 몸무게 입력 : "); double 몸무게 = 입력객체.nextDouble();
			System.out.printf(" BMI : %.1f\n" , ( 몸무게 / ( (키/100) * ( 키 / 100 ) ) ) );

		
		// 문제 12
			System.out.println(" 문제12 inch 입력 : "); double inch = 입력객체.nextDouble();
			System.out.println(" 입력한 inch 의 CM 변환 : " + inch * 2.54 );
		
		
		// 문제 13
			System.out.println(" 문제13 중간고사 입력 : "); double 중간고사 = 입력객체.nextDouble();
			System.out.println(" 문제13 기말고사 입력 : "); double 기말고사 = 입력객체.nextDouble();
			System.out.println(" 문제13 수행평가 입력 : "); double 수행평가 = 입력객체.nextDouble();
			중간고사 *= 0.3; 기말고사 *= 0.3; 수행평가 *=0.4;
			System.out.printf(" 반영비율별 점수 : %.2f \n" , (중간고사+기말고사+수행평가) );
			
		// 문제 14
			//int x = 10;
			//int y = x-- + 5 + --x;
			//prinf(" x의 값 : %d , y의 값 : %d 
				// 1. x-- +5 	=> 10+5
				// 2. x-- 		=> 10 -> 9
				// 3. --x 		=> 9 -> 8
				// 4. 15 + 8 	=> 23
			
		*/	
			
		// p.102 : 확인문제
			
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	
	
	


}
