package Day09;

public class HankookTire extends Tire {

	

	// �ʵ�
	
	// ������
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// �޼ҵ�
	@Override	// �������̵� : �޼ҵ� ������[�޼ҵ� ���빰 �ٲٱ�]
	public boolean roll() {
		++accumlatedRotation; // ����ȸ���� 1����
		if(accumlatedRotation < maxRotation ) {	// �ִ�ȸ���� �� ũ��
			System.out.println(location + "HankookTire ���� : " 
					+ (maxRotation-accumlatedRotation) + "ȸ"); // ���� ���� ���
			return true;	// true ������ ������ ǥ���ϴ� ��ȯ
		}else {
			System.out.println("***" + location + " HankookTire ��ũ ***");
			return false;	// false ������ ������ ǥ���ϴ� ��ȯ
		}
	}
	
	
}
