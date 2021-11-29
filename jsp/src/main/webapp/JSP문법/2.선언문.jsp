<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>선언문</h1>
	<%
		String 스크립트 = "jsp 프로그래밍1";
		int 변수1=0;	// 스크립트 문에서 변수 선언시 초기값 필수 
	%>
	<%!
		String 선언문 = "jsp 프로그래밍2";
		int 변수2;	// 멤버 변수 : 초기값이 없을 경우 null, 0 으로 자동설정
	%>
	
	<br>출력결과 : <%=스크립트 %>
	<br>출력결과 : <%=선언문 %>
	<br>출력결과 : <%=변수1 %>
	<br>출력결과 : <%=변수2 %>
	
	<%! // jsp 선언문 구역
		int one; int two=2;
		public int plus() {
			return one+two;
		}
		String msg;
		int three;
	%>
	<!-- 표현식 -->
	<br>one 과 two 합은 ? : <%=plus()%>		<!-- 메소드 결과 출력 -->
	<br>msg 값은? : <%=msg %>					<!-- 문자열이 초기값이 없을 경우 null -->
	<br>three 값은? : <%=three %>				<!-- 정수열의 초기값이 없을 경우 0  -->

</body>
</html>