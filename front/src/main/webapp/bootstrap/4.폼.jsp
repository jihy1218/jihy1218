<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.��Ʈ��Ʈ������.jsp" %>
	<h2> 1. ��Ʈ��Ʈ�� ������ </h2>
	<form>
		<label>�̸�</label>
		<input type="text" placeholder="�̸�">
		<label>�̸���</label>
		<input type="email" placeholder="�̸���">
		<button type="submit">Ȯ��</button> 	
	</form>
	
	<h2> 2. �� �׷� </h2>
	<form>
		<div class="form-group">
			<label>�̸�</label>
			<input class="form-control" type="text" placeholder="�̸�">
		</div>
		<div class="form-group">
			<label>�̸���</label>
			<input class="form-control" type="email" placeholder="�̸���">
		</div>
		<div class="form-group">
			<button type="submit">Ȯ��</button> 	
		</div>
	</form>
		
	<h2> 3. �� �ζ��� </h2>
	<form class="form-check-inline">
		<div class="form-group">
			<label>�̸�</label>
			<input class="form-control" type="text" placeholder="�̸�">
		</div>
		<div class="form-group">
			<label>�̸���</label>
			<input class="form-control" type="email" placeholder="�̸���">
		</div>
		<div class="form-group">
			<button type="submit">Ȯ��</button> 	
		</div>
	</form>
	
</body>
</html>