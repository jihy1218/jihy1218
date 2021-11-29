<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");%>
	<jsp:forward page="9.액션태그2결과이동.jsp">
		<jsp:param value="forward태그와 같이 요청된 데이터" name="contents"/>
	</jsp:forward>
</body>
</html>