<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.header.jsp" %>
	
	<!-- 캐러셀 start -->
	<div id="carouselcontents"class="carousel slide" data-ride="carousel" data-interval="2000">
		<ol class="carousel-indicators">
			<li data-target="#carouselcontents" data-slide-to="0" class="active"></li>
			<li data-target="#carouselcontents" data-slide-to="1"></li>
			<li data-target="#carouselcontents" data-slide-to="2"></li>
			<li data-target="#carouselcontents" data-slide-to="3"></li>
		</ol>
		<!-- 캐러셀 이미지 넣기 -->
		<div class="carousel-inner">
			<div class="carousel-item active"><img src="img/img1.jpg"></div>
			<div class="carousel-item"><img src="img/img2.jpg"></div>
			<div class="carousel-item"><img src="img/img3.jpg"></div>
			<div class="carousel-item"><img src="img/img4.jpg"></div>
		</div>
		<!-- 캐러셀 이미지 이동버튼 -->
		<a class="carousel-control-prev" href="#carouselcontents" data-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</a>
		<a class="carousel-control-next" href="#carouselcontents" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
	<!-- 캐러셀 end -->
	<hr> <!-- 구분선 -->
	<br>
	<div class="container text-center">
		<h1>New ARRIVAL</h1>
		<p>신상품</p>
	</div>
	<!-- 아이템 : 제품 start -->
	<div class="container">		<!-- 박스권 -->
		<div class="row mb-2">			<!-- 가로 12 그리드 -->
			<div class="col-md-4 col-sm-6 my-3">
				<!-- 카드 -->
				<div class="card">
					<img class="card-top" src="img/item1.jpg">
					<div class="card-body">
						<p class="card-text">리얼 웰론 숏패딩</p>
						<hr>
						<p class="item p-1">
							프리미엄 웰론충전제를 빵빵하게 채워넣은 
							훌륭한 보온성의 트렌디한 패딩입니다. <br><br>
						<span class="price mr-2">75,000원</span>65,000원</p>
						<span class="badge badge-pill badge-warning">주문폭주</span>
						<span class="badge badge-pill badge-danger">품절임박</span>
					</div>`
				</div>
			</div>
			<div class="col-md-4 col-sm-6 my-3">
				<!-- 카드 -->
				<div class="card">
					<img class="card-top" src="img/item2.jpg">
					<div class="card-body">
						<p class="card-text">로망스 하찌 니트</p>
						<hr>
						<p class="item p-1">
							훌륭한 가성비의다양한 코디에 활용하기 좋은 하찌니트입니다 :-)<br><br>
						<span class="price mr-2">75,000원</span> 65,000원</p>
						<span class="badge badge-pill badge-warning">주문폭주</span>
						<span class="badge badge-pill badge-danger">품절임박</span>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 my-3">
				<!-- 카드 -->
				<div class="card">
					<img class="card-top" src="img/item3.jpg">
					<div class="card-body">
						<p class="card-text">띠아모 부클 니트 트레이닝 세트</p>
						<hr>
						<p class="item p-1">
							알파카소재가 혼용된오리지널 부클원사 니트입니다.트랜디한 스타일링이가능합니다.<br><br>
						<span class="price mr-2">75,000원</span> 65,000원</p>
						<span class="badge badge-pill badge-warning">주문폭주</span>
						<span class="badge badge-pill badge-danger">품절임박</span>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 my-3">
				<!-- 카드 -->
				<div class="card">
					<img class="card-top" src="img/item4.jpg">
					<div class="card-body">
						<p class="card-text">허리케인 기모 후드</p>
						<hr>
						<p class="item p-1">
							탄탄한 면소재에 따뜻한기모안감을 더한 영문나염 포인트의오버핏 후드티셔츠입니다.<br><br>
						<span class="price mr-2">75,000원</span> 65,000원</p>
						<span class="badge badge-pill badge-warning">주문폭주</span>
						<span class="badge badge-pill badge-danger">품절임박</span>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 my-3">
				<!-- 카드 -->
				<div class="card">
					<img class="card-top" src="img/item1.jpg">
					<div class="card-body">
						<p class="card-text">리얼 웰론 숏패딩</p>
						<hr>
						<p class="item p-1">
							프리미엄 웰론충전제를 빵빵하게 채워넣은 
							훌륭한 보온성의 트렌디한 패딩입니다. <br><br>
						<span class="price mr-2">75,000원</span> 65,000원</p>
						<span class="badge badge-pill badge-warning">주문폭주</span>
						<span class="badge badge-pill badge-danger">품절임박</span>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 my-3">
				<!-- 카드 -->
				<div class="card">
					<img class="card-top" src="img/item2.jpg">
					<div class="card-body">
						<p class="card-text">로망스 하찌 니트</p>
						<hr>
						<p class="item p-1">
							훌륭한 가성비의다양한 코디에 활용하기 좋은 하찌니트입니다 :-)<br><br>
						<span class="price mr-2">75,000원</span> 65,000원</p>
						<span class="badge badge-pill badge-warning">주문폭주</span>
						<span class="badge badge-pill badge-danger">품절임박</span>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<!-- 아이템 : 제품 end -->
	<%@include file="3.footer.jsp" %>
</body>
</html>