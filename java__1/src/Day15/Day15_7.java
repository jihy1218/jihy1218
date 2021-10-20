package Day15;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Day15_7 {

	// ����Ʈ�� : �ϳ��� ��� �������� ���� / ������ �ڽ� ��� ����
		// �θ� ��� �������� �������� ����
		// �θ� ��� �������� ū ���� ������
			// 1. Ʈ����.first() : ���� ���� ���
			// 2. Ʈ����.last() : ���� ������ ���
	
	public static void main(String[] args) {
		
		// 1. ��ü ����
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		// 2. ����Ʈ���� ��ü �ֱ�
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		// 3.
		System.out.println("���� ���� ���� : " + scores.first());
		System.out.println("���� ���� ���� : " + scores.last());
		System.out.println("95�� �Ʒ� ���� : " + scores.lower(95));
		System.out.println("95�� �� ���� : " + scores.higher(95));
		System.out.println("93�� �̰ų� �ٷξƷ� ���� : " + scores.floor(93) );
		System.out.println("85�� �̰ų� �ٷ� �� ���� : " + scores.ceiling(85));
		
		// 4.��������
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(int score : descendingSet) {
			System.out.print(score+" ");
		}
		
		System.out.println();
		// 5. �������� [ �������� 
		NavigableSet<Integer>  = descendingSet;
		
		
		
		
		
		while(!scores.isEmpty()) {
			scores.pollFirst(); // ���� ���� ���� ����
			System.out.println("���� ��ü�� : " + scores.size());
		}
			
	}
}
