package Day11;

public class Day11_3 {
		public static void main(String[] args) {
			
			// System 클래스 [ 모든 멤버가 static 이기때문에 객체 불필요 ] 
				// 1. exit : 프로그램 종료
			
			System.setSecurityManager(new SecurityManager() {
				@Override
				public void checkExit(int status) {
					if(status !=5 ) {
						throw new SecurityException();
							// i가 0일때 status = 0 true => 예외발생o
							// i가 1일때 status = 1 true => 예외발생o
							// i가 2일때 status = 2 true => 예외발생o
							// i가 3일때 status = 3 true => 예외발생o
							// i가 4일때 status = 4 true => 예외발생o
							// i가 5일때 status = 5 false=> 예외발생x
					}
				}
			}); // 익명구현객체 일회성
			
			for(int i = 0 ; i<10 ; i++) { // i는 0부터 9까지 1씩 증가
				System.out.println(i); // 출력
				try {
					System.exit(i);		// i를 exit()에 넣기 
				}catch (Exception e) {}
			}
			
				// 2. current
			// 1.시작 시간
			long time1 = System.nanoTime();
			int sum = 0 ;
			for(int i = 1 ; i<=10000000 ; i++) {
				sum += i;
			}
			
			// 2.끝나는 시간
			long time2 = System.nanoTime();
			
			
			System.out.println("1~10000000까지의 합 : " + sum );
			System.out.println("걸린시간 : " + (time2 - time1 ) + " 나노초 ");
			System.out.println(System.nanoTime());
			
				// 3. 시스템 정보읽기 [ System.getProperty 
			System.out.println("pc os : " + System.getProperty("os.name"));
			System.out.println("pc 사용자이름 : " + System.getProperty("user.name"));
			System.out.println("pc 사용자 폴더 위치 : " + System.getProperty("java.home"));
			
			
			
			
			
			
			
			
			
		}
	}

