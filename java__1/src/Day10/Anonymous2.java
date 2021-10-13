package Day10;

public class Anonymous2 {
	
	// 필드 => 익명객체
	Vehicle field = new Vehicle() {
		
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");	
		}
	};
	
	// 지역변수로 메소드 안에서 익명 구현 객체
	void method1() {
		Vehicle localVar = new Vehicle() {
			
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		}; //  구현 끝
		localVar.run();
	}
	void method2(Vehicle vehicle) { vehicle.run(); }
	
	
	
}
