package Day10;

public class Account {
	
	// 1.필드
	private long balance;
	
	// 2.생성자
	public Account() { }

	// 3. 메소드
	public long getBalance() {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	// 출금 [ 예외액보다 출금액이 더 크면 예외 만들기 ]
	public void withdraw(int money) throws 잔고부족 {
		if(balance < money) {
			
			throw new 잔고부족("잔고부족 : " + (money - balance) + " 모자람");
		}
		balance-=money;
	}

	
}
