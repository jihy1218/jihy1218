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
			<h3>ȸ�������� �����մϴ�!</h3>
			<br>
			<div class="signup_item">
				<h5>���̵�<span class="text-danger">*</span></h5>
				<input class="form-control" type="text" placeholder="���̵� �Է��ϼ���">
			</div>
			<div class="signup_item">
				<h5>�̸���<span class="text-danger">*</span></h5>
				<input class="form-control" type="email" placeholder="�̸����� �Է��ϼ���">
			</div>
			<div class="signup_item">
				<h5>��й�ȣ<span class="text-danger">*</span></h5>
				<input class="form-control" type="password" placeholder="��й�ȣ�� �Է��ϼ���">
				<input class="form-control" type="password" placeholder="��й�ȣ�� �ѹ��� �Է��ϼ���">
			</div>
			<div class="signup_item">
				<h5>�޴��� ��ȣ<span class="text-danger">*</span></h5>
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
						<button class="btn btn-info">������û</button>
					</div>
				</div>
			</div>
			<div class="signup_item">
				<h5>�������</h5>
				<div class="row">
					<div class="col-md-6">
						<input class="form-control" type="date">
					</div>
				</div>
				<p>��������� �Է��Ͻø�<span class="text-primary">ȸ������ ������ ����</span>�ص帳�ϴ�.
			</div>
			<div class="signup_item">
				<div class="row">
					<div class="col-md-1 mt-1">
						<input class="form-control" type="checkbox">
					</div>
					<!-- <div class="col-md-3">
						<span>��� ��� ����</span>
					</div> -->
				</div>		
			</div>
		</div>
	</div>
	<%@include file="3.footer.jsp" %>
</body>
</html>