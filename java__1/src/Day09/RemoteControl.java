package Day09;

public interface RemoteControl {
	// class : 클래스 선언시 사용되는 키워드
	// interface : 인터페이스 선언시 사용되는 키워드
	
	// 1. 상수 필드 : [ 반드시 초기값 존재 , 수정불가]
	public int MAX_VOLUME = 10; // 최대볼륨
	public int MIN_VOLUME = 0; 	// 최소볼륨
	// 2. 추상메소드 : [ 메소드 선언만 / 실행코드 정의X ] 중활호 없음
	public void turnOn(); 
	public void turnOff();
	public void setVolume(int volume);
	// 3. 디폴트메소드 : [ 메소드 선언과 실행코드 정의 o ]
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	// 4. 정적메소드 : [ 객체 선언없이 사용되는 메소드 ]
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
	
}
