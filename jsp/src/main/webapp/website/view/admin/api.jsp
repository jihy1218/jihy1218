<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
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
		<table>
	<%	// api 가져오기 순서
		// 1. url 가져오기
		URL url = new URL("https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=STyq4rZcOmCJ6D8VcVlYkPDXBTVCLJAp85rRzoIzo%2FTLlv%2Ftnp8Wvz7DhJEn6fqkJBVHcfyEN8s7bORFrTT%2FQw%3D%3D");
		// 2. 스트림 버퍼를 통한 URL내 HTML 내용 읽어오기
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			// BufferedReader : 외부[이클립스 외]통신시 입출력 
			// InputStreamReader(스트림,인코딩타입) : 입출력 스트림
			// (url.openStream(),"UTF-8") : 바이트 단위로 url 내용 읽기
		// 3. 읽어온 내용을 문자열에 담기
		String result = bf.readLine(); // readLine : 모든 줄 읽기
		// 4. 읽어온 내용을 json으로 파싱 하기
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
			// 1. JSONparser json데이터를 넣어서 파싱
				// 2. JSONParser 형 변환
		JSONArray jsonArray = (JSONArray)jsonObject.get("data");
			// 데이터 키 요청해서 리스트에담기
		for(int i =0;i<jsonArray.size();i++){
		JSONObject content = (JSONObject)jsonArray.get(i);
	%>
		<tr>
			<td><%=content.get("facilityName") %></td><td><%=content.get("address") %></td><td><%=content.get("phoneNumber") %></td>
			<td>위도 : <%=content.get("lat") %></td><td>경도 : <%=content.get("lng") %></td>
			<td><button onclick="map(<%=i%>,<%=content.get("lat") %>,<%=content.get("lng")%>);" class="btn btn-outline-success">지도보기</button>
			</td>
		</tr>
		<tr>
			<td colspan="5"><div id="map<%=i %>" style="width:100%;height:350px;display: none;"></div></td>
		</tr>
	<%} %>		
	
		
		</table>
	</div>
</body>
</html>