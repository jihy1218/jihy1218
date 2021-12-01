<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. 세션 [ 쿠키와 달리 세션은 내장객체(미리만들어진객체)]
		session.setAttribute("id", "qwer1234");		// 세션저장소[톰캣]
		session.setAttribute("password", "12345");	//
		// 2. 세션 생성주기 [ 세션 호출이 없을때 ]
		session.setMaxInactiveInterval(60);			// 기본단위 : 초 30분이 초기값
		
	%>
	
	<p> 세션 만들기 </p>
	<p> <a href="13.세션test.jsp">확인</a></p>
</body>
</html>