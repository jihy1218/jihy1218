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
	<div class="container">
		<h3 class="text-center">실시간 채팅</h3>
		<div class="text-center m-3">
			<button class="btn btn-outline-success" onclick="start('<%=loginid%>','1');">1번방</button>
			<button class="btn btn-outline-warning" onclick="start('<%=loginid%>','2');">2번방</button>
			<button class="btn btn-outline-danger" onclick="start('<%=loginid%>','3');">3번방</button>
			<button class="btn btn-outline-danger" onclick="exit();" id="btnexit" style="display: none;">나가기</button><br>
		</div>
		<div class="row" id="chatwindow" style="display: none;">
			<div class="col-md-6">
				<div id="roomnum" style="display: none;"></div>
				<div id="msgbox"> <!-- 채팅창 -->
				</div>
				<div class="row no-gutters"> <!-- 채팅입력 -->
					<div class="col-md-10">
						<input class="form-control" type="text" id="msginput"  placeholder="내용을 입력하세요.">
					</div>
					<div class="col-md-2">
						<button class="form-control" onclick="send();">전송</button>				
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<input type="text" class="form-control" id="toid" placeholder="모두">
				<div id="mlist">
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		// 전역변수들 : 모든 function 에서 사용되는 변수들
		// 로그인된 아이디 // 메시지창 // 웹소켓
		var loginid = null;  var msgbox = null;	var webSocket = null;
		var roomnum=0; // 방번호
		function start(id,num) { // 채팅방 접속 버튼을 눌렀을때 [인수는로그인아이디, 채팅방번호]
			// 로그인이 되어있지 않을때
			if(id=="null"){alert("로그인후 이용 가능합니다."); return;} // 접속불가
			else{
				document.getElementById("chatwindow").style.display=""; // 채팅창 보이기
				document.getElementById("btnexit").style.display=""; 	// 나가기 버튼 보이기
				loginid = id; // value 속성이 있는 태그만 가능
				// 3. 채팅창 가져오기
				msgbox = document.getElementById("msgbox"); // 채팅방 가져오기
				msgbox.innerHTML += "<div class='text-center col-md-4 offset-4 mt-2' style='border-radius : 15px; background-color : #ffffff;'>"+num+"번 방에 입장했습니다.</div>";
				roomnum = num; // 방 번호 인수를 방번호 변수에 저장
				document.getElementById("roomnum").value=num; // 방 번호 저장
				webSocket = new WebSocket("ws://localhost:8081/jsp/chatting/"+roomnum);
				webSocket.onopen = function(event) { onOpen(event)	}; // 웹 소켓 실행시 메소드
				webSocket.onclose = function(event) { onClose(event)	}; // 웹 소켓 종료시 메소드
				webSocket.onmessage = function(event) { onMessage(event)	}; // 웹 소켓 종료시 메소드
				webSocket.onerror = function(event) { onError(event)	}; // 웹 소켓 에러 메소드
			}
		}
		function exit() { // 1.채팅창 초기화 2. 버튼숨기기 3. 채팅창숨기기 4. 목록다시띄우기
			document.getElementById("chatwindow").style.display="none"; // 채팅창 숨기기
			document.getElementById("msgbox").innerHTML = "";			// 채팅창 내용 초기화
			document.getElementById("btnexit").style.display="none";	// 버튼 숨기기
			webSocket.close();											// 소켓 닫기
		}
			// 접속 객체										// @ServerEndpoint 이동
		// 6. 이벤트 메소드 정의
		function onOpen(event) {alert("채팅에 접속되었습니다.");}
		function onClose(event) {alert("채팅이 종료되었습니다.");}
		function onError(event) {alert("채팅에 오류가 발생했습니다."+event.data+"관리자에게 문의하세요.");}
		// 8. 클라이언트가 받는 메소드
		function onMessage(event) {
			var from = event.data.split(",")[1];	// , 기준으로 1번째 문자열
			var to = event.data.split(",")[2];		// , 기준으로 2번째 문자열
			var time = event.data.split(",")[3];	// , 기준으로 3번째 문자열
			var msg = event.data.split(",")[4];		// , 기준으로 4번째 문자열
			// 만약 로그인된아이디와 to 가 같은경우 (귓속말같은기능)
			if(to==loginid){ // 특정아이디만 받기
				msgbox.innerHTML+="<div class='profile'>"+from+"</div>";
				msgbox.innerHTML+="<div class='d-flex justify-content-start mx-2 my-1'><span class='tomsg'>"+msg+"</span><span class='msgtime d-flex align-items-end'>"+time+"</span></div>";
				msgbox.scrollTop = msgbox.scrollHeight;	// 현재스크롤 위쪽위치 = 스크롤 전체 높이
			}else if( to == "all" ){ // 모든 메시지 [모든 사람이 받는 메시지]
				msgbox.innerHTML+="<div class='profile'>"+from+"</div>";
				msgbox.innerHTML+="<div class='d-flex justify-content-start mx-2 my-1'><span class='tomsg'>"+msg+"</span><span class='msgtime d-flex align-items-end'>"+time+"</span></div>";
				msgbox.scrollTop = msgbox.scrollHeight;	// 현재스크롤 위쪽위치 = 스크롤 전체 높이
			}
		}
		// 7. 보내는 메소드
		function send() {
			// 1. 입력창에 입력된 데이터를 가져온다.
			var msginput = document.getElementById("msginput").value;
				if(msginput== "" ){ // 입력ㄷ이 없을때 유효성검사 [ 전송 막기 ]
					alert("내용을 입력해주세요."); return;}
			// 날짜 시간 // js에서 현재 날짜 시간객체
			let today = new Date(); // 날짜랑 시간을 알려주는 객체
			var time = today.toLocaleTimeString(); // 날짜 빼고 시간만 가져오기
			// 보낸 사람 메시지에 포함시키기.
			var toid = document.getElementById("toid").value;
			if(toid==""){
				toid="all"; // 모두에게 보내기  // 귓속말 대상이 없으면
			}
			roomnum = document.getElementById("roomnum").value;
			var msg = roomnum+","+loginid+","+toid+","+time+","+msginput;
			msgbox.innerHTML+="<div class='d-flex justify-content-end mx-2 my-1'><span class='msgtime d-flex align-items-end'>"+time+"</span><span class='frommsg'>"+msginput+"</span></div>";	
			webSocket.send(msg); // 메시지 전송
			// 입력상자 초기화
			document.getElementById("msginput").value=""; // 입력했던 내용물 초기화
			// 스크롤이 있을경우 스크롤 위치를 아래로 이동
			msgbox.scrollTop = msgbox.scrollHeight;	// 현재스크롤 위쪽위치 = 스크롤 전체 높이
			
		/* 	if(window.event.keyCode == 13){ // 윈도우 키코드중에 13번(엔터)이 눌리면 
				var msginput = document.getElementById("msginput").value;
				if(msginput==""){alert("내용을 입력해주세요."); return;}
				let today = new Date(); // 날짜랑 시간을 알려주는 객체
				var time = today.toLocaleTimeString(); // 날짜 빼고 시간만 가져오기
				var toid = document.getElementById("toid").value;
				if( toid== "" ){toid="all";}
				roomnum = document.getElementById("roomnum").innerHTML;
				var msg = roomnum+","+loginid+","+toid+","+time+","+msginput;
				msgbox.innerHTML+="<div class='d-flex justify-content-end mx-2 my-1'><span class='msgtime d-flex align-items-end'>"+time+"</span><span class='frommsg'>"+msginput+"</span></div>";	
				webSocket.send(msg); // 메시지 전송
				document.getElementById("msginput").value=""; // 입력했던 내용물 초기화
				msgbox.scrollTop = msgbox.scrollHeight;	// 현재스크롤 위쪽위치 = 스크롤 전체 높이
			} */
		}
	</script>
</body>
</html>