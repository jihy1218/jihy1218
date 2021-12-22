package dto;

import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting/{roomname}") // 1.서버소켓[종착점] @ServerEndpoint("/경로") 
public class Chatting {
	 
	// 접속된 세션을 저장하는 리스트 [ArrayList 동기화미지원 vs Vector 동기화지원 ]
	private static Vector<Session> clients = new Vector<Session>();
	
	// 2. 클라이언트가 서버로부터 접속 요청
	@OnOpen // 소켓 접속하는 어노테이션
	public void onOpen(Session session , @PathParam("roomname")String id ) {
		System.out.println(id);
		clients.add(session); // 리스트에 추가
	}
	// 3. 클라이언트가 서버로부터 접속 해지
	@OnClose // 소켓을 닫는 어노테이션
	public void onClose(Session session, @PathParam("roomname")String id) {
		clients.remove(session); // 리스트에서 제거
	}
	// 4. 서버가 클라이언트로부터 메시지 받는 메소드
	@OnMessage // 메시지를 받는 어노테이션 
	public void onMessage(String msg, Session session, @PathParam("roomname")String id) throws Exception{
		// 인수 : 메시지 , 세션
		for(Session client : clients) {
			// 모든 리스트에 저장된 세션으로부터
			if(!client.equals(session)) {
				// 보낸사람을 제외한 모든 사람에게
				client.getBasicRemote().sendText(msg);
			}
		}
	}
	/*
	// 5. 에러시(오류발생시 자동으로 소켓종료)
	 @OnError // 에러시 어노테이션 public void onError(Session session) {
	 }
	*/}
