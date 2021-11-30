<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<h3>게시물 상세보기 페이지</h3>
	<%
		int bnum = Integer.parseInt(request.getParameter("bnum"));
	%>
	<table>
		<tr>
			<th>번호 : </th> <td><%=bnum %></td>
		</tr>
		<tr>
			<th>제목 : </th><td><%=boards.get(bnum).getTitle() %></td>
		</tr>
		<tr>
			<th>내용 : </th><td><%=boards.get(bnum).getContents() %></td>
		</tr>	
	</table>	
</body>
</html>