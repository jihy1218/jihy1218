package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_7_�ζ��Ǻ��� {

	 public static void main(String[] args) {
		
		//����1 1~45������ ���� 6�� �Է¹޾� �迭������
			// �� �ߺ��Ұ�// 1~45���̸� ����
		// ����2 ������ȣ�� �������� 1~45 ������ ���� 6�� �����Ͽ� �迭�� ����
		// ����3 �� �迭�� ������ ���ڰ� � �ִ��� üũ�Ͽ� ��� ���
		// ��� ��� �������� ����ϰ� ��� ���
				// 6�� ��� �����ϸ� 1�� // 5�� �����ϸ� 2�� // 4�� �����ϸ� 3�� // 3�� �����ϸ� 4�� // �׿� ��
		
		
		// 0. �Է°�ü
		 Scanner scanner = new Scanner(System.in);
	
		// 0. �迭 [ �迭���� : �ڷ���[] �迭�� = new �ڷ���[����] ]
		int [] number = new int[6]; // int�� 6�� ������ �����Ҽ��ִ� �迭
		int [] random = new int[6];
			
		   
		
		// 1. ����ڷκ��� 6�� ���� �Կ��޾� �迭�� ����
		for( int i = 0 ; i<6 ; i++ ) {
			System.out.println(i+"��° ��ȣ[1~45] ���� :  ");
			int num = scanner.nextInt(); 
			if( num <1 || num > 45 ) { // 0~45 ���̰� �ƴҰ��
				System.out.println(" [[ �˸� ]] : 0~45 ���̸� �Է°��� �մϴ� : �ٽ��Է� " );
				i--;
				continue;
			}		
			boolean check = true; // �ߺ��� ���� ���� true �ߺ��� �������� false
			// �ߺ�üũ : ���࿡ �Է��Ѱ��� �迭�� ������ ���� �����ϸ� �ٽ��Է�
			for( int j = 0 ; j<6 ; j++) {
				if( num == number[j] ) { // �ߺ�ã�� ����
					System.out.println(" [[ �˸� ]] : ������ ���� �̹� ���� �մϴ� : �ٽ� �Է� ");
					i--;
					check = false;
					break;
				}
			}
			
			// 1~45���� �� �̸鼭 �ߺ����� �ƴϸ� i��° �迭�� ����
			number[i] = num;
			
		}
		
		// 2. ���
		for( int i = 0 ; i<6 ; i++ ) {
			System.out.print(number[i] + " ");
		}
		System.out.println();
		
		// 3. 6���� ������ �����ؼ� �迭���� 
		for( int i = 0 ; i<6 ; i++ ) {
			Random random2 = new Random();
			int num = random2.nextInt(45)+1; // 1~45 ���� ����
			
			boolean check = true;	// �ߺ����� Ȯ�� üũ
			for( int j = 0 ; j<6 ; j++ ) {	// �ݺ��ϸ鼭 �迭�� �ߺ��� ã��
				if ( num == random[j] ) {	// ���࿡ ������ ���� �迭�� ���� �����ϸ� 
					i--;
					check = false;
					break;
				}
			}
			if( check ) random[i] = num;  // �ߺ����� ���� ��� i��°�� ���� �ֱ� 
		}
		
		// 4. ���
		System.out.print(" [[�̹��� ��÷ ��ȣ]] : ");
		for( int i = 0 ; i<6 ; i++ ) {
			System.out.print( random[i] + " ");
		}
		System.out.println();
		
		int count = 0; // ���� �� ����
		// 5. �� �迭�� ������ �� üũ 
		for( int i = 0 ; i<6 ; i++ ) { // i�� number �迭�� �ε���
			for( int j = 0 ; j<6 ; j++ ) { // j�� random �迭�� �ε��� => 36�� �� [ i 1���� j�� 6���� �� ]
				if( number[i] == random[j] ) { // ���࿡ �����ϸ� 
					count++; // ���� �� ������ 1����
				}
			}
		}
		
		System.out.println(" [[��÷ ���]] : " + count );
	}
	
	
}
