package Day09;

public class Menu implements Enrolment {
	// 1. �ʵ�
	String ���̵�;
	String ��й�ȣ;
	// 2. ������
	// 3. �޼ҵ�
	@Override
	public void �α���() {
		System.out.println("==�α����մϴ�==");
	}
	@Override
	public void ������û() {
		System.out.println("==������û�մϴ�==");
	}
	@Override
	public void ������û���() {
		System.out.println("==������û�����Ȯ���մϴ�==");
	}
	@Override
	public void ������û���() {
		System.out.println("==������û������մϴ�==");
	}
	@Override
	public void �������() {
		System.out.println("==������ ����մϴ�==");
	}
	@Override
	public void ������ϸ��() {
		System.out.println("==������ϸ����Ȯ���մϴ�==");
	}
	
}
