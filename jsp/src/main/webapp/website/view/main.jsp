<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMW ONLINE SHOP</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<!-- 캐러셀 start -->
		<div class="carousel slide" data-ride="carousel" data-interval="2000">
			<ol class="carousel-indicators">	
				<li data-target="carouselcontents" data-slide-to="0" class="active"></li>
				<li data-target="carouselcontents" data-slide-to="1"></li>
				<li data-target="carouselcontents" data-slide-to="2"></li>
				<li data-target="carouselcontents" data-slide-to="3"></li>
				<li data-target="carouselcontents" data-slide-to="4"></li>
				<li data-target="carouselcontents" data-slide-to="5"></li>
				<li data-target="carouselcontents" data-slide-to="6"></li>
				<li data-target="carouselcontents" data-slide-to="7"></li>
				<li data-target="carouselcontents" data-slide-to="8"></li>
				<li data-target="carouselcontents" data-slide-to="9"></li>
				<li data-target="carouselcontents" data-slide-to="10"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active"> <img src="../img/m8.jpg"></div>
				<div class="carousel-item"> <img src="../img/3s.jpg"></div>
				<div class="carousel-item"> <img src="../img/5s.jpg"></div>
				<div class="carousel-item"> <img src="../img/6s.jpg"></div>
				<div class="carousel-item"> <img src="../img/i4.jpg"></div>
				<div class="carousel-item"> <img src="../img/4s.jpg"></div>
				<div class="carousel-item"> <img src="../img/7s.jpg"></div>
				<div class="carousel-item"> <img src="../img/m8c.jpg"></div>
				<div class="carousel-item"> <img src="../img/x4m.jpg"></div>
				<div class="carousel-item"> <img src="../img/x7.jpg"></div>
				<div class="carousel-item"> <img src="../img/8c.jpg"></div>
			</div>
		</div>
	<!-- 캐러셀 end -->
	
	<!-- 제품 목록 -->
	<%@include file="footer.jsp" %>
</body>
</html>