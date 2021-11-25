<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		*{margin: 0; padding: 0; box-sizing: border-box;
		}
		#navbarcontents {font-size: 20px; font-weight: bold;} 
		.icon { 
			width:48px;
			height: 48px;
			float: right;
			margin-right :20px; 
			display: inline;
		}
		.logo {
		width:53px; height: 53px;		float: right;
		}
		
	</style>
</head>
<body>
	<%@include file="1.부트스트랩.jsp" %>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-primary">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarcontents"
					aria-controls="navbarcontents" aria-expanded="false" aria-label="Toggle navi">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarcontents">
				<ul class="navbar-nav">
					<li class="nav-item active"><a href="#" class="nav-link">Models</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Find&Buy</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Electromobility</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Services</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Discover</a></li>
				</ul>
			</div>
				<a href="#"><img class="icon" src="img/search.png"></a>
				<a href="#"><img class="icon" src="img/location.png"></a>
				<a href="#"><img class="icon" src="img/contact.png"></a>
				<a href="#"><img class="logo " src="img/bmw.jpg"></a>
		</nav>
	</div>
</body>
</html>