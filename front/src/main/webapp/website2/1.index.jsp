<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		*{border: solid 1px red;}
		header {
			height: 150px; 
		}
		.box {
			width:1100px; margin: 0 auto;  
		}
		#main_img {
			height: 200px;
		}
		aside {width: 200px; float: left; height: 300px; }
		#main {width: 840px; float: right; height: 300px;  }
		footer { clear: both; height: 150px;}
	</style>
</head>
<body>
	<%@include file="2.header.jsp" %>
	<section id="main_img">
		메인이미지
	</section>
	<div class="box">
		<aside>
			왼쪽메뉴
		</aside>
		<div id="main">
			<div>
			알림
			</div>
			<div>
			게시판
			</div>
			<div>
			제빵 클래스
			</div>
		</div>
	</div>
	<footer class="box">푸터
		<div>
			<ul>
				<li>The 베이킹 소개</li>
				<li>개인정보처리방침</li>
				<li>저작권 정보</li>
				<li>이용 안내</li>
			</ul>
		</div>
		<div>
			<div>문의전화
			</div>
			<div>The베이킹
			</div>
			<div>입금정보
			</div>
		</div>
	</footer>
</body>
</html>