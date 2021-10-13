package 연습;

public interface Inter {

	// 추상 메소드
		public boolean signup(); //회원가입 메소드.
		public boolean login(); // 로그인 메소.

		// 디폴트 메소드
		default void 실행 () { System.out.println("수강신청"); }

}
