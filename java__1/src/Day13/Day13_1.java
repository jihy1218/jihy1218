package Day13;

import java.awt.Toolkit; 	// Toolkit Ŭ���� �������� [ UI ���� �޼ҵ� ���� ] 

public class Day13_1 {

	// 1. CPU : �޸� ���� [ �������� : �ҷ��� ��ɾ� ��� ]
	// 2. �޸�[�ֱ����ġ] 
	
	public static void main(String[] args) {
		
		// 1. main : ���� ������ ����
			// 1. ù �ڵ���� ���������� ����
			// 2. return[��������] ������ ���� ����
		// 2. ��Ƽ������[ ���� ��� ]
			// *�ü���� �����忡�� �ڿ� �Ҵ�(�����ٸ�) => ���������� ó��
			// 1. ������ �������� �ϳ��� ���������� ���μ��� �����������
			// 2. ��Ƽ������ ���� ���
				// 1. Runnable : ������ �������̽�
					// implements Runnable
					// Runnable runnable = new ����Ŭ������();
					// Thread.start();
				// 2. Thread : ������ Ŭ����
					// ����Ŭ������ extends Thread
						// Thread thread = new ����Ŭ������();
						// Thread.start();
				// 3. �͸� ���� ��ü [ ��ȸ�� ]
				
		
		
			// * �������̽� : ��üx , �߻�޼ҵ忡���� ���� �ʼ� , ������ ����
		
		// p. 581
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for( int i = 0 ; i<5 ; i++ ) { // 
			toolkit.beep(); // ������ �Ҹ� �׽�Ʈ
			try {Thread.sleep(1000);}  // 1�� �Ͻ����� [ Thread.sleep(�и���( 1/1000��)) ] 
			catch (Exception e) {} 
				// ������ ����ó��
		}
		for( int i = 0 ; i<5 ; i++ ) { // 
			System.out.println("��");
			try {Thread.sleep(1000);}  // 1�� �Ͻ����� [ Thread.sleep(�и���( 1/1000��)) ] 
			catch (Exception e) {} 
		}
		
		System.out.println("-------------------------------");
		// p.583 : [ ��Ƽ������ ] : �Ҹ��� ���ڿ� ���ÿ� ���
		
		// 1. �������̽� ����
		Runnable runnable = new BeepTask();
		
		// 2. ������ Ŭ������ �������̽� ����
		Thread thread = new Thread(runnable);
		
		// 3. ������ ����
		thread.start();
		
		for( int i = 0 ; i<5 ; i++ ) { // 
			System.out.println("��");
			try {Thread.sleep(1000);}  // 1�� �Ͻ����� [ Thread.sleep(�и���( 1/1000��)) ] 
			catch (Exception e) {} 
		}
		
		
		// p.583 [��Ƽ������ : �Է°�ü runnable]
			// �͸� ��ü : �������̽��� ������ = new Ŭ������( new �������̽���() {����});
			// �͸� ��ü ��?  ��ȸ��
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for( int i = 0 ; i<5 ; i++ ) { // 
					toolkit.beep(); // ������ �Ҹ� �׽�Ʈ
					try {Thread.sleep(1000);}  // 1�� �Ͻ����� [ Thread.sleep(�и���( 1/1000��)) ] 
					catch (Exception e) {} 
						// ������ ����ó��
				}
				
				
				
			}
		});
		
		thread2.start();
		
		// ����
		for( int i = 0 ; i<5 ; i++ ) { // 
			System.out.println("��");
			// ������ ����ó��
			try {Thread.sleep(1000);}  // 1�� �Ͻ����� [ Thread.sleep(�и���( 1/1000��)) ] 
			catch (Exception e) {} 
		}
		
		System.out.println("-------------------------------");
		
		// p.584 [
		Thread thread3 = new BeepThread();
		thread3.start();
		
		// ������ �̸� Ȯ��
		System.out.println(" ������ �� : " + thread3.getName());
		
		//����
		for( int i = 0 ; i<5 ; i++ ) { // 
			System.out.println("��");
			try {Thread.sleep(1000);}  // 1�� �Ͻ����� [ Thread.sleep(�и���( 1/1000��)) ] 
			catch (Exception e) {} 
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
