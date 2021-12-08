<%@page import="dao.MemberDao"%>
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
	<%
		request.setCharacterEncoding("UTF-8");
		// 검색 처리
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		String pagenum = request.getParameter("page");
		int lastrow = BoardDao.getboardDao().boardcount(key,keyword); // 총 게시물수
		int listsize = 10;	// 페이지당 화면에 표시할 게시물수
		
		int lastpage = 0;	// 마지막 페이지
		if(lastrow % listsize==0) {lastpage = lastrow / listsize;} // 만약에 총게시물/페이지당게시물 나머지가 없으면
		else {lastpage = lastrow/listsize+1;}	// 총게시물/페이지당 게시물+1
		if(pagenum==null) {	// 페이지 번호가 없으면 
			pagenum= "1";	// 1번으로 부여
		}
		int currentpage = Integer.parseInt(pagenum); 	// 현재 페이지번호
		int startrow = (currentpage-1)*listsize;		// 현재페이지 시작번호
		int endrow = currentpage*listsize;
		
		ArrayList<Board> boards = BoardDao.getboardDao().boardlist(startrow, listsize, key, keyword);
	%>
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
		<%
			if(keyword != null) {%>
			<p>총 게시물 수 : <%=lastrow %>
		<%
		}else{%>
			<p>총 게시물 수 : <%=lastrow %>
		<%
		}
		%>
		
		<table class="table text-center table-hover listbaby">
			<tr class="table-secondary">
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
			</tr>
			<%
				if(boards.size()==0) {%>
				<tr>
					<td colspan="5">검색결과가 존재하지않습니다.</td>
				</tr>
			<%
			}
			%>
			<%
				for( Board board : boards) {
			%>		
				<tr>
					<td class="table-info"><%=board.getB_num() %></td>
					<td class="table-danger"><a href="boardview.jsp?b_num=<%=board.getB_num() %>"><%=board.getB_title() %><span class="text-danger">[<%=BoardDao.getboardDao().replycount(board.getB_num()) %>]</span></a></td>
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
				<!-- 첫페이지 이면 이전페이지로 돌아갈수없음 -->
				<% if(currentpage==1){%>
					<% if(keyword !=null) {%>
					<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=currentpage%>&key=<%=key%>&keyword=<%=keyword%>">Previous</a></li>
					<%}else{%>
					<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=currentpage%>">Previous</a></li>
					<%}%>
				<%}else{%>
					<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=currentpage-1%>&key=<%=key%>&keyword=<%=keyword%>">Previous</a></li>
				<%}%>
				
				<%
					for(int i = 1 ; i<=lastpage ; i++) {
				%> 
					<!-- 게시물 수 만큼 페이지 경로 생성 -->
					<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=i %>&key=<%=key%>&keyword=<%=keyword%>"><%=i %></a></li>
				<%
					}
				%>
				<%if(currentpage==lastpage) { %>
					<% if(keyword !=null) {%>
					<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=currentpage%>&key=<%=key%>&keyword=<%=keyword%>">Next</a></li>
					<%}else{%>
					<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=currentpage%>">Next</a></li>
					<%}%>
				<%}else{%>
					<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=currentpage+1%>&key=<%=key%>&keyword=<%=keyword%>">Next</a></li>
				<%
				}
				%>
			</ul>
		</div>
		<form action="boardlist.jsp?page=<%=currentpage %>" method="get" class="col-md-5 offset-3 input-group">
			<select class="custom-select form-control col-md-3" name="key">  <!-- key : 필드명 -->
				<option value="b_title">제목</option>
				<option value="b_num">번호</option>
				<option value="b_contents">내용</option>
				<option value="b_writer">작성자</option>
			</select>
			<input type="text" class="form-control ml-3" name="keyword">	<!-- keyword : 검색단어 -->
			<input type="submit" value="검색" class="btn btn-success ml-3">
		</form>
	</div>
	<br><br><br><br>
	<%@include file="../footer.jsp" %>
</body>
</html>