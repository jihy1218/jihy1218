<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
	// 로그인된 아이디 [ 세션 ]
	String id = (String)session.getAttribute("loginid");
	// ajax 에서 가져온 변수
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String sex = request.getParameter("sex"); 
	String birth = request.getParameter("birth");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address1")+","+request.getParameter("address2")+","+
			 request.getParameter("address3")+","+request.getParameter("address4");
	// 이름 변경
	if(name!=null){
		boolean nameresult = MemberDao.getmemberDao().nameupdate(name, id);
		if(nameresult) {out.print(1);}
		else{out.print(0);}
	}
	// 비밀번호 변경
	if(password!=null){
		boolean passwordresult = MemberDao.getmemberDao().passwordupdate(password, id);
		if(passwordresult) {out.print(1);}
		else{out.print(0);}
	}
	// 성별 변경
	if(sex!=null){
		boolean sexresult = MemberDao.getmemberDao().sexupdate(sex, id);
		if(sexresult){out.print(1);}
		else{out.print(0);}
	}
	// 생일 변경
	if(birth!=null){
		boolean birthresult = MemberDao.getmemberDao().birthupdate(birth, id);
		if(birthresult){out.print(1);}
		else{out.print(0);}
	}
	// 연락처 변경
	if(phone!=null){
		boolean phoneresult = MemberDao.getmemberDao().phoneupdate(phone, id);
		if(phoneresult){out.print(1);}
		else{out.print(0);}
	}
	// 주소 변경
	if(address!=null) {
		boolean addressresult = MemberDao.getmemberDao().addressupdate(address, id);
		if(addressresult) {out.print(1);}
		else{out.print(0);}
	}
	
	
	
%>