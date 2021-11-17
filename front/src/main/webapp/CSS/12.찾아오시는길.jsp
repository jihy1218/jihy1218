<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		div.route{
			background-image: url("패턴이미지.jpg"); width: 600px; height: 700px; margin: 0 auto; padding: 10px;
		}
		h1{ color: #ffd85a; text-align: center; text-shadow: 3px 3px 5px #0b173a; font-size: 45px; margin-top: 10px;}
		h3{ color: #fed054; text-align: center; font-size: 30px;}
		.p1{ color: white; text-align: center; font-size: 20px;}
		.img1{ text-align: center;} 
		#routeul li{color: #ffd85a; padding-left: 30px;}
		.img{ width: 400px; margin: 0 auto;} 
		div .button { text-align:  center; margin-bottom: 10px;} 
		.buttons {background-color: #ffd85a; padding: 10px 100px; font-size: 15px; color : #517197; } 
	</style>
</head> 
<body>
	<%@include file="12.메뉴바.jsp" %>
	<form>
		<div class="route">
			<h1>스페셜 드레스 샵</h1>
			<h3>Special Dress Shop</h3>
			<p class="p1">생일,결혼기념일,만난 기념일 등 특별한 날에 스페셜 드레<br class="p1">스를 입고 포토존에서 멋진 추억의 사진을 남겨보세요.</p>
			<div class="img">
				<img class="img1" src="happybaby.jpg">
				<ul id="routeul">
					<li>기간 : 매주 토/일요일<br>13:00 ~ 마감시간 전까지</li>
					<li>장소 : 기념품 판매점 옆 스페셜 드레스<br>※ 키즈, 커플 드레스도 입고 되었어요!</li>
				</ul> 
				<div class="button">
					<button class="buttons">이용요금 및 이용방법</button>
				</div>	
			</div>
			<br>
		</div>
	</form>
	
</body>
</html>