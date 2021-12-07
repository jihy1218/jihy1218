<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
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
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		Board board = BoardDao.getboardDao().getboard(b_num);
		board.setB_contents(board.getB_contents().replaceAll("<br>", "\n"));
	%>
	<%@include file="../header.jsp" %>
	<!-- 글수정 페이지 -->
	<div class="container">
		<form action="../../controller/boardupdatecontroller.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="b_num" value="<%=b_num%>">
			<input type="hidden" name="oldfile" value="<%=board.getB_file()%>">
			<input type="hidden" name="oldfile2" value="<%=board.getB_file2()%>">	
			<label class="text-info">제목</label> <input class="form-control" type="text" name="title" value="<%=board.getB_title() %>"> <br>
			<label class="text-info">내용</label> <textarea class="form-control" rows="10" cols="10" name="contents"><%=board.getB_contents() %></textarea><br>
			<label class="text-info">첨부파일</label> <input class="form-control" type="file" name="file"><%=board.getB_file() %><br>
			<label class="text-info">추가첨부파일</label> <input class="form-control" type="file" name="file2"><%=board.getB_file2() %><br>
			<input class="form-control" type="submit" value="수정">
		</form>
	</div>
</body>
</html>