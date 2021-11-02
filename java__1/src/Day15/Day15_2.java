package Day15;

import java.util.HashSet;
import java.util.Iterator;

public class Day15_2 {

	public static void main(String[] args) {
		
		// p. 737 : HashSet
		
		// 1. set ��ü ���� [ set ��ü�� ���� �ڷ����� ���׸��� �ֱ� ]
		HashSet<String> set = new HashSet<>();
		
		// 2. set�� ��ü �ֱ� [ �ߺ� X , ]
		set.add("java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("java");		// �ߺ� �߻� [ set�� �ڵ������� �ߺ� ���� ]
		set.add("iBATIS");
		
		// 3. set��� [ ��¼����� ���� ]
		System.out.println(set);
		System.out.println(set.size());
		
		// 4. Iterator �������̽��� �̿��� set�� ��ü ȣ�� [ �ε����� �������� �ʱ� 
			// Iterator : (��������)set�� ��ü �ϳ��� ��ȸ�ϴ� �ݺ���
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
				// .hasNext() : ������ü�� �����ϸ� true �ƴϸ� false
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