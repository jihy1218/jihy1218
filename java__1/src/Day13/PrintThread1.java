package Day13;

public class PrintThread1 extends Thread {


	private boolean stop;
	public void setStop(boolean stop) {this.stop = stop;}
	
	@Override
	public void run() {
	
		try {
			while(!stop) { 
				System.out.println("���� ��");
			}
		}
		catch(Exception e) {
			
		}	
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
		
	
	
	}
}
