package Day08;

public class Day08_1 {
		// ���� Ŭ���� => main �޼ҵ� [ ������ ]
	
		// ��� : 
			// 1. extends : �����ϴ� [ ���赵 ���� ]
				// public class �ڽ�Ŭ������ extends �θ�Ŭ������ { }
				// ���� �Ұ� 1����
			// 2. super : �θ�Ŭ������ ��� ����
				// 1. super() : �θ�Ŭ������ ������ ȣ��
				// 2. super.�ʵ��/�޼ҵ�� : �θ�Ŭ������ �ʵ�, �޼ҵ� ȣ��
	
			// 3. @Override : �θ�Ŭ������ �޼ҵ� ������
			
			// 4.final
				// final class CellPhone : �θ�Ŭ������ ��� �Ұ�
				// final void powerOn()	: �������̵� �Ұ�
	
	
	
	
	
	public static void main(String[] args) {
		
		// ����Ŭ���� �̿� ��ü ����
		DmbCellPhone dmbCellPhone = new DmbCellPhone("�ڹ���", "����", 10);
		System.out.println("�� : " + dmbCellPhone.model);	// �θ� �ʵ� ���� //private ������ �ƴҰ�� ��� ���� ����
		System.out.println("���� : " + dmbCellPhone.color); 	// �θ� �ʵ� ����
		
		System.out.println("ä�� : " + dmbCellPhone.channel); // ���� �ʵ�

		// �θ� �޼ҵ�
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("��������");
		dmbCellPhone.receiveVoice("�ȳ��ϼ���! ���� ȫ�浿�Դϴ� ");
		dmbCellPhone.sendVoice("��~ �� �ݰ����ϴ�");
		dmbCellPhone.hangup();
		
		// ���� �޼ҵ�
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		
		
	}
}
