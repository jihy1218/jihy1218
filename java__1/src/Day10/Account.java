package Day10;

public class Account {
	
	// 1.�ʵ�
	private long balance;
	
	// 2.������
	public Account() { }

	// 3. �޼ҵ�
	public long getBalance() {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	// ��� [ ���ܾ׺��� ��ݾ��� �� ũ�� ���� ����� ]
	public void withdraw(int money) throws �ܰ���� {
		if(balance < money) {
			
			throw new �ܰ����("�ܰ���� : " + (money - balance) + " ���ڶ�");
		}
		balance-=money;
	}

	
}
