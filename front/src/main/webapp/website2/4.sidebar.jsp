<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		aside {
			border: solid 3px #2c962c;    
		}
		aside .title1{
			padding: 10px;
			background-color: #0ca9a3;
			color : #f9fdfd;
		}
		.comment{
			padding:20px 10px;  
			line-height: 150%;
		}
		aside .search input{
			width: 150px;	
			height: 35px;
			border: solid 1px black;
		}
		aside .search button{
			margin-left: 5px;
			padding: 7px 11px;  
		}
		aside .title2 {
			margin-top: 20px; padding: 15px;	
			font-size: 15px;
			border-bottom: solid 1px #cccccc;
			border-top: solid 2px black;
		}
		aside .title3 {
			margin-top: 20px; padding: 15px;	
			font-size: 15px;
			border-top: solid 2px #33b7b2;
		}
		aside .list {
			margin: 20px 0; 
		}
		aside li {
			list-style-type: none; 
		}
		aside .list li {
			margin: 10px;
		}
	</style>
</head>
<body>
	<aside>
		<h3 class="title1">The ����ŷ</h3>
		<p class="comment">�ȳ��ϼ���. ��Ű�� �� ����� ������ �����ϰ� �����ϴ� �����Դϴ�.</p>
		<div class="search">
			<input type="text"><button>�˻�</button>
		</div>   
		<h3 class="title2">����ŷ/�丮</h3>
		<ul class="list">
			<li>��Ű �����</li>
			<li>�� �����</li>
			<li>��ī�� �����</li>
		</ul>
		<h3 class="title3">�ֱٴ��</h3>
		<ul class="list">
			<li>�ȳ��ϼ���.</li>
			<li>�ȳ��ϼ���.</li>
			<li>�ȳ��ϼ���.</li>
		</ul>
	</aside>
</body>
</html>