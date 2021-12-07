<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.Login"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String folderpath = request.getSession().getServletContext().getRealPath("website/upload");
	MultipartRequest multi = new MultipartRequest(request,folderpath,1024*1024*10, "UTF-8", new DefaultFileRenamePolicy()); 
	request.setCharacterEncoding("UTF-8");
	String title = multi.getParameter("title");
	String contents = multi.getParameter("contents");
	// <br> -> \n , 프론트 태그 제거  사용자 입력상자 사용시 필수
	// contents = contents.replace("\r\n", "<br>");
	contents = contents.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
	title = title.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\S)*(/)?","");		
	String file = multi.getFilesystemName("file");	// getFilesystemName : 파일명 가져오기
	String file2 = multi.getFilesystemName("file2");
	
	if(file==null) {
		file = multi.getFilesystemName("oldfile");
	}
	if(file2==null) {
		file2 = multi.getFilesystemName("oldfile2");
	}
	int b_num = Integer.parseInt(multi.getParameter("b_num"));
	// 객체화
	Board board = new Board(b_num,title,contents,file,file2);
	// DB 처리
	boolean result = BoardDao.getboardDao().update(board);
	if(result) {
		out.print("<script>alert('게시글이 수정되었습니다.')</script>");
		out.print("<script>location.href='/jsp/website/view/board/boardview.jsp?b_num="+b_num+"';</script>"); 
	}else{
		out.print("<script>alert('게시글 수정 실패')</script>");
	}
%>