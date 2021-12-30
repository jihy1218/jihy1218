package dto;

import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting/{roomnum}") // 1.서버소켓[종착점] @ServerEndpoint("/경로")
public class Chatting {

	private Integer roomnum = 0;
	// 접속된 세션을 저장하는 리스트 [ArrayList 동기화미지원 vs Vector 동기화지원 ]
	private static Map< Session,Integer> clients = new Hashtable<Session,Integer>();

	// 2. 클라이언트가 서버로부터 접속 요청
	@OnOpen // 소켓 접속하는 어노테이션
	public void onOpen(Session session, @PathParam("roomnum") int roomnum) {
		this.roomnum = roomnum; // 전달 받은 인수를 방번호 인수에 대입
		System.out.print(roomnum);
		clients.put(session,this.roomnum); // 리스트에 추가
	}

	// 3. 클라이언트가 서버로부터 접속 해지
	@OnClose // 소켓을 닫는 어노테이션
	public void onClose(Session session) {
		clients.remove(session); // 방 번호 제거
	}

	// 4. 서버가 클라이언트로부터 메시지 받는 메소드
	@OnMessage // 메시지를 받는 어노테이션
	public void onMessage(String msg, Session session) throws Exception {
							// 메시지 , 보낸사람[세션]
		for(Session key : clients.keySet()) { 
			if(clients.get(key)==Integer.parseInt(msg.split(",")[0])) { // 해당키에 값을져와서 방번호와 동일하면
				// 모든 리스트에 저장된[접속된] 메시지 보내기
				if (!key.equals(session)) {	// 해당키값과 동일한 세션을 제외한(본인을 제외한)
				// 보낸사람을 제외한 모든 사람에게
				key.getBasicRemote().sendText(msg);
				}
			}
		}
	}
	/*
	 * // 5. 에러시(오류발생시 자동으로 소켓종료)
	 * 
	 * @OnError // 에러시 어노테이션 public void onError(Session session) { }
	 */

	

}
