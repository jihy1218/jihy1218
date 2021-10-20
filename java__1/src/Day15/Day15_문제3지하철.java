package Day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day15_����3����ö {

//	����3 : ����ö ����[Queue]
//			����1.��(������ -> ��꿪 -> ���￪ -> ���ο� -> ������)
//			����2. ��ö 3�� ��ü [ �������� 3�� ��ö ��� ]
//			����3. ��� ��ȣ�� �޾Ƽ� �ش翪���� ����ؼ� ���������� ����
//			����4. ���� �ҿ�ð� 2��

//			��߽�ȣ �޴�
//			1. ���� 2. ��� 3. ���� 4. ����
//			[����] 1�����ý� ���������� ���� ���� ��ö�� ���������� �̵�
//			[����] ���� �ش翪�� ��ö�� ������ ���� ���
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		// Queue �������̽�
		Queue<String> ������ = new LinkedList<String>();
		Queue<String> ��꿪 = new LinkedList<String>();
		Queue<String> ���￪ = new LinkedList<String>();
		Queue<String> ���ο� = new LinkedList<String>();
		
		������.offer("1����ö");
		������.offer("2����ö");
		������.offer("3����ö");
		
		while(true) {
			System.out.println(������);
			System.out.println(��꿪);
			System.out.println(���￪);
			System.out.println(���ο�);
			System.out.println("1.������|2.��꿪|3.���￪|4.���ο�");	
			int ch = scanner.nextInt();
			if(ch==1) {
				if(!������.isEmpty()) {
					Thread.sleep(2000);
					System.out.println("��� : " + ������.peek());
					��꿪.offer(������.poll());
				}
			}
			if(ch==2) {
				if(!��꿪.isEmpty()) {
					Thread.sleep(2000);
					System.out.println("��� : " + ��꿪.peek());
					���￪.offer(��꿪.poll());
				}
				
			}
			if(ch==3) {
				if(!���￪.isEmpty()) {
					Thread.sleep(2000);
					System.out.println("��� : " + ���￪.peek());
					���ο�.offer(���￪.poll());
				}
			
			}
			if(ch==4) {
				if(!���ο�.isEmpty()) {
					Thread.sleep(2000);
					System.out.println("��� : " + ���ο�.peek());
					������.offer(���ο�.poll());
				}
			}
		}
	}
}
