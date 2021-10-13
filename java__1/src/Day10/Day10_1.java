package Day10;

public class Day10_1 {

	
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	private static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	public static void main(String[] args) {
		
		// p.386 확인문제
			// 1. 3 [ 인터페이스는 상수와 메소드만 가짐 ]
			// 2. 4 [ 구상객체는 인터페이스로 자동 변환 ]
			// 3.
		printSound(new Cat());
		printSound(new Dog());
			// 4.
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
			// 5. 익명 구현 객체
			// 인터페이스명 변수명 = new 인터페이스명(){ 구현 };
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("복사를 합니다");
			}
		}; 	// 구현끝
		
			// 인터페이스 실행
			action.work();
	}	
}
