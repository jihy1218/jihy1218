<%@page import="dao.Login"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	// DB 처리
	boolean result = MemberDao.getmemberDao().memberlogin(id, password);
	if(result) { // 로그인 성공시
		// 회원번호 찾기
		int m_num = MemberDao.getmemberDao().getmembernum(id);
		// 회원번호와 아이디 객체화 
		Login login = new Login(m_num ,id);
		// 세션 부여[ 내장객체 : 기본값 30분]
		session.setAttribute("login", login);		// 세션명 , 세션데이터
		response.sendRedirect("../view/main.jsp");
	}else{
		response.sendRedirect("../view/member/login.jsp?result=fail");
	}
%>
