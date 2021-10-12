package Day09;

public class KumhoTire extends Tire{

	
	// 필드
	
	// 생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}

	// 메소드
	@Override
	public boolean roll() {
		++accumlatedRotation; // 누적회전수 1증가
		if(accumlatedRotation < maxRotation ) {	// 최대회전수 더 크면
			System.out.println(location + "KumhoTire 수명 : " 
					+ (maxRotation-accumlatedRotation) + "회"); // 남은 수명 출력
			return true;	// true 수명이 남음을 표시하는 반환
		}else {
			System.out.println("***" + location + " KumhoTire 펑크 ***");
			return false;	// false 수명이 없음을 표시하는 반환
		}
		
	}
	
	
}
