<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
		request.setCharacterEncoding("UTF-8");		
		String name = request.getParameter("name");
		/* request : jsp 내장객체
					.getParameter("변수명") 전 페이지로 부터 변수를 요청 : 해당변수를 요청
					
		*/
		String color = request.getParameter("color");
	%>
</head>
<body bgcolor=<%=color%>>
	
	이름 : <%=name %>	

</body>
</html>