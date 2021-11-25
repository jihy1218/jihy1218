<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		*{text-align: center;}
		header {
			height: 100px;
			background-color: skyblue;
			padding: 10px;
			margin: 10px;
			border-radius: 15px; 
		}
		footer{border-top: solid 2px black;}
		ul {padding: 10px; background-color: gray; border-radius: 15px;}
		
	</style>
</head>
<body>
	<%@include file="1.부트스트랩시작.jsp" %>
	<div class="container">
		<header>
			<h2>그리드 레이아웃</h2>
		</header>
		<div class="row">
			<div class="col-md-2">
				<ul>
					<li>메뉴1</li>
					<li>메뉴2</li>
					<li>메뉴3</li>
					<li>메뉴4</li>
				</ul>
			</div>
			<div class="col-md-8">
				<div class="row">	<!-- inline -->
					<div class="col-md-5 offset-2">	<!-- 본문 내 12그리드중 6 -->
						<p>내용을 적절하게 나눌 때 쓰인다. 나무위키는 이러한 세부적인 서술 방식에 대한 제한이 없으므로 자유롭게 문단을 사용할 수 있다. 딱히 문단을 나누기 애매한 짧은 문서에는 문단을 넣지 않고 작성할 수 있고, 내용이 너무 길어져 문단이 매우 많아지면 일부를 하위 문서나 다른 문서로 분할할수도 있고, 그 반대로 할수도 있다.</p>
					</div>
					<div class="col-md-5">	<!-- 본문 내 12그리드중 6 -->
						<p>관습적으로 자주 쓰이는 문단을 꼽자면 문서 서두에 두는 개요, 소개. 개요가 너무 길어져서 분할하거나 본문을 시작하는 내용을 넣을 때 쓰는 상세, 설명. 인물이나 작품 등의 사람들의 생각을 넣는 평가, 비판. 논란이 되었던 일이나 사건사고가 있다면 사건사고나 논란. 문서 아래쪽에 잡다하고 소소한 내용들을 넣는 여담이나 기타 등이 자주 보인다.</p>
					</div>
				</div>
			</div>
			<div class="col-md-2">
				<ul>
					<li>메뉴1</li>
					<li>메뉴2</li>
					<li>메뉴3</li>
					<li>메뉴4</li>
				</ul>
			</div>
		</div>
		<footer>
			푸터		
		</footer>
	</div>
</body>
</html>