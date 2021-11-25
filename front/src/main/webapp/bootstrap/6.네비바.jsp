<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.부트스트랩시작.jsp" %>	<!-- 부트스트랩 css, js -->
	
	<div class="container">	<!-- 박스권 -->
		<nav class="navbar navbar-expand-lg navbar-light bg-primary fixed-top "> 	<!-- navbar : 메뉴 박스권 --> <!-- navbar-expand-lg : 1200px 이상 일때 -->
			<a href="#" class="navbar-brand">로고</a>		<!-- navbar-brand : 로고[ 진하게 ] -->
			
			<!-- 메뉴 사라지는거 -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarcontents" aria-controls="navbarcontents" aria-expanded="false" aria-label="Toggle navi">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarcontents">	<!-- 메인메뉴 -->		
				<ul class="navbar-nav">
					<li class="nav-item active"><a href="#" class="nav-link">메뉴1</a></li>		<!-- nav-item: 메뉴 아이템 -->
					<li class="nav-item"><a href="#" class="nav-link">메뉴2</a></li>		<!-- nav-link: 하이퍼 링크 -->
					<li class="nav-item"><a href="#" class="nav-link">메뉴3</a></li>
					
					<li class="nav-item dropdown">		<!-- 메뉴박스권 메뉴 -->
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown"  aria-haspopup="true" aria-expanded="false" >
						드랍다운
						</a>
						<div class="dropdown-menu">						<!-- 드랍다운메뉴 -->
							<a class="dropdown-item">드랍다운 메뉴1</a>		<!-- 드랍다운 아이템 -->
							<a class="dropdown-item">드랍다운 메뉴2</a>
							<a class="dropdown-item">드랍다운 메뉴3</a>
							<a class="dropdown-item">드랍다운 메뉴4</a>	
						</div>
					</li>
				</ul>
				<form>	<!-- 오른쪽메뉴 -->	
					<div class="form-inline">
						<input type="text" class="form-control" placeholder="검색어">
						<button type="submit" class="btn btn-info">검색</button>
					</div>			
				</form>	
			</div>
		</nav>
	</div>
</body>
</html>