<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		*{border: solid 1px red;}
		header {
			height: 150px; 
		}
		.box {
			width:1100px; margin: 0 auto;  
		}
		#main_img {
			height: 200px;
		}
		aside {width: 200px; float: left; height: 300px; }
		#main {width: 840px; float: right; height: 300px;  }
		footer { clear: both; height: 150px;}
	</style>
</head>
<body>
	<%@include file="2.header.jsp" %>
	<section id="main_img">
		�����̹���
	</section>
	<div class="box">
		<aside>
			���ʸ޴�
		</aside>
		<div id="main">
			<div>
			�˸�
			</div>
			<div>
			�Խ���
			</div>
			<div>
			���� Ŭ����
			</div>
		</div>
	</div>
	<footer class="box">Ǫ��
		<div>
			<ul>
				<li>The ����ŷ �Ұ�</li>
				<li>��������ó����ħ</li>
				<li>���۱� ����</li>
				<li>�̿� �ȳ�</li>
			</ul>
		</div>
		<div>
			<div>������ȭ
			</div>
			<div>The����ŷ
			</div>
			<div>�Ա�����
			</div>
		</div>
	</footer>
</body>
</html>