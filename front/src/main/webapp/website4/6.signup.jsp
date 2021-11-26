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
			<h3>회원가입을 시작합니다!</h3>
			<br>
			<div class="signup_item">
				<h5>아이디<span class="text-danger">*</span></h5>
				<input class="form-control" type="text" placeholder="아이디를 입력하세요">
			</div>
			<div class="signup_item">
				<h5>이메일<span class="text-danger">*</span></h5>
				<input class="form-control" type="email" placeholder="이메일을 입력하세요">
			</div>
			<div class="signup_item">
				<h5>비밀번호<span class="text-danger">*</span></h5>
				<input class="form-control" type="password" placeholder="비밀번호를 입력하세요">
				<input class="form-control" type="password" placeholder="비밀번호를 한번더 입력하세요">
			</div>
			<div class="signup_item">
				<h5>휴대폰 번호<span class="text-danger">*</span></h5>
				<div class="row">
					<div class="col-md-3">
						<input class="form-control" type="text" placeholder="010">
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" placeholder="0000">
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" placeholder="0000">
					</div>
					<div class="col-md-3">
						<button class="btn btn-info">인증요청</button>
					</div>
				</div>
			</div>
			<div class="signup_item">
				<h5>생년월일</h5>
				<div class="row">
					<div class="col-md-6">
						<input class="form-control" type="date">
					</div>
				</div>
				<p>생년월일을 입력하시면<span class="text-primary">회원가입 쿠폰을 지급</span>해드립니다.
			</div>
			<div class="signup_item">
				<div class="row">
					<div class="col-md-1 mt-1">
						<input class="form-control" type="checkbox">
					</div>
					<!-- <div class="col-md-3">
						<span>약관 모두 동의</span>
					</div> -->
				</div>		
			</div>
		</div>
	</div>
	<%@include file="3.footer.jsp" %>
</body>
</html>