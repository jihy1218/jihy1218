package Day13;

public class Day13_4 {

	public static void main(String[] args) {
		
		// �� ���׸� : ���׸��� �������
			// 1. Ÿ�� ��ȯ
		// 1.��ü����
		Box box = new  Box();
		// 2.��ü �޼ҵ� ȣ��
		box.set("ȫ�浿");						// ȫ�浿[String]		�ڵ�����ȯ
		String name = (String) box.get();		// object -> String ��������ȯ
		
		box.set(new Apple());					// �ڵ�����ȯ
		Apple apple = (Apple) box.get();		// object -> Apple ��������ȯ
		
		// ���׸� : ����ȯ�� ���� ��ü Ŭ���� ����
		
		Box2<String> box2 = new Box2<>();
		// ���
		box2.set("hello");
		String str = box2.get();
		
		Box2<Integer> box22 = new Box2<>();
		box22.set(6);
		int value = box22.get();
		
		// ��Ƽ���׸�
		Product<TV, String> product = new Product<>();
		product.setKind(new TV());
		product.setModel("����ƮTV");
		TV tv = product.getKind();
		String tvModel = product.getModel();
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("����");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
		
		
		
		
		
	}
}
