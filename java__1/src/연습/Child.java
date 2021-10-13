package 연습;


public class Child extends Super {
	// 1. 필드
		static String s_id;
		static String s_pw;
		static String s_birth;
		static String s_phone;
		static String s_name;
		
		
		// 2. 생성자
		public  Child(String s_id, String s_pw, String s_birth, String s_phone, String s_name) {
			this.s_id = s_id;
			this.s_pw = s_pw;
			this.s_birth = s_birth;
			this.s_phone = s_phone;
			this.s_name = s_name;	
		}
		public Child() { // 깡통 생성자
			
		}
		
		// 3. 메소드
		public boolean signup() {
			System.out.println("========회원가입 페이지=========");
			System.out.print(" 사용하실 학번을 입력해주세요 : "); 		String s_id = Action.scanner.next();
			System.out.print(" 사용하실 비밀번호 비밀번호 : ");			String s_pw = Action.scanner.next();
			System.out.print(" 학생 본인의 생년월일을 입력해주세요 : ");	String s_birth = Action.scanner.next();
			System.out.print(" 학생 본인의 연락처를 입력해주세요 : ");	String s_phone = Action.scanner.next(); 
			System.out.print(" 학생 본인의 이름을 입력해주세요 : ");		String s_name = Action.scanner.next();
			
			// 임시객체
			Child childs = new Child(s_id, s_pw, s_birth, s_phone, s_name);
			
			// 배열 저장
			for (int i = 0; i < 4; i++) {
				if(Action.childs[i] == null) {
					Action.childs[i] = childs;
					System.out.println("회원가입이 완료되었습니다.");
					return true;
				}
			}
			return false;
		}
		
		public boolean login() {
			System.out.println("--------------로그인---------------");
			System.out.print("아이디을 입력해 주세요 : "); String s_id = Action.scanner.next();
			System.out.print("비밀번호를 입력해 주세요 : "); String s_pw = Action.scanner.next();
			
			for(int i = 0; i < 4; i++) {
				if (Action.childs[i] != null && 
						Action.childs[i].getS_id().equals(s_id) &&
						Action.childs[i].getS_pw().equals(s_pw)) {
						System.out.println("로그인이 완료되었습니다");
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
