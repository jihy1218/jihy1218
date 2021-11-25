<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.부트스트랩시작.jsp" %>
	<h2>1.부트스트랩 미적용 테이블</h2>
	<table>
		<thead>
			<tr>	
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>2</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>3</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
		</tbody>	
	</table>
	<h2>2.부트스트랩 적용 테이블</h2>
	<table class="table">
		<thead>
			<tr>	
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>2</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>3</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
		</tbody>	
	</table>
	<h2>3.부트스트랩 적용 테이블[table table-striped]</h2>	
	<table class="table table-striped">
		<thead>
			<tr>	
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>2</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>3</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
		</tbody>	
	</table>
	<h2>4.부트스트랩 적용 테이블 [table table-bordered]</h2>	
	<table class="table table-bordered">
		<thead>
			<tr>	
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>2</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr>
				<td>3</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
		</tbody>	
	</table>
	<h2>5.부트스트랩 적용 테이블 [table table-active]</h2>	
	<table class="table">
		<thead>
			<tr class="table-active">	
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
			</tr>
		</thead>
		<tbody>
			<tr class="table-success">
				<td>1</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr class="table-warning">
				<td>2</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
			<tr class="table-danger">
				<td>3</td><td>테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
			</tr>
		</tbody>	
	</table>
	<h2>6.부트스트랩 적용 테이블 [table table-responsive]</h2>	
	<div class="table-responsive">
		<table class="table ">
			<thead>
				<tr class="table-active">	
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-success">
					<td>1</td><td>테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
				</tr>
				<tr class="table-warning">
					<td>2</td><td>테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
				</tr>
				<tr class="table-danger">
					<td>3</td><td>테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트테이블테스트</td><td>곽두팔</td>
				</tr>
			</tbody>	
		</table>
	</div>
	
	
</body>
</html>