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
	<h3>도서검색 페이지</h3>
	<form action="booksearch.jsp" method="post">
		<input type="text" name="search" placeholder="검색어를 입력하세요"><input type="submit" value="검색">
	</form>
</body>
</html>