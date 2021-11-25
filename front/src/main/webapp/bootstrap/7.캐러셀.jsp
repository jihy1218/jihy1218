<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		.carousel-item {
			width: 1200px;	/* !important > id > class > 태그 > * */
			height: 990px;
		}
	</style>
</head>
<body>

	<%@include file="1.부트스트랩시작.jsp" %>
	
	<h3> 이미지 슬라이드 [케라셀] </h3>
	<div class="contanier" >
		<div id="carouselcontents" class="carousel slide" data-ride="carousel" data-interval="5000">
			<!-- carousel slide : 이미지 슬라이드 data-interval : 1/1000초 -->
			
			<ol class="carousel-indicators">		<!-- carousel-indicators : 현재 슬라이드 위치 -->
				<li data-target="carouselcontents" data-slide-to="0" class="active"></li>
				<li data-target="carouselcontents" data-slide-to="1"></li>
				<li data-target="carouselcontents" data-slide-to="2"></li>
			</ol>
			<div class="carousel-item active">
				<img src="멍멍이2.jpg" alt="첫번째 슬라이드">
				<div class="carousel-caption">
					<h4>강아지</h4>
					<p>안녕하세요 멈멈이입니다.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="멍멍이2.jpg" alt="두번째 슬라이드">
			</div>
			<div class="carousel-item">
				<img src="멍멍이2.jpg" alt="세번째 슬라이드">
			</div>
			<!-- 버튼 -->
			<a class="carousel-control-prev" href="#carouselcontents" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>	<!-- 아이콘 -->
			</a>
			<a class="carousel-control-next" href="#carouselcontents" data-slide="next">
				<span class="carousel-control-next-icon"></span>	<!-- 아이콘 -->
			</a>
		</div>
	</div>
</body>
</html>