<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		
	</style>
</head>
<body>
	<%@include file="../2.header.jsp" %>
	<div class="container">
		<div class="text-center">
			<h3 style="border-bottom: solid 1px #eeeeee; padding-bottom: 10px;">로그인	</h3>
			<br>
			<p style="color: teal;"> · BMW 멤버가되시면 다양한 이벤트를 제공 받을 수 있습니다 ·</p>
		</div>
		<div class="row">
			<div class="col-md-6">
				<img src="../../img/bmw.jpg" width="100%" >
			</div>
			<div class="col-md-6 align-self-center">
				<form action="../../controller/logincontroller.jsp" method="post">
					<div class="row">
						<div class="col-md-3 m-2 text-info"><label>아이디</label></div>					
						<div class="col-md-8"><input type="text" name="id" class="form-control text-info" maxlength="15" > </div>
					</div>
					<div class="row">
						<div class="col-md-3 m-2 text-info"><label>비밀번호</label></div>					
						<div class="col-md-8"><input type="password" name="password" class="form-control text-info" maxlength="15"> </div>
					</div>
					<div class="row">
						<div class="col-md-3 offset-3">
							<a href="#" class="text-success">아이디찾기</a>
						</div>
						<div class="col-md-3 offset-1">
							<a href="#" class="text-warning">패스워드찾기</a>
						</div>
					</div>
					<div>
						<input type="submit" value="로그인" class="form-control p-3 m-3 text-secondary"></input>
					</div>
				</form>
			</div>	
		</div>
	</div>
</body>
</html>