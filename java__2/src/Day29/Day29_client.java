package Day29;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day29_client {

	// 통신용 클라이언트 만들기
	public static void main(String[] args) {

		// 1. 소켓만들기
		Socket socket = new Socket();
		try {
			while (true) {
				socket.connect(new InetSocketAddress("127.168.102.50", 5000));
				System.out.println("[[서버와 연결 성공]]");
				
				// 2. 데이터 송신하기 [보내기] : 스트림이용한 외부 네트워크 통신
				Scanner scanner = new  Scanner(System.in);
				System.out.println(" 서버에게 보낼 메세지 : ");
				String msg = scanner.next();
				OutputStream outputStream = socket.getOutputStream();// 소켓 출력 스트림
				outputStream.write(msg.getBytes());	// 입력받은 문자열 -> 바이트로 변경후 출력
				System.out.println("서버에게 메세지 전송 성공");
				
				// 수신하기
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[1000];
				inputStream.read(bytes);
				System.out.println("서버의 메세지 : " + new String(bytes));
			}
		} catch (Exception e) {

		}

	}
}
