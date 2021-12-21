<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h3>주문그래프</h3>
				<canvas id="mychart"></canvas>
			</div>	
			<div class="col-md-6">
				<h3>제품별 총판매량</h3>
				<canvas id="productchart"></canvas>
			</div>	
		</div>
		<div class="row">
			<div class="col-md-6">
				<h3>제품별 판매 추이</h3>
				<select class="form-control" onchange="pchange();" id="pselect">
					<option>---제품명 선택---</option>
					<%ArrayList<Product> products = ProductDao.getproductDao().productlist(null, null); %>
					<%for(Product product : products) { %>
					<option value="<%=product.getP_num()%>"><%=product.getP_name() %></option>
					<%} %>
				</select>
				<canvas id="datechart"></canvas>
			</div>	
			<div class="col-md-6">
				<h3>제품별판매량</h3>
				<canvas id="productchart"></canvas>
			</div>	
		</div>
	</div>
</body>
</html>