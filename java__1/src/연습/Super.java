package 연습;

public class Super implements Inter {


	@Override
	public boolean signup() {
		System.out.println("*** 회원가입 되었습니다");
		return false;
	}
	
	@Override
	public boolean login() {
		System.out.println("*** 로그인 되었습니다");
		return false;
	}
}
