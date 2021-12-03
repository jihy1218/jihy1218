<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 만약에 로그인이 되어있는경우 -->
	<%
		// 로그인[세션]이 되어있는경우
		if(session.getAttribute("loginid") !=null){
			out.print("<script>alert('로그인이되어있습니다.');</script>");
			out.println("<script>location.href='../main.jsp';</script>");
		}
	%>
	<%@include file="../header.jsp" %>
	<div class="container">		<!-- 박스권 -->
		<div class="text-center">
			<h3 style="border-bottom: solid 1px #eeeeee; padding-bottom: 10px;">회원가입</h3>
			<br>
			<p style="color: teal;"> ·BMW 멤버가되시면 다양한 이벤트를 제공 받을 수 있습니다.</p>
		</div>
		<p class="text-right"><span class="text-danger">*</span>는 필수입력 항목입니다.</p>
		<div class="row">	<!-- 가로 박스 -->
			<div class="col-md-6">
				<img src="../../img/bmw.jpg" width="100%" >
			</div>
			<div class="col-md-6">
				<form id="signupform" action="../../controller/signupcontroller.jsp" method="post" onsubmit="return signupcheck();">
					<div class="row">
						<div class="col-md-3 m-2"><label>아이디</label><span class="text-danger">*</span></div>					
						<div class="col-md-8"><input type="text" onchange="signupcheck();" name="id" class="form-control" maxlength="15" placeholder="아이디는 5~15글자 사이로입력해주세요." > </div>
					</div>
						<div>
							<span id="idresult"></span>
						</div>
					<div class="row">
						<div class="col-md-3 m-2"><label>비밀번호</label><span class="text-danger">*</span></div>					
						<div class="col-md-8"><input type="password" onchange="signupcheck();" name="password" class="form-control" maxlength="15" placeholder="비밀번호는 5~15글자 사이로입력해주세요."> </div>
					</div>
					<div class="row">
						<div class="col-md-3 m-2"><label>비밀번호확인</label><span class="text-danger">*</span></div>					
						<div class="col-md-8"><input type="password" onchange="signupcheck();" name="passwordconfirm" class="form-control" maxlength="15" placeholder="비밀번호를 한번더 입력해주세요."> </div>
					</div>
						<div>
							<span id="pwresult"></span>
						</div>
					<div class="row">
						<div class="col-md-3 m-2"><label>이름</label><span class="text-danger">*</span></div>					
						<div class="col-md-8"><input type="text" onchange="signupcheck();" name="name" class="form-control" maxlength="15" placeholder="이름을 입력해주세요."> </div>
					</div>
						<div>
							<span id="nameresult"></span>
						</div>
					<div class="row">
						<div class="col-md-3 m-2"><label>생년월일</label><span class="text-danger">*</span></div>					
						<div class="col-md-8"><input type="date" onchange="signupcheck();" name="birth" class="form-control" > </div>
					</div>
						<div>
							<span id="birthresult"></span>
						</div>
					<div class="row">
						<div class="col-md-3 m-2"><label>성별</label><span class="text-danger">*</span></div>					
						<div class="col-md-8 text-center ">
							<input type="radio" name="sex" value="man" id="sex1" onchange="signupcheck();">남성
							<input type="radio" name="sex" value="woman" id="sex2" onchange="signupcheck();">여성
						</div>
						<div>
							<span id="sexresult"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 m-2"><label>연락처</label><span class="text-danger">*</span></div>					
						<div class="col-md-8"><input type="text" onchange="signupcheck();" id="phone" name="phone" class="form-control" placeholder="-제외한 11자리번호" maxlength="15"> </div>
					</div>
						<div>
							<span id="phoneresult"></span>
						</div>
					<div class="row">
						<div class="col-md-3 m-2"><label>주소</label><span class="text-danger">*</span></div>					
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
						<input type="submit" value="가입하기" class="form-control p-3 m-3"></input>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>