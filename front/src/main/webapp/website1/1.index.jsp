<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
	
	header{/* ����±� */
		width:1150px;				/* ���α��� */
		height: 100px;				/* ���� : ���̾ƿ��� */
		margin: 0 auto;				/* �ڽ��� ��� ���� [ ��Ʈ�� ] */
	}
	#main_img {
		width: 100%;				/* ���α��� : ����� */
		height: 250px;				/* ���� */
	}
	#contents {
		width: 1150px;				/* ���α��� */
 		margin: 0 auto;				/* �ڽ��� ��� ���� [ ��Ʈ�� ] */
	}
	#sub_menu {
		width: 240px;  				/* ���α��� */
		float: left;				/* �ڽ���  */
	}
	#main_contents{
		width: 900px;				/* ���α��� */
		float: right; 
	}
	footer{
		width: 100%;				/* ���α��� : ����� */
		height: 150px;				/* ���� */
		clear: both;  				/* float �ʱ�ȭ */
			
	}
	</style>
</head>
<body>
	<!-- 1.���̾ƿ� (display : block => �� ĭ -->
		<%@include file="2.header.jsp" %>
		<%@include file="3.mainimg.jsp" %>
		<%@include file="4.main.jsp" %>
		<%@include file="5.footer.jsp" %>
</body>
</html>