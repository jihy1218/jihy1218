package Day13;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
	// �������̽� : �߻�޼ҵ尡 ����
	
	@Override
	public void run() {		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	
		for( int i = 0 ; i<5 ; i++ ) { // 
			toolkit.beep(); // ������ �Ҹ� �׽�Ʈ
			
			// ������ ����ó��
			try {Thread.sleep(1000);}  // 1�� �Ͻ����� [ Thread.sleep(�и���( 1/1000��)) ] 
			catch (Exception e) {} 
			
	}
	
		
	}
}
