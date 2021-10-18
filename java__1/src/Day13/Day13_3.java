package Day13;

public class Day13_3 {
	
	
	// 스레드 제어
		// 1. Thread.sleep(밀리초[1/1000초]) : 밀리초만큼 일시정지후 다시 실행
			// 예외처리 필수
		// 2. Thread.yield() : 다른 스레드에게 양보
		// 3. Thread.join() : 다른 스레드의 종료를 기다림
		// 4. Thread.stop() : 스레드 종료
	
	public static void main(String[] args) {
		
	/*
	  	// 1. 스레드 생성
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		// 2. 스레드 실행 [ run 메소드 실행 ]
		threadA.start();
		threadB.start();
			// 3초간 일시정지
		try {Thread.sleep(3000);} catch (Exception e) {}
		
		threadA.work = false; // 스레드A가 양보 [ 스레드A 실행x]
		
		try {Thread.sleep(3000);} catch(Exception e) {}
		
		threadA.work = true; // 스레스A가 출력
		
		try {Thread.sleep(3000);} catch(Exception e) {} 
		
		threadA.stop = true;	// 무한루프 종료
		threadB.stop = true;
	
	*/
		// p.607 
		
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		// join
		try {sumThread.join();} catch (Exception e) {
			
		}
		
		System.out.println("1~100 합 : " + sumThread.getSum());
		
		
		// p.613
	
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		
		try {Thread.sleep(1000);} catch (Exception e) {}
		
		//printThread.setStop(true); // while문 true
		//printThread.stop(); // 권장 하지않음
	
		printThread.interrupt(); // 예외를 발생시켜서 반복문 탈출
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
		
}
