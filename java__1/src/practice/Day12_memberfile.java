package practice;

public class Day12_memberfile {

	// ������ : �α���/ ȸ���������α׷� [����ó��]
		// [����] : ȸ�����Խ� ȸ������ ���Ͽ� ����
		// [ȸ��Ŭ����] : ���̵�, ��й�ȣ, ����, ����ó
		// [����] : �α��ν� ���ϳ� ȸ�������� �����ϸ� �α��μ���
		
		// ����ó�� Ŭ����
		// ȸ������ �迭
		public static void main(String[] args) throws Exception {
			
			
			while(true) {
				System.out.println("===�α���/ȸ���������α׷�===");
				System.out.println("1.�α���|2.ȸ������");
				System.out.println(">>���� : "); 
				// ����Ʈ �迭����
				byte[] b = new byte[1000]; 
				int count = System.in.read(b);
				String ch = new String(b, 0 , count-2);
				 
						
				if(ch.equals("1")) {
					
				}
				
				else if(ch.equals("2")) {
					System.out.println("====ȸ������������====");
					System.out.println("���̵� : "); int id = System.in.read(b);
					System.out.println("��й�ȣ : "); int pw = System.in.read(b);
					System.out.println("���� : "); int name = System.in.read(b);
					System.out.println("����ó : "); int phone = System.in.read(b);
					
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
