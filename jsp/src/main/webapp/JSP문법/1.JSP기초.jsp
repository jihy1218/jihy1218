<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p> JSP(java server pages) : �ڹ� ���� ������</p>
	<ul>
		<li>1. HTML + JAVA �ڵ带 ������ �� �ִ� ������</li>
		<li>2. java -> �� ���α׷���[����:java,html ����] -> jsp[ java+html ]</li>
		<li>3. jsp���ϳ� java+html+css+js �ۼ� ����</li>
		<li>4. jsp ���������� -> ����[java]�� ��ȯ!!</li>
		<li>5. ����� : java ���� �±� �ȿ��� �ۼ�>
	</ul>
		
	<h1>��ũ��Ʈ ��</h1>					<!-- html ���� -->
	
		<!-- jsp ����(���� �±� : 1.��������o(��������static ó��), 2.�޼ҵ� ����o 3.���x) -->
	<%! String ���ڿ� = "jsp ����"; %>  	
	<%! 
		public String �޼ҵ�() {return "jsp �޼ҵ弱��"; }
	%>
	
		<!-- jsp ���� (��ũ��Ʈ �±� : 1.��������o(��������), 2.�޼ҵ� ����x, 3.���o) -->
	<% 
		String ��ũ��Ʈ = "jsp ��ũ��Ʈ"; 
		String ���� = "jsp�Դϴ�.";
		System.out.print("�ֿܼ� ��µǴ� �޼ҵ�1");	// �ܼ����
		out.print("�ֿܼ� ��µǴ� �޼ҵ�2");			// out: ��ũ��Ʈ �±� ������ -> html���̵�
	%>
		<!-- html ���� -->
	<br>���� ��� : <%=���ڿ� %>		<!-- ǥ���� �±� : ����, �޼ҵ� ȣ�� -->
	<br>�޼ҵ� ��� : <%=�޼ҵ�() %>
	<br>��ũ��Ʈ ��� : <%=��ũ��Ʈ %>
	
		<!-- �ּ� -->
	<br> html : <!-- html�ּ� -->
	<br> css : /* css �ּ� */
	<br> jsp : <%-- jsp �ּ� --%>
	<br> jsp : <% /* ������ �ּ� */ 	// �����ּ�  %> 
	
	
</body>
</html>