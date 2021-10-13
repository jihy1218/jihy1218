package Day10;

public class Day10_6 {

	
	public static void main(String[] args) {
		
	// p.417 : 확인문제
		// 1. 답 4 [ 정적 멤버 클래스 내부에는 바깥 클래스의 정적 변수만 사용가능 ]
			// 정적 static [ static멤버끼리만 접근가능 ]
	
		// 2. 답 3 [ 로컬 클래스는 static 사용 불가-메소드 안에 있기 때문에 불가 ] 
			// 로컬클래스 : 메소드 안에서 설계된 클래스
			// 인스턴스 클래스 , 로컬 클래스는 바깥 클래스의 멤버 사용 가능 // static은 불가능
			 
		// 3. 답 3 [ 익명객 객체는 생성자를 선언할 수 없다. : 일회성 = 하나의 객체 생성하기 때문에 ] 
			// 익명객체 : 일회성
		
		// 4. 
			// static 있으면 정적 없으면 인스턴스	답
			// Tire : 인스턴스 클래스			Car.Tire tire = myCar.new Tire();
			// Engine : 정적 클래스				Car.Engine engine = new Car.Engine();
	
		// 5.
		Anonymous2 anonymous2 = new Anonymous2();
		anonymous2.field.run();
		anonymous2.method1();
		anonymous2.method2( new Vehicle() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
				
			}
		} // 구현끝
	); // 메소드 호출	
		
		// 6. 중첩클래스 안에서 사용되는 
	}
}
