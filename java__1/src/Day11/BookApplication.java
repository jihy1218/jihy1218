package Day11;

import java.io.IOException;
public class BookApplication {


	public static void main(String[] args) throws IOException {
		String[] booklist = { "�ȴ�!���̹� ��α�&����Ʈ", "������ ��Ʈ ��õ Ȱ�� ������", "Tucker�� Go ��� ���α׷���", "ȥ�� �����ϴ� C ���"};
		
		while(true) {
			
		System.out.println("1.�˻�|2.����");
		System.out.print(">>�Է� : ");
			// ����Ʈ�迭 ���� [ Ű����κ��� �Է¹��� ����Ʈ�� ������ �迭 ]
		byte[] b = new byte[100]; // �˳��� 100����Ʈ [ �����̸� 100���� �ѱ��̸� 50���� ]
		// ����Ʈ --> ���ڿ� ��ȯ
		int count = System.in.read(b);
		String ch= new String(b, 0, count-2); // ����Ʈ => ���ڿ� -2 �ϴ����� [ \n , \r ]
		
		
		if(ch.equals("1")) {  	
			System.out.println("�˻�� �Է��ϼ��� >> : "); int count1 = System.in.read(b);
			
			String book= new String(b, 0, count1-2);
			for(int i = 0 ; i<booklist.length; i++) {
				// �������� ���Ե� �ܾ� ��ġ�������
				if(booklist[i].contains(book)) {
					System.out.println(booklist[i]);
				}
				if(booklist[i].indexOf(book) != -1) {
					System.out.println(booklist[i]);
				}
				
			}
		}
		
		else if(ch.equals("2")) {
			System.out.println("�˻������� �Է��ϼ��� >> : "); int book = System.in.read(b);
			String ch2= new String(b, 0, book-2);
			for(int i = 0 ; i<booklist.length; i++ ) {
				if(booklist[i].contains( ch2 )) {
					System.out.println(i+"��"+booklist[i]);
				}
			}
			System.out.println("������ ���� ��ȣ : ");
			int book1 = System.in.read(b);
			int ch3= Integer.parseInt(new String(b, 0, book1-2));
			
			System.out.println("������ ���� : ");
			book1 = System.in.read(b);
			String oldbook= new String(b, 0, book1-2);
			
			System.out.println("���ο� ���� : ");
			book1 = System.in.read(b);
			String newbook= new String(b, 0, book1-2);
			 
			//ġȯ
			
			booklist[ch3]=booklist[ch3].replace(oldbook, newbook); 
		}
		
		
		
		
		}
	
		
		}

	}


