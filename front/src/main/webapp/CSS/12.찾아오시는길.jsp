<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		div.route{
			background-image: url("�����̹���.jpg"); width: 600px; height: 700px; margin: 0 auto; padding: 10px;
		}
		h1{ color: #ffd85a; text-align: center; text-shadow: 3px 3px 5px #0b173a; font-size: 45px; margin-top: 10px;}
		h3{ color: #fed054; text-align: center; font-size: 30px;}
		.p1{ color: white; text-align: center; font-size: 20px;}
		.img1{ text-align: center;} 
		#routeul li{color: #ffd85a; padding-left: 30px;}
		.img{ width: 400px; margin: 0 auto;} 
		div .button { text-align:  center; margin-bottom: 10px;} 
		.buttons {background-color: #ffd85a; padding: 10px 100px; font-size: 15px; color : #517197; } 
	</style>
</head> 
<body>
	<%@include file="12.�޴���.jsp" %>
	<form>
		<div class="route">
			<h1>����� �巹�� ��</h1>
			<h3>Special Dress Shop</h3>
			<p class="p1">����,��ȥ�����,���� ����� �� Ư���� ���� ����� �巹<br class="p1">���� �԰� ���������� ���� �߾��� ������ ���ܺ�����.</p>
			<div class="img">
				<img class="img1" src="happybaby.jpg">
				<ul id="routeul">
					<li>�Ⱓ : ���� ��/�Ͽ���<br>13:00 ~ �����ð� ������</li>
					<li>��� : ���ǰ �Ǹ��� �� ����� �巹��<br>�� Ű��, Ŀ�� �巹���� �԰� �Ǿ����!</li>
				</ul> 
				<div class="button">
					<button class="buttons">�̿��� �� �̿���</button>
				</div>	
			</div>
			<br>
		</div>
	</form>
	
</body>
</html>