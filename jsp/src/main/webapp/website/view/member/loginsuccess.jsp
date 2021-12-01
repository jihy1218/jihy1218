<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../2.header.jsp" %>
	<h3>로그인 성공페이지</h3>
	<%
		Enumeration enumeration = session.getAttributeNames();
		
		while(enumeration.hasMoreElements()){
			String name = (String)enumeration.nextElement();
			String value = (String)session.getAttribute(name);
			out.println("세션이름 : " + name+" 세션 값 : "+ value);
		}
	%>
	<% 
		Cookie[] cookies = request.getCookies();
		out.print(Arrays.toString(cookies));
		if(cookies !=null){
			for(int i = 0 ; i<cookies.length;i++) {
				if(cookies[i].getName().equals("id")){ %>	<br>
					내 쿠키이름 : <%=cookies[i].getName() %>
					내 쿠키이름 : <%=cookies[i].getValue() %>
				<%
				}
			}
		}
	%>
</body>
</html>