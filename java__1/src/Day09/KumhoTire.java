package Day09;

public class KumhoTire extends Tire{

	
	// �ʵ�
	
	// ������
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	// �޼ҵ�
	@Override
	public boolean roll() {
		++accumlatedRotation; // ����ȸ���� 1����
		if(accumlatedRotation < maxRotation ) {	// �ִ�ȸ���� �� ũ��
			System.out.println(location + "KumhoTire ���� : " 
					+ (maxRotation-accumlatedRotation) + "ȸ"); // ���� ���� ���
			return true;	// true ������ ������ ǥ���ϴ� ��ȯ
		}else {
			System.out.println("***" + location + " KumhoTire ��ũ ***");
			return false;	// false ������ ������ ǥ���ϴ� ��ȯ
		}
		
	}
	
	
}
