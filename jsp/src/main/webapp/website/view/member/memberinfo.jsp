<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="dto.Porderdetail"%>
<%@page import="dao.PorderDao"%>
<%@page import="dto.Porder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
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
	<div class="container">
		<div class="text-center">
			<h3 style="border-bottom: solid 1px #eeeeee; padding-bottom: 10px;">회원정보</h3>
			<br>
		</div>
		<div class="row">
			<div class="col-md-3"> <!-- 사이드바 -->
				<div class="nav flex-column nav-pills">	<!-- flex-column 가로정렬 -->
					<a class="nav-link active" data-toggle="pill" href="#pills-order" >주문목록</a>
					<a class="nav-link" data-toggle="pill" href="#pills-memberinfo" >회원정보</a>
					<a class="nav-link" data-toggle="pill" href="#pills-memberwrite" >내가 쓴글</a>
					<a class="nav-link" data-toggle="pill" href="#pills-memberdelete" >회원탈퇴</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="tab-content" id="pills-tabcontent">
					<div class="tab-pane fade show active" id="pills-order">
						<h3>주문 목록</h3>
						<section>
							<div class="container">
							<% ArrayList<Porder> porders = PorderDao.getPorderDao().getporderlist(login.getM_num()); %>
							<%for(int i =0;i<2;i++){%>
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
							</div>
						</section>
					</div>
					<%
						// 로그인된 아이디의 세션호출
						Member member = MemberDao.getmemberDao().getMember(loginid);
					%>
					<div class="tab-pane fade" id="pills-memberinfo">
						<h3>회원 정보</h3>
						<div class="container">
							<table id="" class="table text-center">
								<thead>
									<tr>
										<th colspan="3">회원 개인 정보</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>아이디</td><td colspan="2"> <%=member.getM_id() %> </td>
									</tr>
									<tr>
										<td>포인트</td><td colspan="2"><%=member.getM_point() %></td>
									</tr>
									<tr>
										<td>패스워드</td><td id="tdpassword">·····</td><td><button onclick="passwordchange();" class="btn btn-danger">수정</button></td>
									</tr>
									<tr>
										<td>회원명</td><td id="tdname"><%=member.getM_name() %></td><td><button onclick="namechange();" class="btn btn-warning">수정</button></td>
									</tr>
									<tr>
										<td>성별</td><td id="tdsex"><%=member.getM_sex() %></td><td><button onclick="sexchange();" class="btn btn-primary">수정</button></td>
									</tr>
									<tr>
										<td>생년월일</td><td id="tdbirth"><%=member.getM_birth() %></td><td><button onclick="birthchange();" class="btn btn-secondary">수정</button></td>
									</tr>
									<tr>
										<td>연락처</td><td id="tdphone"><%=member.getM_phone() %></td><td><button onclick="phonechange();" class="btn btn-info">수정</button></td>
									</tr>
									<tr>
										<td>주소</td><td><%=member.getM_address() %></td><td><button onclick="addresschange();" class="btn btn-success">수정</button></td>
									</tr>
									<tr id="tdaddress" style= "display : none">
										<td colspan="3">
											<div class="row">
												<div class="col-md-3 m-2"><label>주소</label></div>					
												<div class="col-md-8">
													<div class="row">
														<div class="col-md-6"><input type="text" name="address1" id="sample4_postcode" placeholder="우편번호" class="form-control"></div>
														<div class="col-md-6"><input type="button" onclick="sample4_execDaumPostcode()" class="form-control" value="우편번호 찾기"><br></div>
													</div>
													<div class="row">
														<div class="col-md-6"><input type="text" name="address2" id="sample4_roadAddress" class="form-control" placeholder="도로명주소"></div>
														<div class="col-md-6"><input type="text" name="address3" id="sample4_jibunAddress" class="form-control" placeholder="지번주소"></div>
													</div>
													<input type="text" id="sample4_detailAddress" name="address4" class="form-control" placeholder="상세주소">
												</div>
											</div>
											<div>
												<button id="addersschange"  class="btn btn-success">확인</button>
											</div>
										</td>
									</tr>
									<tr>
										<td>가입일</td><td colspan="2"><%=member.getM_sdate() %></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="tab-pane fade" id="pills-memberwrite">
						<h3>내가 쓴글</h3>
						<div class="container">
							하하하하하하ㅏ하하ㅏ
						</div>
					</div>
					<div class="tab-pane fade" id="pills-memberdelete">
						<h3>회원 탈퇴</h3>
						<div class="container">
							<div class="col-md-5 offset-3">
								<h4>정말 회원탈퇴 하시겠습니까?</h4>
								<br>
								<form id="deleteform">
									<input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" class="form-control">
									<br>
									<span class="" id="deleteresult"></span>
									<br>
									<input type="button" id="delete" value="확인" class="form-control">
									<br>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>		
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>