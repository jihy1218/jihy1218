<%@page import="dao.Login"%>
<%@page import="dto.Product"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Porderdetail"%>
<%@page import="dao.PorderDao"%>
<%@page import="dto.Porder"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%int item =Integer.parseInt(request.getParameter("item")); %>
	<%Login login = (Login)session.getAttribute("login"); %>
	<% ArrayList<Porder> porders = PorderDao.getPorderDao().getporderlist(login.getM_num()); %>
	<%for(int i =item;i<item+1;i++){%>
		<div class="row">
			<div class="col-md-4 border rounded p-3 mb-4 d-flex align-items-center"> <!-- 주문 정보 -->
				<p>주문번호 : <%=porders.get(i).getOrder_num() %><br>
					주문일 : <%=porders.get(i).getOrder_date() %>
				<button class="btn btn-info btn-block">주문상세</button>
			</div>
			<div class="col-md-8 border rounded p-3 mb-4"> <!-- 주문 상세 -->
			<%	ArrayList<Porderdetail> porderdetails = PorderDao.getPorderDao().getporderdetaillist(porders.get(i).getOrder_num());
				for(int j =0;j<porderdetails.size();j++){%>
			<% Product product = ProductDao.getproductDao().getproduct(porderdetails.get(j).getP_num());%>		
				<p>주문제품 내역 <hr>
				<div class="row">
					<div class="col-md-3 d-flex align-items-center">
						<img src="/jsp/website/upload/<%=product.getP_img()%>" style="max-width: 100%;">
					</div>
					<div class="col-md-9">
						<div class="row">
							<div class="col-md-8">
							<p>상품명 : <%=product.getP_name() %><br>
								옵션 : <%=product.getP_fueltype() %><br>
								수량 : <%=porderdetails.get(j).getP_count() %><br>
								배송상태 : <%=porderdetails.get(j).getDelivery_state() %>
							</div>
							<div class="col-md-2">
								<button class="btn btn-outline-danger mb-2">탁송조회</button>
								<button class="btn btn-outline-danger">주문변경</button>
							</div>
						</div>
					</div>
				</div>
			<%}%>		
			</div>
		</div>
	<%} %>