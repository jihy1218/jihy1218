package ����;

public interface Inter {

	// �߻� �޼ҵ�
		public boolean signup(); //ȸ������ �޼ҵ�.
		public boolean login(); // �α��� �޼�.

		// ����Ʈ �޼ҵ�
		default void ���� () { System.out.println("������û"); }

}
