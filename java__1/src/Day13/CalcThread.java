package Day13;

public class CalcThread extends Thread{
	public CalcThread(String name) {
		super.setName(name);
		// super.�޼ҵ�() : �θ�Ŭ������ �޼ҵ� ����
	}

	public void run() {
		for(int i = 0 ; i<200000000; i++) {}
							// 20�� ����
		System.out.println("�ݺ��� ���� : " + getName());
	}
}
