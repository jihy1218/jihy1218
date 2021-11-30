<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<form action="lottoresult.jsp" method="post">
<%-- 	<% for(int i = 0 ; i<45 ; i++) {	%>
		<a href="lotto.jsp?num=<%=i %>"><button type="submit" value="<%=i%>" name="<%=i%>"><%=(i+1) %></button></a>
		<% if(i%6==5) {out.print("<br>");} %>
		<%
		boolean check = true;
		for(int j= 0 ; j<6 ; j++) {
			/* int num = Integer.parseInt(request.getParameter("num"));
			if(num==number[j]){
				j++;
				check = false;
				break;
			} */
		number[j]=(i+1);
		
		} %>
		
	<%} %> --%>
		1번째 번호 입력 : <input type="text" name="num1" placeholder="번호를 입력하세요"><br>
		2번째 번호 입력 : <input type="text" name="num2" placeholder="번호를 입력하세요"><br>
		3번째 번호 입력 : <input type="text" name="num3" placeholder="번호를 입력하세요"><br>
		4번째 번호 입력 : <input type="text" name="num4" placeholder="번호를 입력하세요"><br>
		5번째 번호 입력 : <input type="text" name="num5" placeholder="번호를 입력하세요"><br>
		6번째 번호 입력 : <input type="text" name="num6" placeholder="번호를 입력하세요">

		<input type="submit" value="당첨확인">
	</form>		
	
	
</body>
</html>