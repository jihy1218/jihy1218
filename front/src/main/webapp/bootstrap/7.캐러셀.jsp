<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		.carousel-item {
			width: 1200px;	/* !important > id > class > �±� > * */
			height: 990px;
		}
	</style>
</head>
<body>

	<%@include file="1.��Ʈ��Ʈ������.jsp" %>
	
	<h3> �̹��� �����̵� [�ɶ�] </h3>
	<div class="contanier" >
		<div id="carouselcontents" class="carousel slide" data-ride="carousel" data-interval="5000">
			<!-- carousel slide : �̹��� �����̵� data-interval : 1/1000�� -->
			
			<ol class="carousel-indicators">		<!-- carousel-indicators : ���� �����̵� ��ġ -->
				<li data-target="carouselcontents" data-slide-to="0" class="active"></li>
				<li data-target="carouselcontents" data-slide-to="1"></li>
				<li data-target="carouselcontents" data-slide-to="2"></li>
			</ol>
			<div class="carousel-item active">
				<img src="�۸���2.jpg" alt="ù��° �����̵�">
				<div class="carousel-caption">
					<h4>������</h4>
					<p>�ȳ��ϼ��� �ظ����Դϴ�.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="�۸���2.jpg" alt="�ι�° �����̵�">
			</div>
			<div class="carousel-item">
				<img src="�۸���2.jpg" alt="����° �����̵�">
			</div>
			<!-- ��ư -->
			<a class="carousel-control-prev" href="#carouselcontents" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>	<!-- ������ -->
			</a>
			<a class="carousel-control-next" href="#carouselcontents" data-slide="next">
				<span class="carousel-control-next-icon"></span>	<!-- ������ -->
			</a>
		</div>
	</div>
</body>
</html>