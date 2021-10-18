package Day13;

import java.awt.Toolkit;

public class BeepThread extends Thread{
	
	
	
	public BeepThread() {
		setName("������A");
	}

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i<5 ; i++) {
			toolkit.beep();
			try {Thread.sleep(1000);} catch(Exception e) {}
		}
	}
}
