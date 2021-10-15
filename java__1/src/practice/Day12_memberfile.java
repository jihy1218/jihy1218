package practice;

public class Day12_memberfile {

	// 팀문제 : 로그인/ 회원가입프로그램 [파일처리]
		// [조건] : 회원가입시 회원정보 파일에 저장
		// [회원클래스] : 아이디, 비밀번호, 성명, 연락처
		// [조건] : 로그인시 파일내 회원정보가 존재하면 로그인성공
		
		// 파일처리 클래스
		// 회원저장 배열
		public static void main(String[] args) throws Exception {
			
			
			while(true) {
				System.out.println("===로그인/회원가입프로그램===");
				System.out.println("1.로그인|2.회원가입");
				System.out.println(">>선택 : "); 
				// 바이트 배열선언
				byte[] b = new byte[1000]; 
				int count = System.in.read(b);
				String ch = new String(b, 0 , count-2);
				 
						
				if(ch.equals("1")) {
					
				}
				
				else if(ch.equals("2")) {
					System.out.println("====회원가입페이지====");
					System.out.println("아이디 : "); int id = System.in.read(b);
					System.out.println("비밀번호 : "); int pw = System.in.read(b);
					System.out.println("성명 : "); int name = System.in.read(b);
					System.out.println("연락처 : "); int phone = System.in.read(b);
					
					String id1 = new String(b, 0 , id-2);
					String pw1 = new String(b, 0 , pw-2);
					String name1 = new String(b, 0, name-2);
					String phone1 = new String(b, 0, phone-2);
					
					String [] member = { id1 , pw1 , name1 , phone1 };
					System.out.println(member[0]);
					
				}
				
				
				
				
				
			}
		}
		
		
		
		
		
		
}
