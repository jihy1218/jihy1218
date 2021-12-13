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
		Product product = ProductDao.getproductDao().getproducts(p_num);
	%>
	<%@include file="../header.jsp" %>
	<div class="container">
	<br>	
		<div class="row">
			<div class="col-md-6">
				<img src="../../upload/<%=product.getP_img()%>" style="width:100%">
			</div>
			<div class="col-md-6">
				<p>BMW
				<h4><%=product.getP_name() %></h4>
				<hr> <!-- 줄치기 -->
				<div class="row">
					<div class="col-md-3"> 구매 혜택 </div>
					<div class="col-md-9"> 포인트 0.5% 제공 </div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-3"> 탁송 정보 </div>
					<div class="col-md-9"> 카마스터에게 문의 </div>
				</div>
				<hr> <!-- 줄치기 -->
				<div class="row">
					<div class="col-md-3"> 가격 </div>
					<div class="col-md-9"> <%=product.getprice(product.getP_price()) %> </div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-6">배기량 : <%=product.getP_cc() %></div>
					<div class="col-md-6">엔진타입 : <%=product.getP_fueltype() %> </div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-3"> 수량 </div>
					<div class="col-md-9">
						<div>
							<button class="btn btn-success d-inline" onclick="pchange('p',<%=product.getP_stock()%>,<%=(product.getP_price())%>);">+</button>
							<input class="form-control col-md-6 d-inline" type="text" id="p_count" value="1" onchange="pchange('s',<%=product.getP_stock()%>,<%=product.getP_price()%>);">
							<button class="btn btn-danger d-inline" onclick="pchange('m',<%=product.getP_stock()%>,<%=product.getP_price()%>);">-</button>
						</div>
					</div>
				</div>
				<hr>
				<div class="row my-2">
					<div class="col-md-3"> 총 결제 금액 </div>
					<div class="col-md-9 text-center"> 
						<div id="total"><%=product.getprice(product.getP_price())%>원</div>
					</div>
				</div>
				<div>
					<button class="form-control bg-success text-white" style="font-size : 1.5rem"> 구매하기 </button>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<button class="form-control bg-warning text-white"> 장바구니 </button>
					</div>
					<%
					int m_num = 0;
					if(login !=null){m_num = login.getM_num();}
					// 좋아요가 존재하면
					if(ProductDao.getproductDao().likecheck(p_num, m_num)){%>
						<div class="col-md-6">
							<button id="btnplick" onclick="plike(<%=product.getP_num() %>,<%=m_num %>);" class="form-control bg-info text-white"> 찜하기♥ </button>
						</div>
					<% // 좋아요가 존재하지 않으면
					}else {%>	
						<div class="col-md-6">
							<button id="btnplick" onclick="plike(<%=product.getP_num() %>,<%=m_num %>);" class="form-control bg-info text-white"> 찜하기♡ </button>
						</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>