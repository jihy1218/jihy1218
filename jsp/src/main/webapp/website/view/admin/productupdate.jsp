<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		Product product = ProductDao.getproductDao().getproduct(p_num);
		product.setP_contents(product.getP_contents().replaceAll("<br>","\n"));
	%>
	<%@include file="../header.jsp" %>
		<div class="container">
			<form style="margin: 0 auto" action="../../controller/productupdatecontroller.jsp" method="post" enctype="multipart/form-data">
				<input type="hidden" name="p_num" value="<%=p_num %>">
				<input type="hidden" name="oldimg" value="<%=product.getP_img()%>">
				차이름  <input class="col-md-3 form-control" type="text" name="p_name" value="<%=product.getP_name() %>">
				제품가격 <input class="col-md-3 form-control" type="text" name="p_price" value="<%=product.getP_price() %>">
				배기량 <input class="col-md-3 form-control" type="text" name="p_cc" value="<%=product.getP_cc() %>">
				연료타입 <input class="col-md-3 form-control" type="text" name="p_fueltype" value="<%=product.getP_fueltype() %>">
				차량이미지 <input class="col-md-3 form-control" type="file" name="p_img"><%=product.getP_img() %> <br>
				재고 <input class="col-md-3 form-control" type="text" name="p_stock" value="<%=product.getP_stock() %>">
				카테고리 <select class="col-md-3 custom-select" name="p_category">
						<option value="SUV">SUV</option>
						<option value="SEDAN">세단</option>
						<option value="M">M</option>
						</select><br>
				상세설명 <textarea class="col-md-3 form-control" rows="" cols="" name="p_contents"><%=product.getP_contents() %></textarea><br>
				<input class="btn btn-info " type="submit" value="수정하기"><br>
			</form>
		</div>
</body>
</html>