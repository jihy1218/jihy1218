package Day10;

public class Anonymous {

	// 1 �ʵ�
	Person person = new Person(); // ��ü
	// �͸�ü : ��ȸ��
	Person field = new Person() {
		
		// �޼ҵ�
		void work() {
			System.out.println("��� �մϴ�.");
		}
		// �޼ҵ� : �������̵�
		@Override
		void wake() {
			System.out.println("6�ÿ� �Ͼ�ϴ�.");
			work();
		}
	};// �͸�ü ������
	// 2. ������
	
	// 3. �޼ҵ�
	void method1() {
		Person localVar = new Person() {
			void walk() {
				System.out.println("��å�� �մϴ�.");
			}
			
			@Override
			void wake() {
				System.out.println("7�ÿ� �Ͼ�ϴ�.");
				walk();
			}
		}; // �͸�ü ������
		
		localVar.wake();
	}
	void method2(Person person) {
		person.wake();
	}
	
	
	
	
}
