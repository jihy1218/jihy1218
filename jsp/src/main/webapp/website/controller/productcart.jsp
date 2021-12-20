<%@page import="dao.PorderDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONObject jsonObject = new JSONObject();
	/* // JSONObject <--> Map
		// JSONObject.put("키", "값"); : 엔트리 추가
	jsonObject.put("id", "kakao"); 
	jsonObject.put("password", "kakao"); */ 
	jsonObject = PorderDao.getPorderDao().getorderdatecount();
%>
<%=jsonObject %>
