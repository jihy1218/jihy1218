<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int p_num = Integer.parseInt(request.getParameter("p_num"));
	
	boolean result = ProductDao.getproductDao().delete(p_num);
	if(result) {
		out.print("<script>alert('제품이 삭제되었습니다.')</script>");
		out.print("<script>location.href='/jsp/website/view/admin/dashboard.jsp';</script>"); 
	}else{
		out.print("<script>alert('제품 삭제 실패')</script>");
		out.print("<script>location.href='/jsp/website/view/admin/dashboard.jsp';</script>"); 
	}

%>