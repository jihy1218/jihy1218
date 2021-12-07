<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int r_num = Integer.parseInt(request.getParameter("r_num"));
	int b_num = Integer.parseInt(request.getParameter("b_num"));
	boolean result = BoardDao.getboardDao().replydelete(r_num);
	if(result) {
		out.print("<script>alert('댓글이 삭제되었습니다.')</script>");
		out.print("<script>location.href='/jsp/website/view/board/boardview.jsp?b_num="+b_num+"';</script>"); 
	}else{
		out.print("<script>alert('댓글 수정 실패')</script>");
	}
%>