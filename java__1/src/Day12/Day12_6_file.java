package Day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Day12_6_file {

	// �޸�[�ֱ����ġ = RAM] : ����, �迭, ��ü ��� : ���α׷� ����� �� �ʱ�ȭ
		// �ֱ����ġ : ���� �������� ���α׷�[��ɾ�����] ���
			// ����X ����X => �ֹ߼� �޸�
		// ���������ġ : [ ���� , DB �� ]
			// ����X ����O => ���ֹ߼� �޸�
	
	// ���� <-------��Ʈ��(����: ����Ʈ)-------> JAVA���α׷�
	
	public static void main(String[] args) throws Exception {
		
		// ����ó�� Ŭ����
			// 1. FileOutputStream : ������� ��Ʈ�� [ �ش� ������ ������ ���� ���� ]
				// FileOutputStream ��ü�� = new FileOutputStream("���ϰ��");
					// 	/:�� ���
				// 1. write(����Ʈ��) : �ش� ���Ͽ� ����
				
//		FileOutputStream fileOutputStream = new FileOutputStream("C:/java/test.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("D:/JavaWeb/jihy1218/java__1/src/Day12/test.txt");
			// ����� ���õ� Ŭ���� => ����ó���߻� ���ɼ� ����
		String ���ڿ� = "��Ŭ�������� �ۼ��� �����Դϴ�."; // �ѱ� 14�� ����2�� .1�� 31����Ʈ 
		fileOutputStream.write(���ڿ�.getBytes());
			// 2. FileInputStream : �����Է� ��Ʈ��
				// FileInputStream ��ü�� = new FileInputStream("���ϰ��");
				// 1. read(����Ʈ�迭) : �ش� ������ ����Ʈ�迭�� ����
//		FileInputStream fileInputStream = new FileInputStream("C:/java/test.txt");
		FileInputStream fileInputStream = new FileInputStream("D:/JavaWeb/jihy1218/java__1/src/Day12/test.txt");
			// �о�� ����Ʈ�� ������ �迭
		byte[] ����Ʈ�迭 = new byte[1024]; // 1kb
		fileInputStream.read(����Ʈ�迭); // ���� �о����
			//System.in.read();	// Ű���� �о����
		String strread = new String(����Ʈ�迭);
		System.out.println("���� ������ ������ : " + strread);
		
	}
}
