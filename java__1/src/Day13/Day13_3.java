package Day13;

public class Day13_3 {
	
	
	// ������ ����
		// 1. Thread.sleep(�и���[1/1000��]) : �и��ʸ�ŭ �Ͻ������� �ٽ� ����
			// ����ó�� �ʼ�
		// 2. Thread.yield() : �ٸ� �����忡�� �纸
		// 3. Thread.join() : �ٸ� �������� ���Ḧ ��ٸ�
		// 4. Thread.stop() : ������ ����
	
	public static void main(String[] args) {
		
	/*
	  	// 1. ������ ����
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		// 2. ������ ���� [ run �޼ҵ� ���� ]
		threadA.start();
		threadB.start();
			// 3�ʰ� �Ͻ�����
		try {Thread.sleep(3000);} catch (Exception e) {}
		
		threadA.work = false; // ������A�� �纸 [ ������A ����x]
		
		try {Thread.sleep(3000);} catch(Exception e) {}
		
		threadA.work = true; // ������A�� ���
		
		try {Thread.sleep(3000);} catch(Exception e) {} 
		
		threadA.stop = true;	// ���ѷ��� ����
		threadB.stop = true;
	
	*/
		// p.607 
		
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		// join
		try {sumThread.join();} catch (Exception e) {
			
		}
		
		System.out.println("1~100 �� : " + sumThread.getSum());
		
		
		// p.613
	
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		
		try {Thread.sleep(1000);} catch (Exception e) {}
		
		//printThread.setStop(true); // while�� true
		//printThread.stop(); // ���� ��������
	
		printThread.interrupt(); // ���ܸ� �߻����Ѽ� �ݺ��� Ż��
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
		
}
