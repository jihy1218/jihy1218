<%@page import="dto.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 장바구니 세션 이름
	Login login = (Login)session.getAttribute("login");		// 세션의 자료형은 object
	String sname = "cart"+login.getM_id();					// 카트+로그인된 회원아이디
	
	String type = request.getParameter("type");
	int p_num = Integer.parseInt(request.getParameter("p_num"));
	String p_type = request.getParameter("p_type");
	int i = Integer.parseInt(request.getParameter("i"));
	int p_count = Integer.parseInt(request.getParameter("p_count"));
	
	ArrayList<Cart> carts = (ArrayList<Cart>)session.getAttribute(sname);
	if(type.equals("all")) { // 전체삭제버튼을 눌렀을때
		session.setAttribute(sname,null); // 카트 세션 null 초기화
	}else if(type.equals("in")){ // 개별 삭제 버튼을 눌렀을떄
		// 카트 세션 호출
		for(Cart cart : carts) { // 동일한 제품과 사이즈 삭제 
			if(cart.getP_num() == p_num && cart.getP_type().equals(p_type)){
				carts.remove(cart); // 카트에서 해당제품 삭제
				session.setAttribute(sname, carts);
				break; // 반복문 종료
			}
		}
	}else if(type.equals("p")) {
		carts.get(i).setP_count(p_count);
		session.setAttribute(sname, carts);
	}else if(type.equals("m")) {
		carts.get(i).setP_count(p_count);		
		session.setAttribute(sname, carts);
	}
	
%>