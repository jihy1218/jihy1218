package Day09;



public class Day09_4 {

	// �������̽� : ��ü�� ������� �����ϴ� Ÿ��	
		// ���� : Ŭ�������� �����ؾ� �ϴ� ������ �����ϴµ� ����ϴ� �߻��ڷ�
		// �߻�???
		// ��: ������
			// �������̽�[��ư] = �̵���ư , ���ݹ�ư , ����ư
			// Ŭ����[���ӵ�] = ������� , ��ɰ��� , RPG����
				// ������ �������� ���δٸ� Ŭ�������� ����
		// implements : �����ϴ�
			// �߻�޼ҵ� : ���� �ִ� �޼ҵ� => ����� Ŭ���������� ����
			// �߻�޼ҵ� ����
		// �������̽� ���
			// 1. �������̽� �������̽��� = new Ŭ����()
					// �������̽� = (Ŭ����)��ü
			// 2. �͸� ���� ��ü
				// �������̽� �������̽� �� = new �������̽���() { 
				//		�߻�޼ҵ� �������̵�
				//		};
			// extends : ����x [ ����� �ѹ��� ���� ]
			// implements : ����o [ ������ ������ ���� ]
		public static void main(String[] args) {
			
			// p.347 ~ 354
				// l. �������̽� ���� : RemoteControl 
				// 2. Ŭ���� ���� : Television implements RemoteControl
				// 3. Ŭ���� ���� : Audio implements RemoteControl
			
			
			
			// 1. ������ ���� [ �޸� �Ҵ� X ]
			RemoteControl rc;
			// 2. �������� �ڷ����� Ŭ���� ����
			rc = new Television(); // �ش� �������� �ڷ��������� ���
				// �ڷ����� ������ ���
				rc.turnOn();
				rc.turnOff();
				rc.setVolume(5);
			// 3. �ڷ����� �������� ����� ������ ����
			System.out.println("** �������� ����� �������� �����մϴ�!! ");
			rc = new Audio();
				// ����� ������ ���
				rc.turnOn();
				rc.turnOff();
				rc.setVolume(15); 
			// p.360
				rc.setMute(true); // ����Ʈ �޼ҵ�������
			// p.362
			RemoteControl.changeBattery();
			
			// p.355
			RemoteControl rc2 = new RemoteControl() {
				
				@Override
				public void turnOn() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void turnOff() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setVolume(int volume) {
					// TODO Auto-generated method stub
					
				}
			};
				
				
				
				
				
				
				
				
		}
	
}
