<%@page import="dao.Login"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 선택한 제품의 제품번호 , 수량 
	int p_num = Integer.parseInt(request.getParameter("p_num"));
	String p_type = request.getParameter("p_type");
	int p_count = Integer.parseInt(request.getParameter("p_count"));	
	// 객체화
	Cart cart = new Cart(p_num,p_type,p_count);				// 카트 객체화
		// 장바구니 세션이름
		Login login = (Login)session.getAttribute("login");		// 세션의 자료형은 object
		String sname = "cart"+login.getM_id();					// 카트+로그인된 회원아이디
		// 기존 카트가 있을경우 없을경우
		ArrayList<Cart> carts = (ArrayList<Cart>)session.getAttribute(sname); // 1.카트세션 호출
		if(carts==null) { // 2. 카트세션이 비어있을경우
			carts = new ArrayList<>();	// 3.메모리 할당
			carts.add(cart); // 4. 카트리스트에 추가
			// 세션에 저장 [ 이름 : cart+아이디 값 : cart리스트]
			session.setAttribute(sname, carts); // 5. 세션에 회원아이디, 카트목록 부여
		}else {  								// 6. 카트세션이 비어있지 않을경우 메모리할당 불필요
			// 기존 카트에 동일한 제품이 있을 경우
			boolean pcheck = true;
			for(Cart temp : carts) {
				if(temp.getP_num() == p_num && temp.getP_type().equals(p_type)){
					// 기존제품에 수량 추가
					temp.setP_count(temp.getP_count()+p_count);
					pcheck=false; // 중복이 있으면 false
				}
			}
			if(pcheck) {carts.add(cart);} 			// 7. 중복된제품이 없을경우 카트리스트에 제품 추가
			session.setAttribute(sname, carts); // 8.세션에 회원아이디, 카트목록 부여 [업데이트]
		}

	// 비동기식 사용시 페이지 전환 X
	// response.sendRedirect("../view/product/productcart.jsp");
%>