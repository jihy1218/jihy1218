package Day13;

public class CatSound extends Thread {

	
	public CatSound() {
		super.setName("고양이소리");
	}
	@Override
	public void run() {
		for(int i = 0 ; i<5 ; i++) { 
			System.out.println("고양이소리");
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
	
	}
}
