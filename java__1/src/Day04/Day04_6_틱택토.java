package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_6_틱택토 {

	// 배열을 이용한 틱택토게임 프로그램
	 public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
		 
		
		// 1. 게임판 생성 [ 9칸생성 ] 
		// String 객체 9개를 저장하는 배열 선언
		 String[]게임판 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",};
		
		 String winner = " "; // 승리 알을 담을 변수
		int count = 0; // 현재 알수
		
		while(true) {
			
			// 2. 게임판 출력 [인덱스가 0번부터 시작하기 때문에 for 초기값을 0부터 시작]
			for( int i = 0 ; i<게임판.length ; i++) {
				// 3칸씩 출력후 줄바꿈 ??
				System.out.print( 게임판 [i] );
				// 3칸마다 줄바꿈
				if(i%3 == 2 ) System.out.println();
			}
			
				// 6. 승리자가 나왔을때 게임종료
				if( winner.equals("[O]") ) { 
					System.out.println(">>>>>> [[ 플레이어 승리 ]] ");
					break;
				}else if( winner.equals("[X]") ) {
					System.out.println(">>>>>> [[ 컴퓨터 승리 ]] ");
					break;
				
				}
				
			// 3. 플레이어 위치를 선택하여 알 두기
			while(true) {
				System.out.print(" >>>>>>[ 플레이어 순서 ] 위치 선택 : ");
				int index = scanner.nextInt();
				// 선택한 위치에 이미 알이 있을경우에 다시 입력받기 
				if( 게임판[index].equals("[ ]") ) {
					게임판[index] = "[O]" ; // 해당 위치 게임판 모양 변경
					count++; // 정상적으로 알을 두었을때 
					break; // 정상적인 알을 두었을때 반복문 종료
				}else {
					System.out.println(" >>> [ 이미 둔 자리 입니다 ] : 다시 선택");
				}
			}
			
				// 7 9칸 알이 모두 존재 했을때
				if( count == 9 ) {
					// 2. 게임판 출력 [인덱스가 0번부터 시작하기 때문에 for 초기값을 0부터 시작]
					for( int i = 0 ; i<게임판.length ; i++) {
						// 3칸씩 출력후 줄바꿈 ??
						System.out.print( 게임판[i] );
						// 3칸마다 줄바꿈
						if( i%3 == 2 ) System.out.println();
					}
					
					System.out.println(" >>>> [[ 무승부 ]] ");
					break;
					
				}
				
			// 4.  컴퓨터[ 0~8 사이 난수를 생성해서 알[X] 두기 ] 
			System.out.println(" >> [컴퓨터 순서] 위치 선택중");
			while(true) { 
				Random random = new Random();
				int index = random.nextInt(9); // 0~8 사이의 난수생성
				if( 게임판[index].equals("[ ]") ) {
					count++;
					게임판[index] = "[X]"; break;
				
				}
			}
			
			// 5. 승리자 판단
				// 1. 0 1 2  // 3 4 5 // 6 7 8  [가로로 이기는수] 모양이 같을경우 해당 모양 승리
				
			for( int i = 0 ; i<=6 ; i+=3 ) {
				if( 게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2]) ) {
					if( !게임판[i].equals("[ ]") ) { 
						// ! = 부정 [ true ==> false ] 
						winner = 게임판[i];
						
								
						
					}
				}
			}
				// 2. 0 3 6  // 1 4 7 // 2 5 8  [세로로 이기는수] 모양이 같을경우 해당 모양 승리
			for( int i = 0 ; i<=2 ; i++ ) {
				if( 게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6]) ) {
					if( 게임판[i].equals("[ ]") ) {
						// ! : 부정 [ true => false ]
						winner = 게임판[i];
						
					}
				}
			}
			
				// 3. 0 4 8  // 2 4 6			[대각선로 이기는수]모양이 같을경우 해당 모양 승리
			if( 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8] ) ) {
				if( !게임판[0].equals("[ ]" )) {
					winner = 게임판[0];
					
				}
			}
			
	
			if( 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
				if( !게임판[2].equals("[ ]" )) {
					winner = 게임판[2];
					
				}
			} 
			
			
			
		} 
		
		
	
	} // main end

}//class end