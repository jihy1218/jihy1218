package Day13;

public class TigarSound extends Thread {

	
	public TigarSound() {
		super.setName("ȣ���̼Ҹ�");
	}
	@Override
	public void run() {
		for(int i = 0 ; i<5 ; i++) { 
			System.out.println("ȣ���̼Ҹ�");
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
	
	}
}
