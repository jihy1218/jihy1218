package Day15;

import java.util.Scanner;
import java.util.Stack;

public class Day15_����4 {

	// ����4 : ���ñ����� �̿��� ���ڿ� ���� ���
		// [����1] ���ñ���
		// [����2] �Է¹��� ���ڿ��� ������� ���ÿ� ����
			// Char // String
		// [����3] ���ڿ� �ݴ�� ���
		// ��� ����
			// �Է� : ABC 
			// ��� : CBA
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		
		// 1.�Է¹ޱ�
		System.out.println(" ���ڿ� : "); String ���ڿ� = scanner.next();
		
		// 2.���ڿ��� ���� �ϳ���
		for(int i = 0 ; i<���ڿ�.length() ; i++) {
			stack.push(���ڿ�.charAt(i));
				// ���ڿ�.charAt(�ε���) : ���ڿ��� i��° �ε����� ���� ����
			// ���ø�.push(����) : �ش繮�� ����
		}		
		// ������
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
		
			
	
	
	
}
