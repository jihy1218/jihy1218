package ����;

public class Super implements Inter {


	@Override
	public boolean signup() {
		System.out.println("*** ȸ������ �Ǿ����ϴ�");
		return false;
	}
	
	@Override
	public boolean login() {
		System.out.println("*** �α��� �Ǿ����ϴ�");
		return false;
	}
}
