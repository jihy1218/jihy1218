package Day13;

public class Calculator {
	// �ʵ�
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	// ������
	
	// �޼ҵ�
	
	public synchronized void setMemory(int memory) {
			// ����ȭ : �켱 �����尡 ���������� ���� ������ ��� [ ������� ]
		this.memory = memory;
		// 1. 2�ʰ� ������ �Ͻ�����
		try {Thread.sleep(2000);} catch(Exception e) {}
		System.out.println("������� : " + 
				Thread.currentThread().getName() + ": " + this.memory);
	}
}
