package Day14;

import java.util.ArrayList;

public class Day14_3 {

	public static void main(String[] args) {
		
		// �÷��� �����ӿ�ũ
			// �÷��� : ���� [ �ڷᱸ�� : �����͸� �����ϴ� ��� ]
			// �����ӿ�ũ : �̸� ������� ���̺귯���� ����� ����
		
		// 1.List : Arraylist, Vector , Linkedlist
		// 2.Set 
		// 3.Map
		
		// p.728
		// 1. Arraylist : �迭�� ����
			// 1. �������� [ �⺻10 ������ 10�� ������ ���� �뷮 �ڵ� �þ ]
			// 2. ��ü�� ���� [ ������ �ε����ڷ� ��ĭ�� ����� ]
				// ��) 3�� �ε��� ������ [ 4���ε��� -> 3�� // 5���ε��� -> 4�� ]
			// 3. �޼ҵ�
				// 1. ����Ʈ��.add(��ü��) : �ش� ��ü�� ����Ʈ�� ����
				// 2. ����Ʈ��.size() : �ش� ����Ʈ�� 
				// 3. ����Ʈ��.get(�ε���) :
				// 4. ����Ʈ��.remove(�ε���) : 
				// 5. ����Ʈ��.contains(��ü) : 
				// 6. ����Ʈ��.indexOf(��ü) :  �ش� ��ü�� ����Ʈ�� �ε���
				// 7. ����Ʈ��.clear() : ����Ʈ �ʱ�ȭ
				// 8. ����Ʈ��.isEmpty() : ����Ʈ�� ��� �ִ��� ���� Ȯ��
		
		// 1. ����Ʈ ����
		ArrayList<String> list = new ArrayList<>();
			// ����ƮŬ����<���׸�> �ƹ��ų� =  new ����ƮŬ����<>();
				// <���׸�> : ���׸��� ���� Ÿ������ ����Ʈ�� ��ü ���
		// 2. ����Ʈ�� ��ü �߰�
		list.add("java");
		list.add("jdbc");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBATIS");
		
		// 3. ����Ʈ ���
		System.out.println(list);
		System.out.println(" ����Ʈ�� ��ä�� :  "+list.size());
		
		// 4. ����Ʈ�� ��ü ���
		System.out.println("2�� �ε��� ȣ�� : " + list.get(2) );
		
		// 5. ����Ʈ�� ��ü ȣ�� [ i : �ݺ��� ��� ]
		for( int i = 0 ; i<list.size() ; i++ ) {
			System.out.println(list.get(i));
		}
		// 6 ����Ʈ�� ��� ��ü ȣ�� [ 2. �ݺ��� Ȱ�� ��� ]
		System.out.println("===����Ʈ�� ��� ��ü ȣ�� ==== ");
		for(String temp : list) {
			// for(�ӽð�ü : ����Ʈ)
			// 		����Ʈ�� ��� ��ü 
			System.out.println(temp);
		}
		
		// 7. ����Ʈ�� ��ü ����
		list.remove(2);  // Database ����
		System.out.println("���� Ȯ�� : "+ list );
		list.remove(2);  // Servlet/JSP  ����
		System.out.println("���� Ȯ�� : "+ list );
		 
		
		System.out.println(list.contains("java"));
		System.out.println(list.indexOf("java"));
		list.clear();
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
	}
}
