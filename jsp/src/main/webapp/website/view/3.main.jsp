<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PEACH</title>
</head>
<body>
	<%@include file="2.header.jsp" %>
	<h3>메인부분</h3>
	<%
		MemberDao.getmemberDao();
	
	%>
	<%@include file="4.footer.jsp" %>
</body>
</html>