<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.부트스트랩시작.jsp" %>
	<h2> 1. 부트스트랩 미적용 </h2>
	<form>
		<label>이름</label>
		<input type="text" placeholder="이름">
		<label>이메일</label>
		<input type="email" placeholder="이메일">
		<button type="submit">확인</button> 	
	</form>
	
	<h2> 2. 폼 그룹 </h2>
	<form>
		<div class="form-group">
			<label>이름</label>
			<input class="form-control" type="text" placeholder="이름">
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input class="form-control" type="email" placeholder="이메일">
		</div>
		<div class="form-group">
			<button type="submit">확인</button> 	
		</div>
	</form>
		
	<h2> 3. 폼 인라인 </h2>
	<form class="form-check-inline">
		<div class="form-group">
			<label>이름</label>
			<input class="form-control" type="text" placeholder="이름">
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input class="form-control" type="email" placeholder="이메일">
		</div>
		<div class="form-group">
			<button type="submit">확인</button> 	
		</div>
	</form>
	
</body>
</html>