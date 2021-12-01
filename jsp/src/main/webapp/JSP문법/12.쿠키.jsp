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
		// 1. 쿠키클래스를 이용한 쿠키 객체 만들기 ( 이름 , 데이터 )
		Cookie cookie = new Cookie("mycookie","초코칩쿠키");
		// 2. 쿠키 생명주기
		cookie.setMaxAge(60);	// 쿠키의 생명 주기[초단위 60초=1분]
		// 3. 쿠키 내용 변경
		cookie.setValue("애플");
		// 4. 클라이언트에게 쿠키 전달
		response.addCookie(cookie);
	
	%>
	<p>쿠키만들기</p>
	<p>쿠키 내용 <a href="12.쿠키test.jsp">확인</a></p>
</body>

</html>