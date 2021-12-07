<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_num = Integer.parseInt(request.getParameter("b_num"));
	boolean result = BoardDao.getboardDao().delete(b_num);
	if(result) {
		out.print("<script>alert('게시글이 삭제되었습니다.')</script>");
		out.print("<script>location.href='/jsp/website/view/board/boardlist.jsp';</script>"); 
	}else{
		out.print("<script>alert('게시글 삭제 실패')</script>");
		out.print("<script>location.href='/jsp/website/view/board/boardview.jsp';</script>");
	}
%>