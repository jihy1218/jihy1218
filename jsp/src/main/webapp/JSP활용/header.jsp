<%@page import="text.Board"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="text.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String loginid = (String)session.getAttribute("loginid"); // 세션호출 %> 
	
	<%
	ArrayList<Member> members = new ArrayList<>(); 	// 1. 파일내 회원객체를 저장할 리스트
	// 2. 파일 입력스트림 선언
	FileInputStream fileInputStream = new FileInputStream("D:/Enterprise/jihy1218/jsp/src/main/java/text/memberlist.txt");
	byte[] bytes = new byte[1000];	// 3. 읽어올 바이트를 저장할 바이트 배열
	fileInputStream.read(bytes);	// 4. 파일 읽기 -> 바이트배열 저장
	String smember = new String(bytes);	// 5. 바이트 배열-> 문자열 변환
	String[] ssmember = smember.split("\n");	// 6. 문자열 분해 [\n] : 회원구분
	for (int i = 0 ; i <ssmember.length-1; i++) {	// 7.마지막 \n을 제외한 반복문
		Member member = new Member(ssmember[i].split(",")[0],ssmember[i].split(",")[1],ssmember[i].split(",")[2]);
		members.add(member); // 리스트에 객체 저장
	}
	fileInputStream.close();
	
	%>
	<%
	ArrayList<Board> boards = new ArrayList<>();
	FileInputStream fileInputStream2 = new FileInputStream("D:/Enterprise/jihy1218/jsp/src/main/java/text/boardlist.txt");
	byte[] bytes2 = new byte[1000];
	fileInputStream2.read(bytes2);
	String sboard = new String(bytes2);
	String[] ssboard = sboard.split("\n");
	for(int i=0; i<ssboard.length-1;i++) {
		Board board = new Board(ssboard[i].split(",")[0],ssboard[i].split(",")[1],ssboard[i].split(",")[2]);
		boards.add(board);
	}
	fileInputStream2.close();
	%>
	<% String[] 도서목록= { "된다!네이버 블로그&포스트", "스프링 루트 실천 활용 마스터", "Tucker의 Go 언어 프로그래밍", "혼자 공부하는 C 언어"}; %>
	
	<h3><a href="main.jsp" >헤더 페이지 구역 </a></h3>
	<ul>
		<% if(loginid!=null) {out.print("<li>"+loginid+"님 안녕하세요</li>");} %>
		<% if(loginid!=null) { %>
			<li><a href="logout.jsp">로그아웃</a></li>
		<%} %>
		<li><a href="login.jsp"> 로그인 </a></li>
		<li><a href="signup.jsp">회원가입</a></li>
		<li><a href="boardlist.jsp"> 게시판</a></li>
		<li><a href="book.jsp">도서검색</a></li>
		<li><a href="lotto.jsp">로또구매</a></li>
	</ul>
</body>
</html>