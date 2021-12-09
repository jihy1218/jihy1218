<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
	/* 저장경로 */
	String folderpath = "D:/Enterprise/jihy1218/jsp/src/main/webapp/website/upload"; 
	MultipartRequest multi = new MultipartRequest(request,folderpath,1024*1024*100,"UTF-8",new DefaultFileRenamePolicy());

	String p_name = multi.getParameter("p_name");
	int p_price = Integer.parseInt(multi.getParameter("p_price"));
	int p_cc = Integer.parseInt(multi.getParameter("p_cc"));
	String p_fueltype = multi.getParameter("p_fueltype");
	String p_img = multi.getFilesystemName("p_img");
	int p_stock = Integer.parseInt(multi.getParameter("p_stock"));
	String p_category = multi.getParameter("p_category");
	int p_active = Integer.parseInt(multi.getParameter("p_active"));
	String p_contents = multi.getParameter("p_contents");
	Product product = new Product(p_name,p_price,p_cc,p_fueltype,p_img,p_stock,p_category,p_active,p_contents);
	
	boolean result = ProductDao.getproductDao().productwrite(product);
	if(result){
			out.print("<script>alert('제품이 등록되었습니다.')</script>");
			out.print("<script>location.href='/jsp/website/view/admin/dashboard.jsp';</script>");  
	}else{
		out.print("<script>alert('제품 등록 실패')</script>");
	}

%>