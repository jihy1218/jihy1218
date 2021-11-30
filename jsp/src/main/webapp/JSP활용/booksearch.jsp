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
	<h4>검색 결과 페이지</h4>
	<table>
		<tr>
			<th>검색된 도서</th>
		</tr>
	<% 
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		for(int i = 0 ; i <도서목록.length; i++) { %>
			<% if(도서목록[i].contains(search)) {  
				out.print("<tr><td>"+도서목록[i]+"</td></tr>");			
			}%>
	<% }%>	
	</table>
	
</body>
</html>