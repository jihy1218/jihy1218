package Day13;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
	// 인터페이스 : 추상메소드가 존재
	
	@Override
	public void run() {		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	
		for( int i = 0 ; i<5 ; i++ ) { // 
			toolkit.beep(); // 비프음 소리 테스트
			
			// 무조건 예외처리
			try {Thread.sleep(1000);}  // 1초 일시정지 [ Thread.sleep(밀리초( 1/1000초)) ] 
			catch (Exception e) {} 
			
	}
	
		
	}
}
