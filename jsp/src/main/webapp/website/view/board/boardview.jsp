<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
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
	<%
		int b_num = Integer.parseInt(request.getParameter("b_num"));	// 전페이지에서 클릭한 게시물 번호
		Board board = BoardDao.getboardDao().getboard(b_num);
	%>
	<div class="container">
		<table class="table table-hover table-striped">
			<thead>
				<tr class="table-secondary">
					<th colspan="3" class="text-info">고객센터</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-info">
					<td>제목</td><td colspan="2"><%=board.getB_title() %></td>
				</tr>
				<tr class="table-warning">
					<td>내용</td><td colspan="2"><%=board.getB_contents() %></td>
				</tr>
				<tr class="table-danger">
					<td>첨부파일</td><td colspan="2"><a href="../../controller/filedowncontroller.jsp?file=<%=board.getB_file() %>"><%=board.getB_file() %></a></td>
				</tr>
				<% 
					if(board.getB_file2()!=null) {
				%>
				<tr class="table-success">
					<td>추가첨부파일</td><td colspan="2"><a href="../../controller/filedowncontroller.jsp?file=<%=board.getB_file2() %>"><%=board.getB_file2() %></a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>