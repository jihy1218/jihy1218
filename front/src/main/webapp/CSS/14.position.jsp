<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#a ,#b, #c, #d, #e, #f, #g, #h, #i, #g2, #h2, #i2, #j, #k, #l{  
			width: 100px;
			height: 60px;
			background-color: yellow;
			border: solid 1px black;
		}
		#b {
			position: relative;		/* 상대 위치(기준: 현div 시작점 위치) */
			left: 60px; top: 30px;
		}
		#e {
			position: absolute;		/* 절대 위치(기준: body 시작점 위치) */
			left: 80px; top: 50px;
		}
		/*  주석  */
		#parent {
			width: 350px;
			height: 200px;
			border: solid 1px red;
			position: relative;				/* 현 div 기준으로 */ 
		}	
		#h {
			position: absolute;
			left: 30px; top: 30px;
		
		}
		#parent2 {
			width: 350px;
			height: 200px;
			border: solid 1px red;
		}	
		#h2 {
			position: absolute;
			left: 30px; top: 30px;
		
		}
		#k {
			position: fixed;
			top:30px; left: 200px;
		}
	</style>
</head>
<body>
	<h3>상대 위치 지정</h3>
	<div id="a">요소A</div>
	<div id="b">요소B 상대위치</div>
	<div id="c">요소C</div>
	
	<h3>절대 위치 지정</h3>
	<div id="d">요소D</div>
	<div id="e">요소E : 절대위치</div>
	<div id="f">요소F</div>
	
	<h3>[부모: relative 있을 경우] 절대위치 지정</h3>
	<div id="parent">
		<div id="g">요소G</div>
		<div id="h">요소H : 절대위치</div>
		<div id="i">요소I</div>
	</div>
	
	<h3>[부모: relative 없을 경우] 절대위치 지정</h3>
	<div id="parent2">
		<div id="g2">요소G</div>
		<div id="h2">요소H : 절대위치</div>
		<div id="i2">요소I</div>
	</div>
	
	<h3>고정 위치</h3> <!-- top으로 올리기할때 쓰면 좋을듯 -->
	<div id="j">요소J</div>
	<div id="k">요소K : 위치 고정</div>
	<div id="l">요소L</div>
</body>
</html>