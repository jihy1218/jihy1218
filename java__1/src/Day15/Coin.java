package Day15;

public class Coin {

	// 필드
	private int value;
	// 생성자
	public Coin(int value) {
		this.value = value;
	}
	// 메소드
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.value+"";
	}
	
}
