package Day09;

public class Car {

	// �ʵ� [ ���� , �迭 , ��ü �� ]
	Tire frontLeftTire = new Tire("�տ���", 6);
	Tire frontRightTire = new Tire("�տ�����", 2);
	Tire backLeftTire = new Tire("�ڿ���", 3);
	Tire backRightTire = new Tire("�ڿ�����", 4);
	
	// ������
	
	// �޼ҵ�
	int run() {
		// ���� ������ ������ => �⺻�� : default
		System.out.println("[�ڵ����� �޸��ϴ�.]");
		if(frontLeftTire.roll()==false) {stop(); return 1;}
		if(frontRightTire.roll()==false) {stop(); return 2;}
		if(backLeftTire.roll()==false) {stop(); return 3;}
		if(backRightTire.roll()==false) {stop(); return 4;}
		return 0;
	}
	
	void stop() {	// ��ũ������ ����
		System.out.println("[�ڵ����� ����ϴ�.]");
	}
	
	
	
}