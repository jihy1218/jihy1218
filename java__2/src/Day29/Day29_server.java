package Day29;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Day29_server {

	// ��ſ� ���� �����
		// 1. �������� �����[ ServerSocket Ŭ���� ]
			// ���� : pc���� ��� ������ [server������ ����Ͽ� client �� ���� ]
		// 2. �������� ���ε� �ϱ�
			// ������ ip �ּҿ� port ��ȣ ����
			// * port : ip�� 6���� ���� ������ ��ȣ [ip�� ���μ��� ���� ��ȣ]
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(); 	// 1. �������� �����
			serverSocket.bind(new InetSocketAddress("127.168.102.50" , 5000)); // 2. ���� ���Ͽ� ip, port ����
			while(true) {
				System.out.println("[[�������� ���� �����]]");
				Socket socket = serverSocket.accept(); // 3. .accept() : Ŭ���̾�Ʈ ��û�� ����
				// 4. ������ Ŭ���̾�Ʈ ���� Ȯ��
				InetSocketAddress socketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[[Ŭ���̾�Ʈ�� ����Ǿ����ϴ�. Ŭ���̾�Ʈ ���� : " + socketAddress.getHostName());
				
				// ������ �����ϱ� [ �ޱ� ] : ��Ʈ���� �̿��� �ܺ� ��Ʈ��ũ ���
				InputStream inputStream = socket.getInputStream(); // ���� �Է� ��Ʈ��
				byte[] bytes = new byte[1000];
				inputStream.read(bytes);
				System.out.println("Ŭ���̾�Ʈ�� �޼��� : " + new String(bytes)); // ����Ʈ�迭 --> ���ڿ��� ��ȯ
				
				// ������ �۽��ϱ� 
				OutputStream outputStream = socket.getOutputStream();
				Scanner scanner = new Scanner(System.in);
				String msg = scanner.next();
				
				outputStream.write(msg.getBytes());
			}
		}
		catch(Exception e) {
			
		}
	}
	
	
}
