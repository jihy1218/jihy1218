package ����;


public class Child extends Super {
	// 1. �ʵ�
		static String s_id;
		static String s_pw;
		static String s_birth;
		static String s_phone;
		static String s_name;
		
		
		// 2. ������
		public  Child(String s_id, String s_pw, String s_birth, String s_phone, String s_name) {
			this.s_id = s_id;
			this.s_pw = s_pw;
			this.s_birth = s_birth;
			this.s_phone = s_phone;
			this.s_name = s_name;	
		}
		public Child() { // ���� ������
			
		}
		
		// 3. �޼ҵ�
		public boolean signup() {
			System.out.println("========ȸ������ ������=========");
			System.out.print(" ����Ͻ� �й��� �Է����ּ��� : "); 		String s_id = Action.scanner.next();
			System.out.print(" ����Ͻ� ��й�ȣ ��й�ȣ : ");			String s_pw = Action.scanner.next();
			System.out.print(" �л� ������ ��������� �Է����ּ��� : ");	String s_birth = Action.scanner.next();
			System.out.print(" �л� ������ ����ó�� �Է����ּ��� : ");	String s_phone = Action.scanner.next(); 
			System.out.print(" �л� ������ �̸��� �Է����ּ��� : ");		String s_name = Action.scanner.next();
			
			// �ӽð�ü
			Child childs = new Child(s_id, s_pw, s_birth, s_phone, s_name);
			
			// �迭 ����
			for (int i = 0; i < 4; i++) {
				if(Action.childs[i] == null) {
					Action.childs[i] = childs;
					System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
					return true;
				}
			}
			return false;
		}
		
		public boolean login() {
			System.out.println("--------------�α���---------------");
			System.out.print("���̵��� �Է��� �ּ��� : "); String s_id = Action.scanner.next();
			System.out.print("��й�ȣ�� �Է��� �ּ��� : "); String s_pw = Action.scanner.next();
			
			for(int i = 0; i < 4; i++) {
				if (Action.childs[i] != null && 
						Action.childs[i].getS_id().equals(s_id) &&
						Action.childs[i].getS_pw().equals(s_pw)) {
						System.out.println("�α����� �Ϸ�Ǿ����ϴ�");
						return true;
				} 
			} return false;
		}

		public static String getS_id() {
			return s_id;
		}

		public static void setS_id(String s_id) {
			Child.s_id = s_id;
		}

		public static String getS_pw() {
			return s_pw;
		}

		public static void setS_pw(String s_pw) {
			Child.s_pw = s_pw;
		}

		public static String getS_birth() {
			return s_birth;
		}

		public static void setS_birth(String s_birth) {
			Child.s_birth = s_birth;
		}

		public static String getS_phone() {
			return s_phone;
		}

		public static void setS_phone(String s_phone) {
			Child.s_phone = s_phone;
		}

		public static String getS_name() {
			return s_name;
		}

		public static void setS_name(String s_name) {
			Child.s_name = s_name;
		}
		
		
		
		
}
