package Day11;

import java.util.Scanner;

public class Day11_5_scanner {

	public static void main(String[] args) {
		
		// 0. �غ�
		String[] ������� = { "�ȴ�!���̹� ��α�&����Ʈ", "������ ��Ʈ ��õ Ȱ�� ������", "Tucker�� Go ��� ���α׷���", "ȥ�� �����ϴ� C ���"};
		Scanner scanner = new Scanner(System.in);
		
		// 1. �޴�
		while(true) {
			System.out.println("1.�˻� 2.����    ���� :  ");
			int ch = scanner.nextInt();
			
			if(ch==1) {System.out.println("====�˻�â====");}
			if(ch==2) {System.out.println("====����â====");}
			
		}
	}
}
