package Day13;

public class CatSound extends Thread {

	
	public CatSound() {
		super.setName("����̼Ҹ�");
	}
	@Override
	public void run() {
		for(int i = 0 ; i<5 ; i++) { 
			System.out.println("����̼Ҹ�");
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
	
	}
}
