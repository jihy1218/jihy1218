<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#productul{width: 250px;
			border: solid 1px #dddddd;
			list-style-type: none;
			margin: 25px;
			padding: 5px;
		}		
		.row1 img{width: 200px;}		
		li{
			padding: 5px;
			
		}
		.row2 {font-weight: bold;}
		.row3 {font-weight: bold; font-size: 10px;}
		.row4 {font-size: 9px;}
		.row5 {font-size: 9px;}
		span{color: orange; font-weight: bold;}
	</style>
	
</head>
<body>
	<%@include file="12.�޴���.jsp" %>
	<h3>��ǰ �Ұ�</h3>
		<ul id="productul">
			<li class="row1"><img src="���ξ���.jpg"></li>
			<li class="row2">�����̾� ���ξ��� �ٱ��ϼ�Ʈ ... </li>
			<li class="row3">25,000��</li>
			<li class="row4">�Ǹ��ڰ� ����Ű�� ���ξ����Դϴ�. ������, �����, ������, ���� �� Ư���� ���� ��ŭ�� ���ξ��ð� �Բ�...</li>
			<li class="row5">���� <span>130</span> �� ���� <span>4.9/5</span>  </li>
		
		
		
		</ul>
		
</body>
</html>