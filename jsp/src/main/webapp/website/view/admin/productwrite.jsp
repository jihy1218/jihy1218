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
			<form action="../../controller/productwritecontroller.jsp" method="post" enctype="multipart/form-data">
				차이름  <input class="col-md-3 form-control" type="text" name="p_name">
				제품가격 <input class="form-control" type="text" name="p_price">
				배기량 <input class="form-control" type="text" name="p_cc">
				연료타입 <select class="form-control" name="p_fueltype">
						<option value="Gasoline">Gasoline</option>
						<option value="Diesel">Diesel</option>
						</select>
				차량이미지 <input class="form-control" type="file" name="p_img">
				재고 <input class="form-control" type="text" name="p_stock">
				카테고리 <select class="custom-select" name="p_category">
						<option value="SUV">SUV</option>
						<option value="SEDAN">세단</option>
						<option value="M">M</option>
						</select>
				상태 <select class="custom-select" name="p_active">
						<option value="1">준비중</option>
						<option value="2">판매중</option>
						<option value="3">품절</option>				
						</select>
				상세설명 <textarea class="form-control" rows="" cols="" name="p_contents"></textarea><br>
				<input class="btn btn-info " type="submit" value="제품등록"><br>
			</form>
		</div>
</body>
</html>