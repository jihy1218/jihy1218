<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		*{border: solid 1px skyblue; box-sizing: border-box; padding: 10px;}
		row { margin-bottom: 4px; margin-top: 4px;}
	</style>
</head>
<body>
	<%@include file="1.��Ʈ��Ʈ������.jsp" %>
	<h1>�ڽ��� : container</h1>
	<h1>�׸���</h1>
		<ul>
			<li> 768px ���� : .col-xs- </li>
			<li> 768px �̻� : .col-sm- </li>
			<li> 992px ���� : .col-md- </li>
			<li> 1200px ���� : .col-lg- </li>
		</ul>
	<div class="container"> 	<!-- �̸� ������� container : �ڽ��� Ŭ���� -->
		<div class="row">
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-2</div>
			<div class="col-md-1">.col-md-3</div>
			<div class="col-md-1">.col-md-4</div>
			<div class="col-md-1">.col-md-5</div>
			<div class="col-md-1">.col-md-6</div>
			<div class="col-md-1">.col-md-7</div>
			<div class="col-md-1">.col-md-8</div>
			<div class="col-md-1">.col-md-9</div>
			<div class="col-md-1">.col-md-10</div>
			<div class="col-md-1">.col-md-11</div>
			<div class="col-md-1">.col-md-12</div>
		</div>
		<div>
			<div class="row">	<!-- 8 : 4 -->
				<div class="col-md-8">.col-md-8</div>
				<div class="col-md-4">.col-md-4</div>
			</div>
		</div>
		<div>
			<div class="row">	<!-- 4 : 4 : 4 -->
				<div class="col-md-4">.col-md-4</div>
				<div class="col-md-4">.col-md-4</div>
				<div class="col-md-4">.col-md-4</div>
			</div>
		</div>
		<div>
			<div class="row">	<!-- 6 : 6 -->
				<div class="col-md-6">.col-md-6</div>
				<div class="col-md-6">.col-md-6</div>
			</div>
		</div>
	</div>
	<br><br><br>
	<h3>���� �׸���</h3>
	<!-- ���� �׸��� -->
	<div class="container">
		<div class="row">
			<div class="col-md-8">.col-md-8
				<div class="row">
					<div class="col-md-4" style="background-color: #eeeeee;">���� 12 �׸����� 4��</div>
					<div class="col-md-8" style="background-color: #eeeeee;">���� 12 �׸����� 8��</div>
				</div>
			</div>
			<div class="col-md-4">.col-md-4
				<div class="row">
					<div class="col-md-6" style="background-color: orange;">���� 12 �׸����� 6��</div>
					<div class="col-md-6" style="background-color: orange;">���� 12 �׸����� 6��</div>
				</div>
			</div>
		</div>
	</div>
	<h2>offset ��ġ ���</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-5">col-md-5</div>
			<div class="col-md-5 offset-2">col-md-5</div>
		</div>
		<div class="row">
			<div class="col-md-4">col-md-4</div>
			<div class="col-md-7 offset-1">col-md-7</div>
		</div>
	</div>
	<h2> �׸��� �����ϰų� �Ѿ�����</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-5">col-md-5</div>	
			<div class="col-md-8">col-md-8</div>	<!-- 12�̻��� �Ǹ� �Ʒ��� ������ -->
		</div>
		<div class="row">
			<div class="col-md-4">col-md-4</div>
			<div class="col-md-7">col-md-7</div>
		</div>
	</div>
</body>
</html>
