package �׽�Ʈ;

import java.util.Scanner;

public class BankApplication {
	
	// ���»��� �迭 �����
	static Account[] accountArray= new Account[100];
	static Scanner scanner = new Scanner(System.in);
	
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
			if(selectNo == 3) { }
			if(selectNo == 4) { }
			if(selectNo == 5) { run = false;}
		}
		System.out.println("���α׷� ����");
	}
	
	//���»��� createAccount
		// �Է¹ޱ�
	static void createAccount() {
		System.out.println("==============");
		System.out.println("====���»���====");
		System.out.println("==============");
		
		System.out.println(">> ���¹�ȣ "); String ano = scanner.next();
		System.out.println(">> ���� "); 	 String owner = scanner.next();
		System.out.println(">> �����Աݾ� "); int balance = scanner.nextInt(); // �����ϱ�
		
		//��ü ����
		Account account = new Account(ano, owner, balance);
		//�迭 ����
		for(int i = 0 ; i<accountArray.length; i++) {
			if( accountArray[i] == null ) { //[i] �� ���������
				accountArray[i] = account; 	//[i]�� account�� �־��
				System.out.println("���°� �����Ǿ����ϴ�");
				break;
			}
		}
	}
	//���¸��	accountList
	static void accountList() {
		System.out.println("==============");
		System.out.println("====���¸��====");
		System.out.println("==============");
		
		for( int i = 0 ; i<accountArray.length; i++) {
			if( accountArray[i] == null )	break;
			
			System.out.println(accountArray[i].getAno() + "\t" 
							+ accountArray[i].getOwner() + "\t"
							+ accountArray[i].getBalance() );
			
		}
	}
	static Account findAccount(String ano) {
			Account account = null;
			for(int i = 0 ; i<accountArray.length ; i++ ) {
				if(accountArray != null ) {
					if(accountArray[i].getAno().equals(ano)) {
						account = accountArray[i];
						break;
					}
				}
			} return account;
	}
	//���� deposit
	static void deposit() {
		System.out.println("=============");
		System.out.println("=====����=====");
		System.out.println("=============");
		
		//�Է¹ޱ� 
		System.out.println(">> ���¹�ȣ "); String ano = scanner.next();
		System.out.println(">> ���ݾ� "); int balance = scanner.nextInt();
		//��ü ����
		Account account = findAccount(ano);
		
		
	}
	//��� withdraw
}
