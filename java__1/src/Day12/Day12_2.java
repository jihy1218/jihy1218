package Day12;

import java.util.Random;

public class Day12_2 {

	
	public static void main(String[] args) {
	
		//p.527
			// Wrapper ���� Ŭ���� : �⺻�ڷ��� -> ��üȭ
		//p.531
		// ���ڿ� - > �⺻Ÿ��
			// 1.Integer.parseInt("���ڿ�");
			// 2.Double.parseDouble("���ڿ�");
			// 3.Boolean.parseBoolean("���ڿ�");
			// Byte.parseByte("���ڿ�");
			// Short.parseShort("���ڿ�");
			// Long.parseLong("���ڿ�");
			// Float.parseFloat("���ڿ�");
	
		// �⺻Ÿ�� -> ���ڿ�
			// 1. String.valueOf(�⺻�ڷ���); 
			// ����Ʈ -> ���ڿ�
			// 2. new ������(����Ʈ�迭)
		
		int value1 = Integer.parseInt("10"); 			//"10" -> 10
		double value2= Double.parseDouble("3.14"); 		// "3.14" -> 3.14
		boolean value3 = Boolean.parseBoolean("true");  // "true" -> true
		
		// p.534 : Math Ŭ����: ���а��� �޼ҵ� ����
			// 1. Math.abs()
		System.out.println(" ���밪 : " + Math.abs(-5)); 			// 5
		System.out.println(" ���밪 : " + Math.abs(-3.14)); 		// 3.14
		
			// 2. Math.ceil()
		System.out.println(" �ø��� : " + Math.ceil(5.3));		// 6.0
		System.out.println(" �ø��� : " + Math.ceil(-5.3));		// -5.0
		
			// 3. Math.floor()
		System.out.println(" ������ : " + Math.floor(5.3));		// 5.0
		System.out.println(" ������ : " + Math.floor(-5.3));		// -6.0	
		
			// 4. Math.max()
		System.out.println(" �ִ� : " + Math.max(5, 9)); 		// 9
		System.out.println(" �ִ� : " + Math.max(5.3, 2.5));	// 5.3
		
			// 5. Math.min()
		System.out.println(" �ּڰ� : " + Math.min(5, 9));		// 5
		System.out.println(" �ּڰ� : " + Math.min(5.3, 2.5)); 	// 2.5
		
			// 6. Math.random() : 0~1 ������ ���� ����
		System.out.println(" ���� : " + Math.random());
		
			// 7. Math.rint
		System.out.println(" ����� ������ �Ǽ��� : " + Math.rint(5.3)); // 5.0
		System.out.println(" ����� ������ �Ǽ��� : " + Math.rint(5.7)); // 6.0
		
			// 8. Math.round : �ݿø�
		System.out.println(" �ݿø� : " + Math.round(5.3));		// 5
		System.out.println(" �ݿø� : " + Math.round(5.7));		// 6
			// * �Ҽ��� ��°�ڸ� �ݿø� [ �ڸ��� �ø��� �ݿø� �ڸ��� ���� ]
		double value = 12.3456;
		double rvalue =Math.round(value * 100);	// 1234.56;
		// �̷��Ե� ���� double rvalue =(Math.round(value*100))/100.0;
			//	System.out.println(rvalue);
		System.out.println(rvalue/100);
		
		// p. 536 : �ֻ��� [ 1 ~ 6 ]
			//int num = Math.random();		// 0~1
			//int num = Math.random()*6;		// 0*6~1*6
			int num = (int)Math.random()*6 +1;	// 0*6+1~ 1*6+1 : 1 ~ 7
			System.out.println( num );
			
		// p.537 : Random Ŭ����
			Random random = new Random(); // Random Ŭ������ static �޼ҵ带 �������� ����
			int num1 = random.nextInt(6)+1; // int�� ǥ���Ҽ� �ִ� ������ŭ ����
			System.out.println(num1);
			
		
	}
	
}