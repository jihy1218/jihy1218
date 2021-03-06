package Day15;

import java.util.HashSet;
import java.util.Iterator;

public class Day15_2 {

	public static void main(String[] args) {
		
		// p. 737 : HashSet
		
		// 1. set 객체 생성 [ set 객체에 넣을 자료형을 제네릭에 넣기 ]
		HashSet<String> set = new HashSet<>();
		
		// 2. set에 객체 넣기 [ 중복 X , ]
		set.add("java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("java");		// 중복 발생 [ set는 자동적으로 중복 제거 ]
		set.add("iBATIS");
		
		// 3. set출력 [ 출력순서는 없음 ]
		System.out.println(set);
		System.out.println(set.size());
		
		// 4. Iterator 인터페이스를 이용한 set내 객체 호출 [ 인덱스가 존재하지 않기 
			// Iterator : (순서없는)set내 객체 하나씩 순회하는 반복자
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
				// .hasNext() : 다음객체가 존재하면 true 아니면 false
				String element = iterator.next();
				System.out.println("\t"+element);
		}
		
		//4
		for(String temp : set) {
			System.out.println("\t"+temp);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		System.out.println(set);
		set.clear();
		System.out.println(set);
		
		
		
	}
}
