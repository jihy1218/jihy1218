<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		li{ list-style-type: none;}
		.item {
			border-bottom: solid 2px  #5b6e8c;
		}
		.item a{ color :#5b6e8c;
			
		}
	</style>
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
		<div class="row item">
			<div class="col-md-4 img1">
				<ul>
					<li><img src="img/main_bmw.jpg"></li>
					<li><h3><a href="#">Driving Center</a></h3></li>
					<li>BMW 드라이빙 센터 예약</li>
				</ul>
			</div>
			<div class="col-md-4">
				<ul>
					<li><img src="img/main_bmw2.jpg"></li>
					<li><h3><a href="#">BWM ONLINE SHOP</a></h3></li>
					<li>BMW 차량 구매</li>
				</ul>
			</div>
			<div class="col-md-4">
				<ul>
					<li><img src="img/main_bmw3.jpg"></li>
					<li><h3><a href="#">BMW REPAIR SHOP</a></h3></li>
					<li>BMW 수리 센터 예약</li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>