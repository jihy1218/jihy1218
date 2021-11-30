<%@page import="java.util.Random"%>
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
	<%	int [] random = new int[6];	%>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int num3 = Integer.parseInt(request.getParameter("num3"));
		int num4 = Integer.parseInt(request.getParameter("num4"));
		int num5 = Integer.parseInt(request.getParameter("num5"));
		int num6 = Integer.parseInt(request.getParameter("num6"));
		int[] number = {num1,num2,num3,num4,num5,num6}; 
		out.print(Arrays.toString(number)+"<br>");
		
		for(int i=0; i<6 ; i++) {
			Random random2 = new Random();
			int num = random2.nextInt(45)+1;
			boolean check = true;
			for(int j=0;j<6;j++) {
				if(num==random[j]) {
					i--;
					check =false;
					break;
				}
			}if(check) random[i] =num;
		}
		for(int i = 0 ; i<6 ; i++) {
			out.print(random[i]+" "); 
		}
		int count = 0;
		for(int i=0; i<6 ; i++) {
			for(int j=0 ; j<6 ; j++) {
				if(number[i]==random[j]) {
					count++;
				}
			}
		}
		out.print("<br>"+"추첨결과 맞은개수 : " + count);
	%>
</body>
</html>