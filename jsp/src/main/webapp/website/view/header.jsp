<%@page import="dao.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- 부트스트랩 설정 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- css호출 -->
	<link rel="stylesheet" href="/jsp/website/css/main.css">
</head>
<body>
	<!-- jquery js -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<!-- 부트스트랩 js설정 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- js 호출 -->
	<script type="text/javascript" src="/jsp/website/js/main.js"></script>
	<!-- 다음 주소 api js호출 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	<!-- 다음 우편 -->
	<%
		Login login = (Login)session.getAttribute("login");
		String loginid = null;
		if(login != null) {loginid = login.getM_id();}
	%>
	<!-- 헤더 start -->
		<div class="fixed-top bg-white">	<!-- 상단 고정 , 배경 흰색 -->
			<div class="container">		
				<header class="py-3">	<!-- p : 안쪽 여백 // m: 바깥여백 // y : 위아래 // x: 좌우 -->
					<div class="row">
						<div class="col-md-4 offset-4 text-center">
							<a href="/jsp/website/view/main.jsp" class="header_logo">BMW ONLINE SHOP</a>
						</div>
						<div class="col-md-4 d-flex justify-content-end">
							<ul class="nav">
								<%
									if(loginid !=null) { // 로그인이 되어있는 경우
										if(loginid.equals("admin")) {	// 로그인 되어있으면서 관리자 이면
								%>			
										<li><a href="/jsp/website/view/admin/adminmain.jsp" class="header_menu">관리자</a></li>
								<%
										}
								%>
									<li> <span class="text-info"><%=loginid %>님</span></li>
									<li> <a href="/jsp/website/view/member/memberinfo.jsp" class="header_menu">회원정보</a> </li>
									<li> <a href="/jsp/website/controller/logoutcontroller.jsp" class="header_menu">로그아웃</a> </li>
								<%
									}else{ // 로그인이 안되어 있는 경우
								%>	
									<li><a href="/jsp/website/view/member/login.jsp" class="header_menu">로그인</a></li>
									<li><a href="/jsp/website/view/member/signup.jsp" class="header_menu">회원가입</a></li>
								<%
									}
								%>	
							</ul>
						</div>
					</div>
				</header>
				<nav class="navbar navbar-expand-lg navbar-light bg-white">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main_menu">
						<span class="navbar-toggler-icon"></span>
					</button>
						
					<div class="collapse navbar-collapse" id="main_menu">
						<ul class="navbar-nav col-md-12 justify-content-between">
							<li class="nav-item"><a href="" class="nav-link">신차</a></li>
							<li class="nav-item"><a href="" class="nav-link">베스트</a></li>
							<li class="nav-item"><a href="" class="nav-link">3시리즈</a></li>
							<li class="nav-item"><a href="" class="nav-link">5시리즈</a></li>
							<li class="nav-item"><a href="" class="nav-link">7시리즈</a></li>
							<li class="nav-item"><a href="" class="nav-link">이벤트</a></li>
							<li class="nav-item"><a href="" class="nav-link">구매후기</a></li>
							<li class="nav-item"><a href="/jsp/website/view/board/boardlist.jsp" class="nav-link">고객센터</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<!-- 헤더 end -->
		<br><br><br><br><br><br>
</body>
</html>