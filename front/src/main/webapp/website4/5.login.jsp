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
				<button class="btn btn-dark" style="padding : 6px 232px 6px 232px;">�α���</button>
			</div>
			<div class="find_info mt-2">
				<a href="#" class="text-dark pr-3">���̵�ã��</a>
				<a href="#" class="text-dark pr-3">��й�ȣã��</a>
				<a href="6.signup.jsp" class="text-dark">ȸ������</a>	
			</div>
			<br>
			<div class="sns_login mt-3" >
				<h4>SNS �α���/����</h4>
				<br>
				<a href="https://naver.com" class="me-4 mr-2"><img src="img/naver1.png"> </a>
				<a href="https://www.apple.com/kr" class="me-4"><img src="img/apple.png"> </a>
				<a href="https://www.kakaocorp.com/page/" class="mb-3"><img src="img/kakao.png"> </a>
			</div>
		</div>
	</div>
	<br><br><br><br><br>
	<%@include file="3.footer.jsp" %>
</body>
</html>