package Day09;

public class Tire {

	// �ʵ�
	public int maxRotation;				// �ִ� ȸ����(Ÿ�̾� ����)
	public int accumlatedRotation; 		// ���� ȸ����
	public String location;				// Ÿ�̾��� ��ġ
	
	
	
	
	// ������ : ��ü �ʱⰪ
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	// �޼ҵ�
	public boolean roll() { // Ÿ�̾� ȸ�� �޼ҵ�
		++accumlatedRotation; // ����ȸ���� 1����
		if(accumlatedRotation < maxRotation ) {	// �ִ�ȸ���� �� ũ��
			System.out.println(location + "Tire ���� : " 
					+ (maxRotation-accumlatedRotation) + "ȸ"); // ���� ���� ���
			return true;	// true ������ ������ ǥ���ϴ� ��ȯ
		}else {
			System.out.println("***" + location + " Tire ��ũ ***");
			return false;	// false ������ ������ ǥ���ϴ� ��ȯ
		}
		
	}
}
