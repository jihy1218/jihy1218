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
	<!-- 글쓰기 페이지 -->
	<div class="container">
		<form action="../../controller/boardwritecontroller.jsp" method="post" enctype="multipart/form-data">	
			<!-- form 전송데이터 기본타입 text(String) enctype="application/x-www-form-urlencoded" -->
			<!-- form 파일데이터 타입 : enctype="multipart/form-data" -->
			<label class="text-info">제목</label> <input class="form-control" type="text" name="title" > <br>
			<label class="text-info">내용</label> <textarea class="form-control" rows="10" cols="10" name="contents"></textarea><br>
			<label class="text-info">첨부파일</label> <input class="form-control" type="file" name="file"><br>
			<label class="text-info">추가첨부파일</label> <input class="form-control" type="file" name="file2"><br>
			<input class="form-control" type="submit" value="등록">
		</form>
	</div>
</body>
</html>