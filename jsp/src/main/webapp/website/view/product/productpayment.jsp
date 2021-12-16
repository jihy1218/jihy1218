<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
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
	<!-- 결제 API  -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<%
		String sname = "cart"+login.getM_id();
		ArrayList<Cart> carts = (ArrayList<Cart>)session.getAttribute(sname);  // 카트 세션호출
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		// 총결제금액
		int totalprice = 0;
		// 회원정보불러오기
		Member member = MemberDao.getmemberDao().getMember(login.getM_id());
		// 회원주소 불러오기
		String[] address = member.getM_address().split(",");
	%>
		<input type="hidden" id="name" value="<%=member.getM_name() %>">
		<input type="hidden" id="phone" value="<%=member.getM_phone() %>">
		<input type="hidden" id="address1" value="<%=address[0] %>">
		<input type="hidden" id="address2" value="<%=address[1]%>">
		<input type="hidden" id="address3" value="<%=address[2]%>">
		<input type="hidden" id="address4" value="<%=address[3]%>">
	<div class="container">
		<table class="table text-center">
			<tr>
				<th>이미지</th><th>상품정보</th><th>수량</th><th>가격</th>
			</tr>
			<%
				for(Cart cart : carts){
					Product product = ProductDao.getproductDao().getproduct(cart.getP_num());
					totalprice += cart.getP_count()*product.getP_price();
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
				<td class="align-middle">
					<%=cart.getP_count() %>
				</td>
				<td class="align-middle"><%=decimalFormat.format(cart.getP_count()*product.getP_price()) %></td>
			</tr>
			<%} %>
		</table>
		<br><br>
		<div class="row">
			<div class="col-md-6">
				<h3>탁송 정보</h3>
				<span>탁송받으실 정보 </span> <input type="checkbox" id="checkbox"><span class="text-primary">가입시 입력한정보와 동일</span>
				<div class="row">
					<div class="col-md-3 m-2"><label>이름</label><span class="text-danger">*</span></div>					
					<div class="col-md-8"><input type="text" id="mname" name="name" class="form-control" placeholder="받는분 이름을 입력해주세요."></div>
				</div>
				<div class="row">
					<div class="col-md-3 m-2"><label>연락처</label><span class="text-danger">*</span></div>					
					<div class="col-md-8"><input type="text" id="mphone" name="phone" class="form-control" placeholder="-제외한 11자리번호" maxlength="15"> </div>
				</div>
				<div class="row">
					<div class="col-md-3 m-2"><label>받는 사람 주소</label><span class="text-danger">*</span></div>					
					<div class="col-md-8">
						<div class="row">
							<div class="col-md-6"><input type="text" name="address1" id="sample4_postcode" placeholder="우편번호" class="form-control"></div>
							<div class="col-md-6"><input type="button" onclick="sample4_execDaumPostcode()" class="form-control" value="우편번호 찾기"><br></div>
						</div>
						<div class="row">
							<div class="col-md-6"><input type="text" name="address2" id="sample4_roadAddress" class="form-control" placeholder="도로명주소"></div>
							<div class="col-md-6"><input type="text" name="address3" id="sample4_jibunAddress" class="form-control" placeholder="지번주소"></div>
						</div>
						<br>
						<input type="text" id="sample4_detailAddress" name="address4" class="form-control" placeholder="상세주소">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-3 m-2"><label>요청사항</label></div>					
					<div class="col-md-8">
						<select class="custom-select" id="order_contents">
							<option value="요청사항없음">--------요청사항 선택하기--------</option>
							<option value="부재시 경비실에 맡겨주세요!">부재시 경비실에 맡겨주세요!</option>
							<option value="배송전에 연락 주세요!">배송전에 연락 주세요!</option>
							<option value="배송후에 연락 주세요!">배송후에 연락 주세요!</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<h3>결제 정보</h3>
				<h5>결제 내용</h5>
				<div class="row">
					<div class="col-md-3">마일리지</div>
					<div class="col-md-5">
						<input class="form-control" type="text" id="point" placeholder="사용 할 마일리지"><br>
						<span class="text-secondary">
						사용가능 마일리지 : <span id="leftpoint"><%=member.getM_point() %></span></span>
					</div>
					<div class="col-md-2">
						<button class="btn btn-secondary" onclick="pointcheck(<%=member.getM_point()%>);">사용</button>
					</div>
				</div>
				<h5>결제 금액</h5>
				<div class="row">
					<div class="col-md-3">총 주문금액</div>
					<div class="col-md-9 text-right">
						<span id="totalprice"><%=totalprice %></span>원
						(총 주문 차량품목 수 : <%=carts.size() %>)
					</div>
					<div class="col-md-3">탁송비</div>
					<div class="col-md-9 text-right">
						<span id="totaldeliverypay">220000</span>원
					</div>					
					<div class="col-md-3">사용한 마일리지 </div>
					<div class="col-md-9 text-right">
						<span id="usepoint">0</span>마일리지
					</div>					
					<div class="col-md-3">최종 결제 금액</div>
					<div class="col-md-9 text-right">
						<span id="totalpay">0</span>원
					</div>					
				</div>
				<hr>
				<h5>결제 방식</h5>
				<div class="row d-flex justify-content-around">
					<button onclick="payselect('samsung');" class="btn btn-outline-info col-md-2">삼성페이</button>
					<button onclick="payselect('card');" class="btn btn-outline-info col-md-2">신용카드</button>
					<button onclick="payselect('trans');" class="btn btn-outline-info col-md-2">계좌이체</button>
					<button onclick="payselect('vbank');" class="btn btn-outline-info col-md-2">가상계좌</button>
					<button onclick="payselect('phone');" class="btn btn-outline-info col-md-2">휴대폰</button>
				</div>
				<div style="display: none;" id="pay"></div>
				<hr>
				<div class="row d-flex justify-content-around my-3">
					<button class="btn btn-success col-md-2" onclick="payment();">결제하기</button>
					<button class="btn btn-danger col-md-2">취소하기</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>