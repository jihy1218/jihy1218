package ����;

import java.util.Scanner;

public class BankApplication {

	
	// ���°�ü�� �����Ҽ��ִ� �迭 ����
	
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
		// private : ���� Ŭ���� �������� ȣ�Ⱑ��
			// static : ���α׷� ���ݿ� ���� ���� ����
	
	public static void main(String[] args) {
		
		boolean run = true;
		while(run) {
			System.out.println("=================================");
			System.out.println("1.���»���|2.���¸��|3.����|4.���|5.����");
			System.out.println("=================================");
			System.out.print("�����Ͻʽÿ� >>");
			int selectNo = scanner.nextInt();
			if(selectNo == 1) { createAccount();}
			if(selectNo == 2) { accountList();}
			if(selectNo == 3) {}
			if(selectNo == 4) { }
			if(selectNo == 5) { run = false;}
			
		}
		System.out.println("���α׷� ����");
	}
	
	// ���»��� [ �μ�x ��ȯx ]
	private static void createAccount() {
		System.out.println("================");
		System.out.println("=====���»���======");
		System.out.println("================");
		//�Է¹ޱ�
		System.out.println(">> ���¹�ȣ : " ); String ano = scanner.next();
		System.out.println(">> ���� : "); String owner = scanner.next();
		System.out.println(">> �����Աݾ� : "); int balance = scanner.nextInt();
		
		//��ü���� [�Է� ���� �������� ��ü �����ڿ� �־ ��ü �����]
		Account account = new Account(ano, owner, balance);
		//�迭���� [�迭�� �����[null]�� ã�Ƽ� ����� �ε����� ��ü ����]
		for( int i = 0 ; i<accountArray.length ; i++ ) {
			if( accountArray[i] == null ) { // i��° �ε����� ���������
				accountArray[i] = account;	// i��° �ε����� ��ü �ֱ�
				System.out.println("��� : ���°� �����Ǿ����ϴ�.");
				break; // �ݺ�������
			}
		}
	}
	// ���¸��
	private static void accountList() {
		System.out.println("===============");
		System.out.println("====���¸��======");
		System.out.println("===============");
		
		// �迭�� ��� �ε����� ȣ�� [ null ���� ]
		for(int i = 0 ; i<accountArray.length ; i++) {
			if(accountArray[i] == null) break;
			
			System.out.println( accountArray[i].getAno() + "\t" 
						+ accountArray[i].getOwner() + "\t"
						+ accountArray[i].getBalance() );
		}
	}
	// ����
	
	// ���
	

	
	
	
}
