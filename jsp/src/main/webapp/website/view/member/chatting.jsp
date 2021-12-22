<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<h3 class="text-center">실시간 채팅</h3>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div id="msgbox"> <!-- 채팅창 -->
				</div>
				<div class="row no-gutters"> <!-- 채팅입렵 -->
					<div class="col-md-10">
						<input class="form-control" type="text" id="msginput" onkeyup="entersend();" placeholder="내용을 입력하세요.">
					</div>
					<div class="col-md-2">
						<button class="form-control" onclick="send();">전송</button>				
					</div>
				</div>
			</div>
			<div class="col-md-6">
				보내는 사람 : <input type="text" class="form-control" id="loginid" value="<%=loginid %>">
				받는 사람 : <input type="text" class="form-control" value="모두">
				접속 회원 목록
				<div id="mlist">
				<input type="text" placeholder="입력" id="chatt">
				<button onclick="change();">방만들기</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		// 2. 현재 회원 아이디를 가져오기
		var loginid = document.getElementById("loginid").value; // value 속성이 있는 태그만 가능
		// 3. 채팅창 가져오기
		var msgbox = document.getElementById("msgbox");
		var chatt = document.getElementById("chatt").value;
		// 4. 웹소켓
		// var webSocket = new WebSocket("ws://웹IP/경로")
		var webSocket = new WebSocket("ws://localhost:8081/jsp/chatting/"+loginid);
			// 접속 객체										// @ServerEndpoint 이동
		// 5. 웹소켓 이벤트
			webSocket.onopen = function(event) { onOpen(event)	}; // 웹 소켓 실행시 메소드
			webSocket.onclose = function(event) { onClose(event)	}; // 웹 소켓 종료시 메소드
			webSocket.onmessage = function(event) { onMessage(event)	}; // 웹 소켓 종료시 메소드
			webSocket.onerror = function(event) { onError(event)	}; // 웹 소켓 에러 메소드
		// 6. 이벤트 메소드 정의
		function onOpen(event) {alert("채팅에 접속되었습니다.");}
		function onClose(event) {alert("채팅이 종료되었습니다.");}
		function onError(event) {alert("채팅에 오류가 발생했습니다."+event.data+"관리자에게 문의하세요.");}
		// 7. 보내는 메소드
		function send() {
			// 1. 입력창에 입력된 데이터를 가져온다.
			var msginput = document.getElementById("msginput").value;
				if(msginput==""){
					alert("내용을 입력해주세요."); return;
				}
			// 날짜 시간
			let today = new Date(); // 날짜랑 시간을 알려주는 객체
			var time = today.toLocaleTimeString(); // 날짜 빼고 시간만 가져오기
			// 보낸 사람 메시지에 포함시키기.
			var msg = loginid+" , "+time+" , "+msginput;
			msgbox.innerHTML+="<div class='d-flex justify-content-end mx-2 my-1'><span class='msgtime d-flex align-items-end'>"+time+"</span><span class='frommsg'>"+msginput+"</span></div>";	
			webSocket.send(msg); // 메시지 전송
			// 입력상자 초기화
			document.getElementById("msginput").value=""; // 입력했던 내용물 초기화
			// 스크롤이 있을경우 스크롤 위치를 아래로 이동
			msgbox.scrollTop = msgbox.scrollHeight;	// 현재스크롤 위쪽위치 = 스크롤 전체 높이
		}
		function entersend() {
			// 엔터를 눌렀을때
			if(window.event.keyCode == 13){ // 윈도우 키코드중에 13번(엔터)이 눌리면 
			var msginput = document.getElementById("msginput").value;
				if(msginput==""){
					alert("내용을 입력해주세요."); return;
				}
			let today = new Date(); // 날짜랑 시간을 알려주는 객체
			var time = today.toLocaleTimeString(); // 날짜 빼고 시간만 가져오기
			var msg = loginid+" , "+time+" , "+msginput;
			msgbox.innerHTML+="<div class='d-flex justify-content-end mx-2 my-1'><span class='msgtime d-flex align-items-end'>"+time+"</span><span class='frommsg'>"+msginput+"</span></div>";	
			webSocket.send(msg); // 메시지 전송
			document.getElementById("msginput").value=""; // 입력했던 내용물 초기화
			msgbox.scrollTop = msgbox.scrollHeight;	// 현재스크롤 위쪽위치 = 스크롤 전체 높이
			}
		}
		// 8. 클라이언트가 받는 메소드
		function onMessage(event) {
			var msg = event.data.split(",")[2];		// : 기준으로 2번째 문자열
			var time = event.data.split(",")[1];		// : 기준으로 2번째 문자열
			var from = event.data.split(",")[0];	// : 기준으로 0번째 문자열
			msgbox.innerHTML+="<div class='profile'>"+from+"</div>";
			msgbox.innerHTML+="<div class='d-flex justify-content-start mx-2 my-1'><span class='tomsg'>"+msg+"</span><span class='msgtime d-flex align-items-end'>"+time+"</span></div>";
			msgbox.scrollTop = msgbox.scrollHeight;	// 현재스크롤 위쪽위치 = 스크롤 전체 높이
		}
	</script>
</body>
</html>