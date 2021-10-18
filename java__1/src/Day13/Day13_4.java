package Day13;

public class Day13_4 {

	public static void main(String[] args) {
		
		// 비 제네릭 : 제네릭이 없을경우
			// 1. 타입 변환
		// 1.객체생성
		Box box = new  Box();
		// 2.객체 메소드 호출
		box.set("홍길동");						// 홍길동[String]		자동형변환
		String name = (String) box.get();		// object -> String 강제형변환
		
		box.set(new Apple());					// 자동형변환
		Apple apple = (Apple) box.get();		// object -> Apple 강제형변환
		
		// 제네릭 : 형변환이 많은 객체 클래스 사용시
		
		Box2<String> box2 = new Box2<>();
		// 출력
		box2.set("hello");
		String str = box2.get();
		
		Box2<Integer> box22 = new Box2<>();
		box22.set(6);
		int value = box22.get();
		
		// 멀티제네릭
		Product<TV, String> product = new Product<>();
		product.setKind(new TV());
		product.setModel("스마트TV");
		TV tv = product.getKind();
		String tvModel = product.getModel();
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("디젤");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
		
		
		
		
		
	}
}
