<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
	
	header{/* 헤더태그 */
		width:1150px;				/* 가로길이 */
		height: 100px;				/* 높이 : 레이아웃용 */
		margin: 0 auto;				/* 박스권 가운데 정렬 [ 컨트롤 ] */
	}
	#main_img {
		width: 100%;				/* 가로길이 : 백분율 */
		height: 250px;				/* 높이 */
	}
	#contents {
		width: 1150px;				/* 가로길이 */
 		margin: 0 auto;				/* 박스권 가운데 정렬 [ 컨트롤 ] */
	}
	#sub_menu {
		width: 240px;  				/* 가로길이 */
		float: left;				/* 박스권  */
	}
	#main_contents{
		width: 900px;				/* 가로길이 */
		float: right; 
	}
	footer{
		width: 100%;				/* 가로길이 : 백분율 */
		height: 150px;				/* 높이 */
		clear: both;  				/* float 초기화 */
			
	}
	</style>
</head>
<body>
	<!-- 1.레이아웃 (display : block => 한 칸 -->
		<%@include file="2.header.jsp" %>
		<%@include file="3.mainimg.jsp" %>
		<%@include file="4.main.jsp" %>
		<%@include file="5.footer.jsp" %>
</body>
</html>