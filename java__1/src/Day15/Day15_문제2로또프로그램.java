package Day15;

import java.util.HashSet;
import java.util.Scanner;

public class Day15_����2�ζ����α׷� {

//	���� 2 : set �÷���
//	�ζ� ���α׷�
//	1. 6���� �Է¹޾� set�÷��ǿ� �����Ͽ� ���
//	2. �ߺ��� ���x
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		
		while(true) {
			System.out.println("1~45 ���� ����(�ߺ��Ұ�) : ");
			int num = scanner.nextInt();
			
			if(num<1 || num > 45) {
				System.out.println("�����Ҽ����� ��ȣ�Դϴ�.");
			}else {
				//�ߺ�Ȯ��
				if(set.contains(num)) {
					System.out.println("�ߺ���ȣ�Դϴ�.");
				}
				set.add(num);
				System.out.println("Ȯ��"+set);
			}
			// ���ѷ��� ������ ���� : 6�� ��� �Է� �Ǿ�����
			if(set.size() == 6) break;
		}
		
		
	}
	
	
}
