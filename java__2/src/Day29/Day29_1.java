package Day29;

import java.net.InetAddress;

public class Day29_1 {
	
	// ��Ʈ��ũ : �δ��̻��� ��ǻ�͵��� �����ϰ� ����� �� �ִ� ��
		// ��Ÿ�: ���ڽ�ȣ�� ���� ����ϴ� ����Ⱑ ���� ����ϱ� ���� �ϳ��� ��
			// LAN , MAN , WAN �ٰŸ� �߰Ÿ� ��Ÿ� 
		// ���ͳ� : TCP/IP ��� ��� ���������� �̿��� ��ǻ�� ��Ʈ��ũ
			// �������� : �Ծ�, ��Ģ , ���
	// TCP/IP : ��Ʈ��ũ�� �����ϴ� �ڼ��� ��Ģ
		// TCP : Transmintion Cotroll Protocol : ��� ���� 
		// IP : Internet Protocol adress : ��� �ν� ��ȣ
			// ���ּ�[�� 1�� ->1�� �ּ� ] : ��ǻ���ּ�[��ǻ��1�� -> 1�� IP]
			// �ù�[�ı��� -> ��] : ���{pc�� -> �п�
			// ������ ���� [�п�IP -------> ���̹�]
				// ip : ���� 0~255 , 4�ڸ� , ����
					// ip�� ����� ����Ʈ���� �ܿ�� ���� ---> ���ڰ� ����
				// *ip---> ���� : �������ּ�[DNS]
		// server : ���� �ڷḦ �����ص� PC
			
	
	// ���� IP Ȯ�� ���
		// cmd -> config
		// �ڹ� -> InetAddress Ŭ���� ���
	public static void main(String[] args) {
		
		// 1. ���� pc�� ȣ��Ʈ ��������
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			System.out.println("���� pc�� ������ü : " + inetAddress);
			System.out.println("���� pc�� �̸� : " + inetAddress.getHostName());
			System.out.println("���� pc�� �ּ� : " + inetAddress.getHostAddress());
			
		// 2. ���̹� ȸ���� ȣ��Ʈ ��������
			InetAddress inetAddress2 = InetAddress.getByName("www.naver.com");
			System.out.println("���̹��� pc ������ü : " +inetAddress2 );
			System.out.println("���̹��� pc�̸� : "+inetAddress2.getHostName());
			System.out.println("���̹��� �ּ� : " + inetAddress2.getHostAddress());
		
		// 3. ���̹� ȸ���� �ټ� ip Ȯ��
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com");
			for(InetAddress address : inetAddresses) {
				System.out.println("���̹� �迭�� pc�� �̸� : " + address.getHostName());
				System.out.println("���̹� �迭�� �ּ� :" + address.getHostAddress());
			}
		// 4. ���̽���
		} catch (Exception e) {}
	}
	
		
	
	
}
