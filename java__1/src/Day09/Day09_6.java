package Day09;

public class Day09_6 {

	public static Menu[] menulist = new Menu[100];
	
	public static void main(String[] args) {
		// �������̽� ����
		Enrolment enrolment;
		// �������̽� Ŭ���� ����
		enrolment = new Student();
		// �������̽��κ��� Ŭ���� ����
		enrolment.�α���();
		enrolment.������û();
		enrolment.������û���();
		enrolment.������û���();
		// �������̽��� Ŭ���� ����
		enrolment = new Admin();
		enrolment.�α���();
		enrolment.�������();
		enrolment.������ϸ��();
		
		//����Ŭ������ �迭 ����
		Menu login1 = new Menu();
		menulist[0] = login1;
		
		Student login2 = new Student();
		menulist[1] = login2;
		
		Admin login3 = new Admin();
		menulist[2] = login3;
		
	}
}
