package Day14;

import java.util.ArrayList;

public class Day14_3 {

	public static void main(String[] args) {
		
		// 컬렉션 프레임워크
			// 컬렉션 : 수집 [ 자료구조 : 데이터를 저장하는 방법 ]
			// 프레임워크 : 미리 만들어진 라이브러리의 사용방법 정의
		
		// 1.List : Arraylist, Vector , Linkedlist
		// 2.Set 
		// 3.Map
		
		// p.728
		// 1. Arraylist : 배열과 유사
			// 1. 가변길이 [ 기본10 이지만 10이 넘으면 저장 용량 자동 늘어남 ]
			// 2. 객체가 삭제 [ 삭제된 인덱스뒤로 한칸씩 당겨짐 ]
				// 예) 3번 인덱스 삭제시 [ 4번인덱스 -> 3번 // 5번인덱스 -> 4번 ]
			// 3. 메소드
				// 1. 리스트명.add(객체명) : 해당 객체를 리스트에 저장
				// 2. 리스트명.size() : 해당 리스트내 
				// 3. 리스트명.get(인덱스) :
				// 4. 리스트명.remove(인덱스) : 
				// 5. 리스트명.contains(객체) : 
				// 6. 리스트명.indexOf(객체) :  해당 객체의 리스트내 인덱스
				// 7. 리스트명.clear() : 리스트 초기화
				// 8. 리스트명.isEmpty() : 리스트가 비어 있는지 여부 확인
		
		// 1. 리스트 선언
		ArrayList<String> list = new ArrayList<>();
			// 리스트클래스<제네릭> 아무거나 =  new 리스트클래스<>();
				// <제네릭> : 제네릭은 넣은 타입으로 리스트내 객체 사용
		// 2. 리스트에 객체 추가
		list.add("java");
		list.add("jdbc");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBATIS");
		
		// 3. 리스트 출력
		System.out.println(list);
		System.out.println(" 리스트내 객채수 :  "+list.size());
		
		// 4. 리스트내 객체 출력
		System.out.println("2번 인덱스 호출 : " + list.get(2) );
		
		// 5. 리스트내 객체 호출 [ i : 반복문 사용 ]
		for( int i = 0 ; i<list.size() ; i++ ) {
			System.out.println(list.get(i));
		}
		// 6 리스트내 모든 객체 호출 [ 2. 반복문 활용 사용 ]
		System.out.println("===리스트내 모든 객체 호출 ==== ");
		for(String temp : list) {
			// for(임시객체 : 리스트)
			// 		리스트내 모든 객체 
			System.out.println(temp);
		}
		
		// 7. 리스트내 객체 삭제
		list.remove(2);  // Database 삭제
		System.out.println("삭제 확인 : "+ list );
		list.remove(2);  // Servlet/JSP  삭제
		System.out.println("삭제 확인 : "+ list );
		 
		
		System.out.println(list.contains("java"));
		System.out.println(list.indexOf("java"));
		list.clear();
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
	}
}
