<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
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
	<div class="container">
		<div class="text-center">
			<h3 style=" padding-bottom: 10px;">고객센터</h3>
		</div>
		<%if(loginid!=null) {%>
			<a href="boardwrite.jsp"><button class="btn btn-success float-right mb-2">글쓰기</button></a>
		<%
		}else{%>
		<script>alert("로그인후 글쓰기 가능합니다.")</script>
		<%	
		}
		%>
		<h3>질문게시판</h3>
		<table class="table text-center table-hover listbaby">
			<tr class="table-secondary">
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
			</tr>
			<%
				ArrayList<Board> boards = BoardDao.getboardDao().boardlist();
				for( Board board : boards) {
			%>		
				<tr>
					<td class="table-info"><%=board.getB_num() %></td>
					<td class="table-danger"><a href="boardview.jsp?b_num=<%=board.getB_num() %>"><%=board.getB_title() %></a></td>
						<!-- 게시물 상세페이지 이동[클릭한 게시물 번호 요청] -->
					<td class="table-warning"><%=board.getB_writer() %></td>
					<td class="table-primary"><%=board.getB_date() %></td>
					<td class="table-success"><%=board.getB_view() %></td>
				</tr>
			<% 
				}
			%>
		</table>
		<div class="text-center listbaby">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>				
			</ul>
		</div>
	</div>
	<br><br><br><br>
	<%@include file="../footer.jsp" %>
</body>
</html>