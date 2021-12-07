<%@page import="dto.Reply"%>
<%@page import="java.util.ArrayList"%>
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
		String folderpath = request.getSession().getServletContext().getRealPath("website/upload/");
		int b_num = Integer.parseInt(request.getParameter("b_num"));	// 전페이지에서 클릭한 게시물 번호
			String boardviews = loginid+":"+b_num;
			if(session.getAttribute(boardviews) ==null){
				// 조회수 증가
				BoardDao.getboardDao().boardcount(b_num);
				// 세션 부여 
				String boardview = loginid +":"+b_num;
				session.setAttribute(boardview,true);
				session.setMaxInactiveInterval(86400);	// 하루
			}
			
		Board board = BoardDao.getboardDao().getboard(b_num);
		
	%>
	<div class="container">
		<br>
		<div class="row float-right mr-2">
			<div class="m-2"><a href="/jsp/website/view/board/boardlist.jsp"><button class="btn btn-success">목록보기</button></a></div>
			<% if(loginid!=null && loginid.equals(board.getB_writer())){%>
				<div class="m-2"><a href="../../controller/boarddeletecontroller.jsp?b_num=<%=board.getB_num() %>"><button class="btn btn-danger">삭제하기</button></a></div>
				<div class="m-2"><a href="boardupdate.jsp?b_num=<%=board.getB_num() %>"><button class="btn btn-warning">수정하기</button></a></div>
			<%} %>
		</div>
		<table class="table table-hover table-striped">
			<thead>
				<tr class="table-secondary">
					<th colspan="3" class="text-info">고객센터</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>작성자 : <%=board.getB_writer() %></td><td>작성일 : <%=board.getB_date() %></td><td>조회수 : <%=board.getB_view() %></td>
				</tr>
				<tr class="table-info">
					<td>제목</td><td colspan="2"><%=board.getB_title() %></td>
				</tr>
				<tr class="table-warning">
					<td>내용</td><td colspan="2"><%=board.getB_contents() %></td>
				</tr>
				<%
					if(board.getB_file()!=null) {
						
				%>
				<tr class="table-danger">
					<td>첨부파일</td>
					<td>Download : <a href="../../controller/filedowncontroller.jsp?file=<%=board.getB_file() %>"><%=board.getB_file() %></a></td>
					<td>이미지 미리보기<img width="100%" src="../../upload/<%=board.getB_file() %>">
				</tr>
				<%} %>
				<% 
					if(board.getB_file2()!=null) {
				%>
				<tr class="table-success">
					<td>첨부파일2</td>
					<td>Download : <a href="../../controller/filedowncontroller.jsp?file=<%=board.getB_file2() %>"><%=board.getB_file2() %></a></td>
					<td>이미지 미리보기2<img width="100%" src="../../upload/<%=board.getB_file2() %>">
				</tr>
				<%} %>
			</tbody>
		</table>
		<input type="button" onclick="replywrite();" id="replyregister" style="display : none" class="btn btn-info float-right" value="댓글작성">
		<input type="button" onclick="replyon();" class="btn btn-primary float-right" value="댓글보기">
		
		<br>
		<form action="../../controller/replywritecontroller.jsp?b_num=<%=board.getB_num() %>" method="post" enctype="application/x-www-form-urlencoded" >
			<table class="table text-center" id="replytable" style="display : none">
				<tr class="row">
					<th class="col-md-2">번호</th><th class="col-md-5">내용</th><th class="col-md-2">작성일</th><th class="col-md-3">작성자</th>
				</tr>
				<%
					ArrayList<Reply> replys = BoardDao.getboardDao().replylist(b_num);
					for( Reply reply : replys ) {
				%>
					<tr class="row">
						<td class="col-md-2"><%=reply.getR_num() %></td>
						<td class="col-md-5"><%=reply.getR_contents() %></td>
						<td class="col-md-2"><%=reply.getR_date() %></td>
						<td class="col-md-2"><%=reply.getR_writer() %></td>
						<%if(loginid.equals(reply.getR_writer())) {%>
							<td class="col-md-1"><a href="../../controller/replydeletecontroller.jsp?r_num=<%=reply.getR_num()%>&b_num=<%=board.getB_num() %>"><input class="btn btn-danger" type="button" value="삭제하기"></a></td>
						<%} %>
					</tr>
				<%
					}
				%>
				<tr id="replywrite" style="display:none">
					<td class="col-md-8"><input name="contents" type="text" class="form-control" ><td class="col-md-2 offset-2"><input type="submit" class="btn btn-dark" value="댓글등록"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>