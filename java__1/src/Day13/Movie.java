package Day13;

public class Movie extends Thread{

	static boolean stop = true;
	public static void moviestop(boolean sw2) { stop = sw2;
		if(stop) {System.out.println("---��ȭ����");}
		else {System.out.println("---��ȭ����");}
	
	}
		
	
	@Override
	public void run() {
		while(stop) {
			System.out.println("��ȭ������");
			try {Thread.sleep(1000);}
			catch(Exception e) {}
	
		}
	}
}
