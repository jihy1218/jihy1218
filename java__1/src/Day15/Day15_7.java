package Day15;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Day15_7 {

	// 이진트리 : 하나의 노드 기준으로 왼쪽 / 오른쪽 자식 노드 가짐
		// 부모 노드 기준으로 낮은값은 왼쪽
		// 부모 노드 기준으로 큰 값은 오른쪽
			// 1. 트리명.first() : 가장 왼쪽 노드
			// 2. 트리명.last() : 가장 오른쪽 노드
	
	public static void main(String[] args) {
		
		// 1. 객체 선언
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		// 2. 이진트리에 객체 넣기
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		// 3.
		System.out.println("가장 낮은 정수 : " + scores.first());
		System.out.println("가장 높은 정수 : " + scores.last());
		System.out.println("95점 아래 정수 : " + scores.lower(95));
		System.out.println("95점 위 정수 : " + scores.higher(95));
		System.out.println("93점 이거나 바로아래 정수 : " + scores.floor(93) );
		System.out.println("85점 이거나 바로 위 정수 : " + scores.ceiling(85));
		
		// 4.내림차순
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(int score : descendingSet) {
			System.out.print(score+" ");
		}
		
		System.out.println();
		// 5. 오름차순 [ 내림차순 
		NavigableSet<Integer>  = descendingSet;
		
		
		
		
		
		while(!scores.isEmpty()) {
			scores.pollFirst(); // 가장 낮은 정수 삭제
			System.out.println("남은 객체수 : " + scores.size());
		}
			
	}
}
