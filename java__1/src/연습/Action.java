package ����;

import java.util.Scanner;

public class Action {

	public static Child[] childs = new Child[3];
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Child child = new Child();
				
		while(true) {
			try {
			scanner = new Scanner(System.in);
			System.out.println("-----------���α׷�----------");
			System.out.println("1.�α���|2.ȸ������|");
			System.out.println("---------------------------");
			System.out.print("���� : "); int ch = scanner.nextInt();
			
			
			if(ch==1) {	child.login(); }
			if(ch==2) {	child.signup();	}
			
			}catch(Exception e) {
				System.out.println("���ܰ� �߻��߽��ϴ�. [ �����ڿ��� ���� ]");
				System.out.println("�������� : " + e);  
			} 
		} 
	}
}
