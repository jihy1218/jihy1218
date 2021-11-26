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
	<!-- 게시판 start -->	
	
	<div class="container my-5">
		<h3>QnA</h3>
		<div class="col-md-5 offset-7 input-group ">
			<select class="custom-select">	<!-- 검색 키워드 -->
				<option>키워드</option>
				<option>번호</option>
				<option>제목</option>
				<option>작성자</option>
			</select>
			<input type="text" class="form-control"><button class="btn btn-success">검색</button>
		</div>
		<p>질문 게시판</p>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th><th>제목</th><th>작성자</th><th>답변여부</th><th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<tr><td>1</td><td>환불요청입니다.</td><td>곽두팔</td><td>답변대기중</td><td>2021-11-26</td></tr>
					<tr><td>2</td><td>교환요청입니다.</td><td>조두식</td><td>답변대기중</td><td>2021-11-24</td></tr>
					<tr><td>3</td><td>반품요청입니다.</td><td>오른팔</td><td>답변완료</td><td>2021-11-23</td></tr>
					<tr><td>4</td><td>교환요청입니다.</td><td>김장군</td><td>답변완료</td><td>2021-11-22</td></tr>
					<tr><td>5</td><td>환불요청입니다~</td><td>구두쇠</td><td>답변완료</td><td>2021-11-21</td></tr>
					<tr><td>6</td><td>반품요청입니다!!!</td><td>황기룡</td><td>답변완료</td><td>2021-11-20</td></tr>
				</tbody>
			</table>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-4 my-4">
					<ul class="pagination">	<!-- 게시판 페이지 번호 -->
						<li class="page-item"><a class="page-link">&laquo</a></li>
						<li class="page-item"><a class="page-link">1</a></li>
						<li class="page-item"><a class="page-link">2</a></li>
						<li class="page-item"><a class="page-link">3</a></li>
						<li class="page-item"><a class="page-link">4</a></li>
						<li class="page-item"><a class="page-link">5</a></li>
						<li class="page-item"><a class="page-link">&raquo</a></li>
					</ul>
				</div>
				<div class="col-md-1 offset-3 my-4">
					<button class="btn btn-info">문의하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 게시판 end -->
	<br><br><br><br><br>
	<%@include file="3.footer.jsp" %>
</body>
</html>