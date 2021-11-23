<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		aside {width: 220px; float: left;} 
		#main {width: 840px; float: right;}
		#main1 {
			width: 400px;
			float: left;
		}
		#main1 .title1 {
			border-bottom: solid 2px black;
			padding-bottom: 8px; 
		}
		#main1 .boardul {
			margin-top: 30px;
		}
		#main1 .items {
			height: 35px;	
			list-style-type: none;
		}
		#main1 .items .subject { float: left;}
		#main1 .items .date { float: right;}  
		#main1 .title2 {
			border-bottom: solid 2px black;
			padding-bottom: 8px; 
			margin-top: 30px;
		}
		#main2 {
			width: 400px;
			float:right;
		}
		#main2 .title3 {
			border-bottom: solid 2px black;
			padding-bottom: 8px; 
		}
		#main2 .items {
			width: 195px;  
			float:right;
			margin-top: 30px;
			list-style-type: none;
		}
		#main2 .subject {
			margin-top: 10px; font-weight: bold;  
		
		}
	
	</style>

</head>
<body>
	<div class="box">
		<%@include file="4.sidebar.jsp" %>
		<div id="main">
			<div id="main1">
				<h3 class="title1">알림</h3>
					<ul class="boardul">
						<li class="items">
							<div class="subject"> 쿠킹클래스 연기합니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject"> 쿠킹클래스 연기합니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject"> 쿠킹클래스 연기합니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject"> 쿠킹클래스 연기합니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject"> 쿠킹클래스 연기합니다.</div>
							<div class="date"> 09.30 </div>
						</li>
					</ul>
					<h3 class="title2">게시판</h3>
					<ul class="boardul">
						<li class="items">
							<div class="subject">안녕하세요 반갑습니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject">안녕하세요 반갑습니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject">안녕하세요 반갑습니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject">안녕하세요 반갑습니다.</div>
							<div class="date"> 09.30 </div>
						</li>
						<li class="items">
							<div class="subject">안녕하세요 반갑습니다.</div>
							<div class="date"> 09.30 </div>
						</li>
					</ul>		
			</div>
			
			<div id="main2">
				<h3 class="title3">제빵 클래스</h3>
					<ul class="items">
						<li><img alt="" src="img/bread1.png"></li>
						<li class="subject">도너트 만들기[3]</li>
						<li class="date">21.09.30</li>
					</ul>
					<ul class="items">
						<li><img alt="" src="img/bread2.png"></li>
						<li class="subject">도너트 만들기[3]</li>
						<li class="date">21.09.30</li>
					</ul>
					<ul class="items">
						<li><img alt="" src="img/bread3.png"></li>
						<li class="subject">도너트 만들기[3]</li>
						<li class="date">21.09.30</li>
					</ul>
					<ul class="items">
						<li><img alt="" src="img/bread4.png"></li>
						<li class="subject">도너트 만들기[3]</li>
						<li class="date">21.09.30</li>
					</ul>		
			</div>
		</div>
	</div>
</body>
</html>