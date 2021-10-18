package Day13;

import java.util.Scanner;

public class Day13_문제2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean sw = true;
		boolean sw2 = true;
		while(true) {
			System.out.println("===========메뉴===========");
			System.out.println("1.음악재생 || 2 .영화재생");
			System.out.print(">> 선택 : "); int ch = scanner.nextInt();
			
			if(ch==1) {	
				Thread therad = new Music();
				
				if(sw) {
					Music.musicstop(sw);
					therad.start();	
					sw=false;
				}else {
					Music.musicstop(sw);
					sw =true;
				}
			}else if(ch==2) {	
				Thread thread = new Movie();
				
				if(sw2) {
					Movie.moviestop(sw2);
					thread.start();
					sw2=false;
				}else {
					Movie.moviestop(sw2);
					sw2=true;
				}
			}
		}
		
		// 확인문제 p.648
			// 1. 답 4
			// 2. : new MusicRunnable()
			//		extends Thread
			//		implements Runnable
			// 3. 답 4 [1이 가장 낮은 우선순위]
			// 4. 답 2 [wait 만 걸릴뿐 호출할순 있다]
			// 5. 답 4 [yield() 실행대기 호출 : 스레드 양보()]
			// 6. 답 4 [호출한 스레드가 일시정지]
			// 7. 답 2 [즉시 종료 X]
			// 8.
				// 
				// if(Thread.interrupted){break;}
				//
			// 10. main 스레드가 종료시 다른 스레드 종료 [ thread.setDaemon(true) ]
			// 11. 답 1 stop()는 최선의 방법이 아님
		
		
		
		
	}
}
