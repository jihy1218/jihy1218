package Day13;

public class CalcThread extends Thread{
	public CalcThread(String name) {
		super.setName(name);
		// super.메소드() : 부모클래스내 메소드 접근
	}

	public void run() {
		for(int i = 0 ; i<200000000; i++) {}
							// 20억 바퀴
		System.out.println("반복문 종료 : " + getName());
	}
}
