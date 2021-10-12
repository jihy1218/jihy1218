package Day09;

public class Day09_2 {

	public static void main(String[] args) {
		Car car = new Car();
		
		// 자동차 5번 전진
		for(int i = 1; i<=5 ; i++ ) { 
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1 :
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽", 15);
				break;
			case 2 : 
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontRightTire = new KumhoTire("앞오른쪽", 13);
				break;
			case 3 :
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new HankookTire("뒤왼쪽", 14);
				break;
			case 4 :
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.backRightTire = new KumhoTire("뒤왼쪽", 17);
				break;
			}
			System.out.println("--------------------------");
		}
		
		// p.338
			// 5. 자식클래스에서 부모클래스의 생성자 호출 안했기 때문에
				// 만약에 부모클래스에 생성자가 없으면 컴파일 오류 발생하지 않음
			// 6. 
				
	}
}






