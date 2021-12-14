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
		// 제품 상세페이지 
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
				<input type="hidden" class="p_num" name="p_num" id="p_num" value="<%=p_num%>">
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
					<div class="col-md-3">배기량</div>
					<div class="col-md-9"> <%=product.getP_cc() %>cc </div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-3">엔진타입</div>
					<div class="col-md-9">
						<select id="p_type" name="p_type" class="form-control">
							<option> 옵션 선택 </option>
							<option value="Gasoline">Gasoline</option>
							<option value="Diesel">Diesel</option>
						</select> 
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-3"> 수량 </div>
					<div class="col-md-9">
						<div>
							<button class="btn btn-success d-inline" onclick="pchange('p',<%=product.getP_stock()%>,<%=(product.getP_price())%>);">+</button>
							<input class="form-control col-md-6 d-inline" name="p_count" type="text" id="p_count" value="1" onchange="pchange('s',<%=product.getP_stock()%>,<%=product.getP_price()%>);">
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
						<button onclick="cartadd();" class="form-control bg-warning text-white"> 장바구니 </button>
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
		<br><br>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<ul class="navbar-nav col-md-12 text-center">
				<li class="nav-item col-md-3"><a href="#detail" class="nav-link pview">차량상세</a></li>
				<li class="nav-item col-md-3"><a href="#guide" class="nav-link pview">차량가이드</a></li>
				<li class="nav-item col-md-3"><a href="#review" class="nav-link pview">차량리뷰</a></li>
				<li class="nav-item col-md-3"><a href="#qna" class="nav-link pview">차량문의</a></li>
			</ul>		 	
		</nav>
		<div id="detail">
			차량 상세 위치 <br><br><br><br><br><br><br><br><br><br>
		</div>
		<div id="guide">
			차량 가이드 위치 <br><br><br><br><br><br><br><br><br><br>
		</div>
		<div id="review">
			차량 리뷰 위치 <br><br><br><br><br><br><br><br><br><br>
		</div>
		<div id="qna">
			차량 문의 위치 <br><br><br><br><br><br><br><br><br><br>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>