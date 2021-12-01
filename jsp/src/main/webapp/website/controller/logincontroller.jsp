<%@page import="dao.MemberDao"%>
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
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		Cookie cookie = new Cookie("id",id);
		boolean result = MemberDao.getmemberDao().memberlogin(id, pw);
		if(result) {
			session.setAttribute("id", id);
			session.setAttribute("password", pw);
			response.sendRedirect("../view/member/loginsuccess.jsp");
			
			cookie.setValue(pw);
			response.addCookie(cookie);
		}else{
			out.print("<script>alert('아이디 혹은 비밀번호가 일치하지않습니다.')</script>");
			out.println("<script>location.href='../view/member/login.jsp';</script>");
		}
			
		
	%>
</body>
</html>