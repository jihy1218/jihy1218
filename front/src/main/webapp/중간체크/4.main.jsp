<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.부트스트랩.jsp" %>
	
	<div class="container">
		<div id="carouselcontents" class="carousel slide" data-ride="carousel" data-interval="2000">
			<ol class="carousel-indicators">
				<li data-target="carouselcontents" data-slide-to="0" class="active"></li>
				<li data-target="carouselcontents" data-slide-to="1"></li>
				<li data-target="carouselcontents" data-slide-to="2"></li>
			</ol>
			<div class="carousel-item active">
				<img src="img/bmw1.jpg">
			</div>
			<div class="carousel-item">
				<img src="img/bmw2.jpg">
			</div>
			<div class="carousel-item">
				<img src="img/bmw3.jpg">
			</div>
		</div>
			<a class="carousel-control-prev" href="#carouselcontents" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a>
			<a class="carousel-control-next" href="#carouselcontents" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				박스1
			</div>
			<div class="col-md-6">
				박스2
			</div>
		</div>
	
	</div>

</body>
</html>