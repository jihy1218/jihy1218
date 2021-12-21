<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<%
		request.setCharacterEncoding("UTF-8");
		// 검색
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		ArrayList<Product> products = ProductDao.getproductDao().productlist(key , keyword);
	%>
		<div class="container">
			<form class="row" action="dashboard.jsp" method="get">
				<select class="custom-select col-md-2 offset-3" name="key">
					<option value="p_num">제품번호</option>
					<option value="p_name">차량명</option>
					<option value="p_category">카테고리</option>
					<option value="p_active">상태</option>
				</select>
				<input type="text" class="col-md-3 form-control ml-2" name="keyword">
				<input class="col-md-1 ml-5 " type="submit" value="검색">
			</form>
			<a href="productwrite.jsp"><button class="float-right btn btn-primary">제품등록</button></a>
			<a href="productchart.jsp"><button class="float-right btn btn-secondary">제품통계</button></a>
			<a href="api.jsp"><button class="float-right btn btn-danger">백신접종</button></a>
			<h3>제품등록</h3>
			<table class="table">
				<tr>
					<th>이미지</th>
					<th>제품번호</th><th>차량명</th><th>차량가격</th><th>카테고리</th><th>상태</th><th>엔진타입</th><th>등록일</th><th>비고</th>
				</tr>
				<%
					for(Product product : products) {
				%>
				<tr>
					<td width="100px"><img style="max-width : 100%" src="../../upload/<%=product.getP_img()%>"></td>
					<td><%=product.getP_num() %></td>
					<td><%=product.getP_name() %></td>
					<td><%=product.getprice(product.getP_price()) %></td>
					<td><%=product.getP_category() %></td>
					<td><%=product.getactive(product.getP_active()) %></td>
					<td><%=product.getP_fueltype() %></td>
					<td><%=product.getP_date() %></td>
					<td><a href="productupdate.jsp?p_num=<%=product.getP_num()%>"><button class="btn btn-success">수정</button></a>
						<a href="../../controller/productdeletecontroller.jsp?p_num=<%=product.getP_num()%>"><button class="btn btn-warning">삭제</button></a>
						<button id="activeupdate" onclick="activechange(<%=product.getP_num() %>);" class="btn btn-danger">상태변경</button></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
</body>
</html>