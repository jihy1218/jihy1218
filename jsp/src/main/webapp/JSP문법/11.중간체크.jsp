<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	int year = 2021;	int month=11;
		if(request.getParameter("year") !=null && request.getParameter("month") !=null){
			year=Integer.parseInt(request.getParameter("year"));
			month=Integer.parseInt(request.getParameter("month"));
		}
	%>

	<%
		Calendar calendar = Calendar.getInstance();				// 현재 날짜 시간
		/* int year = calendar.get(Calendar.YEAR);					// 현재 연도
		int month = calendar.get(calendar.MONTH)+1;		// 현재 월 */
		calendar.set(year, month-1, 1);							// 현재 연 월 세팅
		int sweek = calendar.get(calendar.DAY_OF_WEEK);			// 1일이 시작되는 요일
		int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH);	// 마지막날 30일
	%>
	<h3><%=year%>년<%=month %>월 달력</h3>
	<form action="11.중간체크.jsp">
		검색 : <input type="text" name="year" placeholder="연도">
		<input type="text" name="month" placeholder="월">
		<input type="submit" value="검색">
	</form>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>일요일</th><th>월요일</th><th>화요일</th><th>수요일</th><th>목요일</th><th>금요일</th><th>토요일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<%	for(int i = 1 ; i<sweek; i++) { %>
				<td> </td>
			<%}	%>
			<% for(int i=1; i<=eday; i++) { 
			%>
				<td><%=i %></td>	
			<%
				if(sweek%7==0) {out.print("</tr><tr>"); 
				}
				sweek++;
			} 
			%>
		</tbody>
	</table>
</body>
</html>