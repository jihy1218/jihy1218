<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="dao.Login"%>
<%@page import="dto.Cart"%>
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
		String sname = "cart"+login.getM_id();
		ArrayList<Cart> carts = (ArrayList<Cart>)session.getAttribute(sname);
	%>
	<div class="container">
		<h3 class="text-center"><%=login.getM_id() %>님의 장바구니</h3>
		<table class="table table-hover text-center">
			<tr class="table-success">
				<th>이미지</th><th>차량정보</th><th>수량</th><th>가격</th><th>비고</th>
			</tr>
			<%
				if(carts==null) {%>
				<tr>
					<td colspan="5">장바구니에 담긴 차량이 없습니다.</td>
				<tr>
			<%
				}else{
				for(Cart cart : carts) {
				Product product = ProductDao.getproductDao().getproducts(cart.getP_num());	
			%>
			<tr>
				<td><img style="max-width: 100%;" width="50%" src="../../upload/<%=product.getP_img()%>"></td>
				<td class="align-middle">
					<div>
						제품명 : <%=product.getP_name()%>	
					</div>
					<div>
						연료타입 : <%=cart.getP_type()%>	
					</div>
				</td>
				<td class="row" style="padding-top: 40px;">
					<div class="col-md-9 offset-2">
						<div>
							<button class="btn btn-success d-inline" onclick="pchange('p',<%=product.getP_stock()%>,<%=(product.getP_price())%>);">+</button>
							<input class="form-control col-md-6 d-inline" name="p_count" type="text" id="p_count" value="<%=cart.getP_count() %>" onchange="pchange('s',<%=product.getP_stock()%>,<%=product.getP_price()%>);">
							<button class="btn btn-danger d-inline" onclick="pchange('m',<%=product.getP_stock()%>,<%=product.getP_price()%>);">-</button>
						</div>
					</div>
				</td>
				<td>
					<div id="total" style="padding-top: 30px;">
						<%=product.getprice(cart.getP_count()*product.getP_price()) %>원
					</div>
				</td>
				<td class="align-middle" ><button onclick="cartdelete('in','<%=cart.getP_num()%>','<%=cart.getP_type()%>');" class="btn btn-danger"> X </button></td>
			</tr>
			<%}}%>
		</table>
		<hr>
			<button onclick="cartdelete('all' , '0', '0');" class="btn btn-info col-md-1 offset-11">모두삭제</button>
		<br>
		<br>
		<br>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>