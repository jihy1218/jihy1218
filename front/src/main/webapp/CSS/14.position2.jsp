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
			 position: relative;		/* 상위 요소에 relative */
			 margin: 0 auto;
		}
		#box div{ 
			background-color: yellow;
			width: 100px;
			height: 70px;
			border-radius: 15px;
			box-shadow: 3px 3px 10px white; /* 그림자 */
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
	<h2>프로그래밍 강좌</h2>
	<div id="box">
		<div id="box1">
			<a href="#">HTML<br>강좌</a>
		</div>
		<div id="box2">
			<a href="#">CSS<br>강좌</a>
		</div>
		<div id="box3">
			<a href="#">파이썬<br>강좌</a>
		</div>
		<div id="box4">
			<a href="#">C#<br>강좌</a>
		</div>
		<div id="box5">
			<a href="#">PHP<br>강좌</a>
		</div>
		<div id="box6">
			<a href="#">자바<br>강좌</a>
		</div>
		 
	</div>
</body>
</html>