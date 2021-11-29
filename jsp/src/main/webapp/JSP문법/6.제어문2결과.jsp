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
		String string = request.getParameter("string");
		int count = Integer.parseInt(request.getParameter("count"));
		
		for (int i= 0; i<count ; i++) {
			out.print(i+"번째:" + string+"<br>" );
		}
		/* form
				action : "이동할 페이지 경로"
				method : 전송방식
						*post : URL 변수가 안보임 (보안중요! ex)로그인 등등)
						*get : URL 변수가 보임 (캐시값)
		*/
	%>
</body>
</html>