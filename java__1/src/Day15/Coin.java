package Day15;

public class Coin {

	// �ʵ�
	private int value;
	// ������
	public Coin(int value) {
		this.value = value;
	}
	// �޼ҵ�
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.value+"";
	}
	
}
