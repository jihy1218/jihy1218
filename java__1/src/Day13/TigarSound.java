package Day13;

public class TigarSound extends Thread {

	
	public TigarSound() {
		super.setName("龋尔捞家府");
	}
	@Override
	public void run() {
		for(int i = 0 ; i<5 ; i++) { 
			System.out.println("龋尔捞家府");
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
	
	}
}
