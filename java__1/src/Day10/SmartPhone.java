package Day10;

public class SmartPhone  extends Phone {
	// �߻�Ŭ���� : ��� extends
	// 1. �ʵ�

	// 2. ������
	public SmartPhone(String owner) {
		super(owner);
		// super(); = ����Ŭ������ ������ ȣ�� 
	}
	// 3. �޼ҵ�
	public void internetSearch() { 
		System.out.println("���ͳ� �˻��� �մϴ�.");
	}

}
