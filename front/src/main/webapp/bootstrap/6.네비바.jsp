<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.��Ʈ��Ʈ������.jsp" %>	<!-- ��Ʈ��Ʈ�� css, js -->
	
	<div class="container">	<!-- �ڽ��� -->
		<nav class="navbar navbar-expand-lg navbar-light bg-primary fixed-top "> 	<!-- navbar : �޴� �ڽ��� --> <!-- navbar-expand-lg : 1200px �̻� �϶� -->
			<a href="#" class="navbar-brand">�ΰ�</a>		<!-- navbar-brand : �ΰ�[ ���ϰ� ] -->
			
			<!-- �޴� ������°� -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarcontents" aria-controls="navbarcontents" aria-expanded="false" aria-label="Toggle navi">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarcontents">	<!-- ���θ޴� -->		
				<ul class="navbar-nav">
					<li class="nav-item active"><a href="#" class="nav-link">�޴�1</a></li>		<!-- nav-item: �޴� ������ -->
					<li class="nav-item"><a href="#" class="nav-link">�޴�2</a></li>		<!-- nav-link: ������ ��ũ -->
					<li class="nav-item"><a href="#" class="nav-link">�޴�3</a></li>
					
					<li class="nav-item dropdown">		<!-- �޴��ڽ��� �޴� -->
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown"  aria-haspopup="true" aria-expanded="false" >
						����ٿ�
						</a>
						<div class="dropdown-menu">						<!-- ����ٿ�޴� -->
							<a class="dropdown-item">����ٿ� �޴�1</a>		<!-- ����ٿ� ������ -->
							<a class="dropdown-item">����ٿ� �޴�2</a>
							<a class="dropdown-item">����ٿ� �޴�3</a>
							<a class="dropdown-item">����ٿ� �޴�4</a>	
						</div>
					</li>
				</ul>
				<form>	<!-- �����ʸ޴� -->	
					<div class="form-inline">
						<input type="text" class="form-control" placeholder="�˻���">
						<button type="submit" class="btn btn-info">�˻�</button>
					</div>			
				</form>	
			</div>
		</nav>
	</div>
</body>
</html>