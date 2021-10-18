package Day13;

public class Movie extends Thread{

	static boolean stop = true;
	public static void moviestop(boolean sw2) { stop = sw2;
		if(stop) {System.out.println("---영화시작");}
		else {System.out.println("---영화종료");}
	
	}
		
	
	@Override
	public void run() {
		while(stop) {
			System.out.println("영화실행중");
			try {Thread.sleep(1000);}
			catch(Exception e) {}
	
		}
	}
}
