<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="1.header.jsp" %>
	<!-- �Խ��� start -->	
	
	<div class="container my-5">
		<h3>QnA</h3>
		<div class="col-md-5 offset-7 input-group ">
			<select class="custom-select">	<!-- �˻� Ű���� -->
				<option>Ű����</option>
				<option>��ȣ</option>
				<option>����</option>
				<option>�ۼ���</option>
			</select>
			<input type="text" class="form-control"><button class="btn btn-success">�˻�</button>
		</div>
		<p>���� �Խ���</p>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>��ȣ</th><th>����</th><th>�ۼ���</th><th>�亯����</th><th>�ۼ���</th>
					</tr>
				</thead>
				<tbody>
					<tr><td>1</td><td>ȯ�ҿ�û�Դϴ�.</td><td>������</td><td>�亯�����</td><td>2021-11-26</td></tr>
					<tr><td>2</td><td>��ȯ��û�Դϴ�.</td><td>���ν�</td><td>�亯�����</td><td>2021-11-24</td></tr>
					<tr><td>3</td><td>��ǰ��û�Դϴ�.</td><td>������</td><td>�亯�Ϸ�</td><td>2021-11-23</td></tr>
					<tr><td>4</td><td>��ȯ��û�Դϴ�.</td><td>���屺</td><td>�亯�Ϸ�</td><td>2021-11-22</td></tr>
					<tr><td>5</td><td>ȯ�ҿ�û�Դϴ�~</td><td>���μ�</td><td>�亯�Ϸ�</td><td>2021-11-21</td></tr>
					<tr><td>6</td><td>��ǰ��û�Դϴ�!!!</td><td>Ȳ���</td><td>�亯�Ϸ�</td><td>2021-11-20</td></tr>
				</tbody>
			</table>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-4 my-4">
					<ul class="pagination">	<!-- �Խ��� ������ ��ȣ -->
						<li class="page-item"><a class="page-link">&laquo</a></li>
						<li class="page-item"><a class="page-link">1</a></li>
						<li class="page-item"><a class="page-link">2</a></li>
						<li class="page-item"><a class="page-link">3</a></li>
						<li class="page-item"><a class="page-link">4</a></li>
						<li class="page-item"><a class="page-link">5</a></li>
						<li class="page-item"><a class="page-link">&raquo</a></li>
					</ul>
				</div>
				<div class="col-md-1 offset-3 my-4">
					<button class="btn btn-info">�����ϱ�</button>
				</div>
			</div>
		</div>
	</div>
	<!-- �Խ��� end -->
	<br><br><br><br><br>
	<%@include file="3.footer.jsp" %>
</body>
</html>