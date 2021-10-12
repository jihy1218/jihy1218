package Day09;

public class Tire {

	// 필드
	public int maxRotation;				// 최대 회전수(타이어 수명)
	public int accumlatedRotation; 		// 누적 회전수
	public String location;				// 타이어의 위치
	
	
	
	
	// 생성자 : 객체 초기값
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	// 메소드
	public boolean roll() { // 타이어 회전 메소드
		++accumlatedRotation; // 누적회전수 1증가
		if(accumlatedRotation < maxRotation ) {	// 최대회전수 더 크면
			System.out.println(location + "Tire 수명 : " 
					+ (maxRotation-accumlatedRotation) + "회"); // 남은 수명 출력
			return true;	// true 수명이 남음을 표시하는 반환
		}else {
			System.out.println("***" + location + " Tire 펑크 ***");
			return false;	// false 수명이 없음을 표시하는 반환
		}
		
	}
}
