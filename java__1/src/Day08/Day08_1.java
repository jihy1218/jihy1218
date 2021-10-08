package Day08;

public class Day08_1 {
		// 실행 클래스 => main 메소드 [ 스레드 ]
	
		// 상속 : 
			// 1. extends : 연장하다 [ 설계도 연장 ]
				// public class 자식클래스명 extends 부모클래스명 { }
				// 다중 불가 1개만
			// 2. super : 부모클래스내 멤버 접근
				// 1. super() : 부모클래스내 생성자 호출
				// 2. super.필드명/메소드명 : 부모클래스내 필드, 메소드 호출
	
			// 3. @Override : 부모클래스내 메소드 재정의
			
			// 4.final
				// final class CellPhone : 부모클래스로 사용 불가
				// final void powerOn()	: 오버라이딩 불가
	
	
	
	
	
	public static void main(String[] args) {
		
		// 서브클래스 이용 객체 생성
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		System.out.println("모델 : " + dmbCellPhone.model);	// 부모 필드 접근 //private 변수가 아닐경우 멤버 접근 가능
		System.out.println("색상 : " + dmbCellPhone.color); 	// 부모 필드 접근
		
		System.out.println("채널 : " + dmbCellPhone.channel); // 본인 필드

		// 부모 메소드
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동입니다 ");
		dmbCellPhone.sendVoice("아~ 예 반갑습니다");
		dmbCellPhone.hangup();
		
		// 본인 메소드
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		
		
	}
}
