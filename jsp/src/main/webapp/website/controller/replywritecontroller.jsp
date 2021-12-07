<%@page import="dao.BoardDao"%>
<%@page import="dto.Reply"%>
<%@page import="dao.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	request.setCharacterEncoding("UTF-8");
	String contents = request.getParameter("contents");
	contents = contents.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
	// 작성자 아이디
	Login login = (Login)session.getAttribute("login");
	int m_num = login.getM_num();
	// 게시물 번호
	int b_num = Integer.parseInt(request.getParameter("b_num"));
	
	if(!contents.equals("")){
		Reply reply = new Reply(contents,m_num,b_num);
		boolean result = BoardDao.getboardDao().replywrite(reply);
		if(result) {
			out.print("<script>alert('댓글이 작성되었습니다.')</script>");
			out.print("<script>location.href='/jsp/website/view/board/boardview.jsp?b_num="+b_num+"';</script>"); 
		}
	}else{
		out.print("<script>alert('댓글 작성 실패')</script>");
		out.print("<script>location.href='/jsp/website/view/board/boardview.jsp?b_num="+b_num+"';</script>"); 
	}
%>