package Day11;

public class NotExistIDException extends Exception{
	// ���� Ŭ���� ����� extends
	// 1.�ʵ�
	
	// 2.������
		// �� ������
	public NotExistIDException() {

	}
		// �μ��� �ִ� ������
	public NotExistIDException(String message) {
		super(message); // ����Ŭ�������� �޽��� ������
		//super() : �θ��� ������
		//super.�ʵ� // super.�޼ҵ�
	}
	// 3. �޼ҵ�
}
