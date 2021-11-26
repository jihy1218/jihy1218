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
			<h3>로그인</h3>
			<br>
			<div>
				<input class="form-control mb-2" type="text" placeholder="아이디">
				<input class="form-control mb-2" type="password" placeholder="패스워드">
			</div>
			<div class=>
				<button class="btn btn-dark" style="padding : 6px 227px 6px 227px;">로그인</button>
			</div>
			<div class="find_info mt-2">
				<a href="#" class="text-dark pr-3">아이디찾기</a>
				<a href="#" class="text-dark pr-3">비밀번호찾기</a>
				<a href="6.signup.jsp" class="text-dark">회원가입</a>	
			</div>
			<div class="sns_login mt-3" >
				<h4>SNS 로그인/가입</h4>
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