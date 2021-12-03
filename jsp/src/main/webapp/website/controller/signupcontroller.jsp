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
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passwordconfirm = request.getParameter("passwordconfirm");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address1")+","+request.getParameter("address2")+","+
						 request.getParameter("address3")+","+request.getParameter("address4");
		// 유효성검사
		/* if(id.equals(" ") || password.equals(" ") || passwordconfirm.equals(" ") || name.equals(" ") || birth.equals(" ") || sex.equals(" ") || phone.equals(" ") || address.equals(" ")){
			out.print("<script>alert('채워지지않은 항목이 있습니다.')</script>");
			out.println("<script>location.href='../view/member/signup.jsp';</script>");
		}
		else if(id.length() <5) { 
			out.print("<script>alert('아이디는 5글자이상 15글자 이하입니다.')</script>");
			out.println("<script>location.href='../view/member/signup.jsp';</script>");
		}
		else if(password.length()<5){
			out.print("<script>alert('비밀번호는 5글자 이상 15글자 이하입니다.')</script>");
			out.println("<script>location.href='../view/member/signup.jsp';</script>");
		}
		else if(!password.equals(passwordconfirm)) {
			out.print("<script>alert('비밀번호가 일치하지 않습니다.')</script>");
			out.println("<script>location.href='../view/member/signup.jsp';</script>");
		}
		else if(phone.length()!=11) {
			out.print("<script>alert('핸드폰번호는 -제외 11자리여야 합니다.')</script>");
			out.println("<script>location.href='../view/member/signup.jsp';</script>");
		}
		else if(request.getParameter("address4").indexOf(",")>0) {
			out.print("<script>alert('상세주소는, 제외하고 입력해주세요')</script>");
			out.println("<script>location.href='../view/member/signup.jsp';</script>");
		}
		else { */
			// 객체화
			Member member = new Member(id,password,name,birth,sex,phone,address);
			// DB처리
			boolean result = MemberDao.getmemberDao().membersignup(member);
			if(result) { // 회원가입 성공
			
				response.sendRedirect("../view/member/signupsuccess.jsp");
			}else { // 회원가입 실패
				response.sendRedirect("../view/member/signup.jsp");			
				
			}
		/* } */
	%>
	
	
</body>
</html>