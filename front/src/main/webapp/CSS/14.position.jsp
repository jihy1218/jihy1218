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
			position: relative;		/* ��� ��ġ(����: ��div ������ ��ġ) */
			left: 60px; top: 30px;
		}
		#e {
			position: absolute;		/* ���� ��ġ(����: body ������ ��ġ) */
			left: 80px; top: 50px;
		}
		/*  �ּ�  */
		#parent {
			width: 350px;
			height: 200px;
			border: solid 1px red;
			position: relative;				/* �� div �������� */ 
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
	<h3>��� ��ġ ����</h3>
	<div id="a">���A</div>
	<div id="b">���B �����ġ</div>
	<div id="c">���C</div>
	
	<h3>���� ��ġ ����</h3>
	<div id="d">���D</div>
	<div id="e">���E : ������ġ</div>
	<div id="f">���F</div>
	
	<h3>[�θ�: relative ���� ���] ������ġ ����</h3>
	<div id="parent">
		<div id="g">���G</div>
		<div id="h">���H : ������ġ</div>
		<div id="i">���I</div>
	</div>
	
	<h3>[�θ�: relative ���� ���] ������ġ ����</h3>
	<div id="parent2">
		<div id="g2">���G</div>
		<div id="h2">���H : ������ġ</div>
		<div id="i2">���I</div>
	</div>
	
	<h3>���� ��ġ</h3> <!-- top���� �ø����Ҷ� ���� ������ -->
	<div id="j">���J</div>
	<div id="k">���K : ��ġ ����</div>
	<div id="l">���L</div>
</body>
</html>