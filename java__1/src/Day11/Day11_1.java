package Day11;

public class Day11_1 {

	// p. 488 : 10�� ���� Ȯ�ι���
		// 1. �� 4
			// 1. ����� ���� Ȥ�� �������� �߸��� �ڵ��� ������ ���ܶ� �Ѵ�.
			// 2. ���࿹��[ ���� ���߿� ���ܹ߻� ] , �Ϲݿ���[ ���� ���� ���ܹ߻� ]
			// 3. try{} catch(����Ŭ���� ������){}
			// 4. �����ڰ� ����Ŭ������ ���� ����
		// 2. �� 3
			// 3. finally : ���� ���� ������� ����Ǵ� �� [ �׻� ���� ]
		// 3. �� 4
			// throws: ���� ������ => �޼ҵ� �ȿ��� �߻��� ���ܸ� �޼ҵ� ȣ��� ������ ����
			// Exception : ����Ŭ�����߿� ���� Ŭ���� 
			// throw : ����� ���� �߻�
		// 4. �� 2
			// 4. ���� ��Ȯ�� ����
		// 5. 
			// 3: catch( Exception e){} catch(ClassNotFoundException e){}
			// Exception : �����߿��� ����Ŭ���� �տ� ������� �ڿ��ִ� �ڽ�Ŭ������ �ǹ̾���
		// 6. 10 
			// 1.main �޼ҵ� ����
			// 2.03/ 04�� : �迭���� / ���� ����
			// 3. 05�� : for�� ����
				// i = 0�϶� 
					// Integer.parseInt(strArray[0]) => 10 => ���ܹ߻�x
			// 4. 12�� : finally 
					// ��� 10
				// i = 1�϶� 
					// Integer.parseInt(strArray[1]) => 2a => ���ܹ߻�o
			// 5. 10�� : ���� ���� ĳġ
					// ���ڷ� ��ȯ �� �� ����
			// 6. 12�� : finally
					// ��� 10 { value ������ }
				// i = 2�϶�
					// value = Integer.parseInt(strArray[2]) => �ε��� ���� => ���ܹ߻�o
			// 7. 08�� : �ε��� ���� ĳġ
					// �ε����� �ʰ�����
			// 8. 12�� : finally
					// ��� 10 { value ������ }
			// 9. �ε��� ����
		public static void main(String[] args) {
//			String[] strArray = { "10" , "2a" };
//			int value = 0;
//			for(int i = 0 ; i <= 2; i++) {
//				try {
//					value = Integer.parseInt(strArray[i]);
//				} catch(ArrayIndexOutOfBoundsException e) {
//					System.out.println("�ε����� �ʰ�����");
//				} catch(NumberFormatException e) {
//					System.out.println("���ڷ� ��ȯ�� �� ����");
//				} finally {
//					System.out.println(value);
//				}
//			}
			try {
				login("white", "12345");	
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				login("blue", "54321");	
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	 
		public static void login(String id, String password) throws NotExistIDException , WrongPasswordException {
			if(!id.equals("blue")) {
				throw new NotExistIDException("���̵� �������� �ʽ��ϴ�.");
			}
			if(!password.equals("12345")) {	
				throw new WrongPasswordException("��й�ȣ�� �ٸ��ϴ�.");
			}
		}
}
