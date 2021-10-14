package Day11;

public class NotExistIDException extends Exception{
	// 예외 클래스 만들기 extends
	// 1.필드
	
	// 2.생성자
		// 빈 생성자
	public NotExistIDException() {

	}
		// 인수가 있는 생성자
	public NotExistIDException(String message) {
		super(message); // 예외클래스에게 메시지 보내기
		//super() : 부모의 생성자
		//super.필드 // super.메소드
	}
	// 3. 메소드
}
