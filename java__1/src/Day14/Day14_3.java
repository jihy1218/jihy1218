package Day14;

import java.util.ArrayList;

public class Day14_3 {

	public static void main(String[] args) {
		
		// �÷��� �����ӿ�ũ
			// �÷��� : ���� [ �ڷᱸ�� : �����͸� �����ϴ� ��� ]
			// �����ӿ�ũ : �̸� ������� ���̺귯���� ����� ����
		
		// 1.List : Arraylist, Vector , LinkedList
		// 2.Set 
		// 3.Map
		
		// p.728
		// 1. Arraylist : �迭�� ����
			// 1. �������� [ �⺻10 ������ 10�� ������ ���� �뷮 �ڵ� �þ ]
			// 2. ��ü�� ���� [ ������ �ε����ڷ� ��ĭ�� ����� ]
				// ��) 3�� �ε��� ������ [ 4���ε��� -> 3�� // 5���ε��� -> 4�� ]
			// 3. �޼ҵ�
				// 1. ����Ʈ��.add(��ü��) : �ش� ��ü�� ����Ʈ�� ����
					// * ����Ʈ��.add( �ε��� , ��ü�� ) : �ش� �ε��� �ڸ��� ��ü ����
				// 2. ����Ʈ��.size() : �ش� ����Ʈ�� ��ü ��
				// 3. ����Ʈ��.get(�ε���) : �ش� �ε����� ��ü ȣ��
				// 4. ����Ʈ��.remove(�ε���) : �ش� �ε��� ����
				// 5. ����Ʈ��.contains(��ü) : �ش� ��ü�� ����Ʈ�� ���� ���� Ȯ�� [ true, false ]
				// 6. ����Ʈ��.indexOf(��ü) :  �ش� ��ü�� ����Ʈ�� �ε��� ��ȣ
				// 7. ����Ʈ��.clear() : ����Ʈ �ʱ�ȭ
				// 8. ����Ʈ��.isEmpty() : ����Ʈ�� ��� �ִ��� ���� Ȯ�� [ true , false ]
		
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
		// 5_1 ����Ʈ�� ��� ��ü ȣ�� [ 2. �ݺ��� Ȱ�� ��� ]
		System.out.println("===����Ʈ�� ��� ��ü ȣ�� ==== ");
		for(String temp : list) {
			// for(�ӽð�ü : ����Ʈ)
			// 		����Ʈ�� ��� ��ü�� �ϳ��� �ӽ� ��ü�� ����
			System.out.println(temp);
		}
		
		// 6. ����Ʈ�� ��ü ����
		list.remove(2);  // Database ���� => ������ => Servles/JSP ��ü�� 2�� �ε���
		System.out.println("���� Ȯ�� : "+ list );
		list.remove(2);  // Servlet/JSP  ����
		System.out.println("���� Ȯ�� : "+ list );
		 
		// 7. �˻�
		System.out.println(list.contains("java"));
		System.out.println(list.indexOf("java"));
		
		// 8.����Ʈ �ʱ�ȭ
		list.clear();
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
	}
}
