<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		*{text-align: center;}
		header {
			height: 100px;
			background-color: skyblue;
			padding: 10px;
			margin: 10px;
			border-radius: 15px; 
		}
		footer{border-top: solid 2px black;}
		ul {padding: 10px; background-color: gray; border-radius: 15px;}
		
	</style>
</head>
<body>
	<%@include file="1.��Ʈ��Ʈ������.jsp" %>
	<div class="container">
		<header>
			<h2>�׸��� ���̾ƿ�</h2>
		</header>
		<div class="row">
			<div class="col-md-2">
				<ul>
					<li>�޴�1</li>
					<li>�޴�2</li>
					<li>�޴�3</li>
					<li>�޴�4</li>
				</ul>
			</div>
			<div class="col-md-8">
				<div class="row">	<!-- inline -->
					<div class="col-md-5 offset-2">	<!-- ���� �� 12�׸����� 6 -->
						<p>������ �����ϰ� ���� �� ���δ�. ������Ű�� �̷��� �������� ���� ��Ŀ� ���� ������ �����Ƿ� �����Ӱ� ������ ����� �� �ִ�. ���� ������ ������ �ָ��� ª�� �������� ������ ���� �ʰ� �ۼ��� �� �ְ�, ������ �ʹ� ����� ������ �ſ� �������� �Ϻθ� ���� ������ �ٸ� ������ �����Ҽ��� �ְ�, �� �ݴ�� �Ҽ��� �ִ�.</p>
					</div>
					<div class="col-md-5">	<!-- ���� �� 12�׸����� 6 -->
						<p>���������� ���� ���̴� ������ ���ڸ� ���� ���ο� �δ� ����, �Ұ�. ���䰡 �ʹ� ������� �����ϰų� ������ �����ϴ� ������ ���� �� ���� ��, ����. �ι��̳� ��ǰ ���� ������� ������ �ִ� ��, ����. ����� �Ǿ��� ���̳� ��ǻ�� �ִٸ� ��ǻ�� ���. ���� �Ʒ��ʿ� ����ϰ� �Ҽ��� ������� �ִ� �����̳� ��Ÿ ���� ���� ���δ�.</p>
					</div>
				</div>
			</div>
			<div class="col-md-2">
				<ul>
					<li>�޴�1</li>
					<li>�޴�2</li>
					<li>�޴�3</li>
					<li>�޴�4</li>
				</ul>
			</div>
		</div>
		<footer>
			Ǫ��		
		</footer>
	</div>
</body>
</html>