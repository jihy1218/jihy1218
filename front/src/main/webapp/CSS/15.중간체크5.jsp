<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		h2 { text-align: center;}
		#box {
			 background-color: green;
			 width: 700px;
			 height: 550px;
			 position: relative;		/* ���� ��ҿ� relative */
			 margin: 0 auto;
		}
		#box div{ 
			background-color: yellow;
			width: 100px;
			height: 70px;
			border-radius: 15px;
			box-shadow: 3px 3px 10px white; /* �׸��� */
			text-align: center;
			padding-top: 10px;
			position: absolute;     	 
		}
		
		#box1	{
			left: 300px;
			top: 90px;   		
		}
		#box2	{
			left: 150px;
			top: 140px;   		
		}
		#box3	{
			left: 450px;
			top: 140px;   		
		}
		#box4	{
			left: 150px;
			top: 270px;      		
		}
		#box5 {
			left: 450px;
			top: 270px;   		
		}
		#box6	{
			left: 300px;
			top: 320px;   		
		}
		a{
			text-decoration: none; font-weight: bold; color: black; font-size: 18px; 
		
		}
	</style>
</head>
<body>
	<h2>���α׷��� ����</h2>
	<div id="box">
		<div id="box1">
			<a href="#">HTML<br>����</a>
		</div>
		<div id="box2">
			<a href="#">CSS<br>����</a>
		</div>
		<div id="box3">
			<a href="#">���̽�<br>����</a>
		</div>
		<div id="box4">
			<a href="#">C#<br>����</a>
		</div>
		<div id="box5">
			<a href="#">PHP<br>����</a>
		</div>
		<div id="box6">
			<a href="#">�ڹ�<br>����</a>
		</div>
		 
	</div>
</body>
</html>