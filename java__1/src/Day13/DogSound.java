package Day13;

public class DogSound extends Thread {

	
	public DogSound() {
		super.setName("강아지소리");
	}
	@Override
	public void run() {
		for(int i = 0 ; i<5 ; i++) { 
			System.out.println("강아지소리");
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
	
	}
}
