package application;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	// 1. ����
	Socket socket;	// Ŭ���̾�Ʈ ����
	
	// 2. ������
	public Client(Socket socket) {
		this.socket = socket; // �ܺηκ��� ���� ������ ���μ���
		receive();				// ���Ӱ� ���ÿ� �ޱ� ����
	}
	// 3. ������ �޽��� �޴� �޼ҵ�
	public void receive() {
		// ��Ƽ������
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) { // ���ѷ���
						// �޼����� �ޱ�
						InputStream inputStream = socket.getInputStream(); // �Է½�Ʈ��
						byte[] bytes = new byte[1000]; // ����Ʈ �迭 ����
						inputStream.read(bytes); // ��Ʈ������ �о�� ����Ʈ�迭�� ����
						String msg = new String(bytes); // ����Ʈ�迭 ->> ���ڿ� ��ȯ
						// ������ ���ӵ� ��� �����ڵ鿡�� �޽��� ����
						for (Client client : servercontroller.clients) {
							client.send(msg); // ���� ���ڸ� ������
						}
					}
				} catch (Exception e) {
				}
			}
		};
		// ������Ǯ�� ������ �߰�
		servercontroller.threadpool.submit(runnable);
	}
	// 4. ������ �޽��� ������ �޼ҵ�
	public void send(String msg) {
		// ��Ƽ������
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream(); // ��� ��Ʈ��
					outputStream.write(msg.getBytes());
					outputStream.flush(); //��Ʈ���� �޸� �ʱ�ȭ
					
				}catch(Exception e) {
					
				}
			}
		};
		// ������Ǯ�� ������ �߰�
		servercontroller.threadpool.submit(runnable);
	}
	
}
