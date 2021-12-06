<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.Login"%>
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
		// MultipartRequest 객체명 = new  new MultipartRequest();
		// 1.요청방식[request]
		// 2.업로드 파일 경로
		// 3.용량(바이트) 
		// 4.인코딩타입 - "UTF-8"
		// 5.보안		DefaultFileRenamePolicy() 파일명 동일할경우 자동으로 식별가능하게 함
		// 서버로 파일 업로드
			// 현재 작업하고있는 폴더로 업로드
		/* String folderpath = "D:/Enterprise/jihy1218/jsp/src/main/webapp/website/upload"; */
			// 서버폴더로 업로드
				// 1. 서버 실제 경로
				// 2. 
		String folderpath = request.getSession().getServletContext().getRealPath("website/upload");
		MultipartRequest multi = new MultipartRequest(request,folderpath,1024*1024*10, "utf-8", new DefaultFileRenamePolicy()); 
		// 요청	[일반 form]
		/*
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String file = request.getParameter("file"); */
		//요청
		request.setCharacterEncoding("UTF-8");
		String title = multi.getParameter("title");
		String contents = multi.getParameter("contents");
		String file = multi.getFilesystemName("file");	// getFilesystemName : 파일명 가져오기
		String file2 = multi.getFilesystemName("file2");
		
		// 작성자 아이디
		Login login = (Login)session.getAttribute("login");
		int m_num = login.getM_num();
		// 객체화
		Board board = new Board(title,contents,m_num,file,file2);
		// DB 처리
		BoardDao.getboardDao().boardwrite(board);
		response.sendRedirect("../view/board/boardlist.jsp");
	%>
</body>
</html>