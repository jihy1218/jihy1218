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
		String password = request.getParameter("password");
		// DB 처리
		boolean result = MemberDao.getmemberDao().memberlogin(id, password);
		if(result) { // 로그인 성공시
			// 세션 부여[ 내장객체 : 기본값 30분]
			session.setAttribute("loginid", id);		// 세션명 , 세션데이터
			response.sendRedirect("../view/main.jsp");
		}else{
			response.sendRedirect("../view/member/login.jsp?result=fail");
		}
	%>
</body>
</html>