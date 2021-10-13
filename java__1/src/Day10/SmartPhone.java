package Day10;

public class SmartPhone  extends Phone {
	// 추상클래스 : 상속 extends
	// 1. 필드

	// 2. 생성자
	public SmartPhone(String owner) {
		super(owner);
		// super(); = 슈퍼클래스의 생성자 호출 
	}
	// 3. 메소드
	public void internetSearch() { 
		System.out.println("인터넷 검색을 합니다.");
	}

}
