package Day09;

public class Menu implements Enrolment {
	// 1. 필드
	String 아이디;
	String 비밀번호;
	// 2. 생성자
	// 3. 메소드
	@Override
	public void 로그인() {
		System.out.println("==로그인합니다==");
	}
	@Override
	public void 수강신청() {
		System.out.println("==수강신청합니다==");
	}
	@Override
	public void 수강신청목록() {
		System.out.println("==수강신청목록을확인합니다==");
	}
	@Override
	public void 수강신청취소() {
		System.out.println("==수강신청을취소합니다==");
	}
	@Override
	public void 수업등록() {
		System.out.println("==수업을 등록합니다==");
	}
	@Override
	public void 수업등록목록() {
		System.out.println("==수업등록목록을확인합니다==");
	}
	
}
