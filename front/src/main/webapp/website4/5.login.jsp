<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.header.jsp" %>
	<br>
	<div class="container">
		<div class="inner">
			<h3>�α���</h3>
			<br>
			<div>
				<input class="form-control mb-2" type="text" placeholder="���̵�">
				<input class="form-control mb-2" type="password" placeholder="�н�����">
			</div>
			<div class=>
				<button class="btn btn-dark" style="padding : 6px 227px 6px 227px;">�α���</button>
			</div>
			<div class="find_info mt-2">
				<a href="#" class="text-dark pr-3">���̵�ã��</a>
				<a href="#" class="text-dark pr-3">��й�ȣã��</a>
				<a href="6.signup.jsp" class="text-dark">ȸ������</a>	
			</div>
			<div class="sns_login mt-3" >
				<h4>SNS �α���/����</h4>
				<a href="https://facebook.com" class="me-4 mr-2"><i class="fab fa-facebook fa-3x"></i></a>
				<a href="https://twitter.com" class="me-4 mr-2 "><i class="fab fa-twitter fa-3x"></i></a>
				<a href="https://www.google.com" class="me-4 mr-2"><i class="fab fa-google fa-3x"></i></a>
				<a href="https://www.instagram.com" class="me-4 mr-2"><i class="fab fa-instagram fa-3x"></i></a>
				<a href="https://www.apple.com/kr" class="me-4"><i class="fab fa-apple fa-3x"></i></a>
			</div>
		</div>
	</div>
	<br><br><br><br><br>
	<%@include file="3.footer.jsp" %>
</body>
</html>