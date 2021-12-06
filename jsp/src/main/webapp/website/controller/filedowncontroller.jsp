<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 경로에서 파일 이름 요청 ../../controller/filedowncontroller.jsp?file=<%=board.getB_file() 
	request.setCharacterEncoding("UTF-8");
	String filename = request.getParameter("file");
	// 2. 서버내 업로드 폴더에서 파일 찾기
	String folderpath = request.getSession().getServletContext().getRealPath("website/upload/"+filename);
						// request.getSession().getServletContext().getRealPath : 경로찾기
	// 3. 파일 객체화
	File file = new File(folderpath);
	// 4. 클라이언트에게 응답하기
	response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
		// Content-Disposition : 다운로드형식HTML 
		// "attachment;filename="+filename+";" : 하단에 뜨는 파일 이름 
	// 내보내기 [스트림]
	// 1. 만약에 파일이 존재 하면
	if(file.isFile()) { // file.isFile() : 파일이 있는지 없는지 유무 확인
		// 2. 입력스트림 [파일을 바이트형으로 읽어오기]
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		byte[] bytes = new byte[(int)file.length()]; //file.length : 파일내 바이트 길이 메소드
		inputStream.read(bytes);
		
		// 3.출력스트림	[읽어온 바이트형 파일을 내보내기]				//response.getOutputStream() : 클라이언트에게 바이트로 전송
		BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
		outputStream.write(bytes);
		
		inputStream.close();	// 입력스트림 닫기
		outputStream.close();	// 출력스트림 닫기
	}
	         
%>