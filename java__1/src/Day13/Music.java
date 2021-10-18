package Day13;

public class Music extends Thread {

	static boolean stop = true;
	
	public static void musicstop(boolean sw) { stop = sw;
		if(stop) {System.out.println("---¿Ωæ«Ω√¿€");}
		else{System.out.println("---¿Ωæ«¡æ∑·");}
	
	
	}
	
	@Override
	public void run() {
	

		while(stop) {
			System.out.println("¿Ωæ«Ω««‡¡ﬂ");
			try {Thread.sleep(1000);}
			catch(Exception e) {}
		}
	
	
	
	
	
	}
	
}
