<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  	<p> First page!!!</p>
  	
  	<!-- ����ڿ��� ����  response �ٸ��������� �̵� -->
  	<!-- first ������ �� ������ ���� ������ �������� �̵� ��Ų�� ..
  	��� �׼��̳� ���� �ȿ� ���� �޼��带 �־� ���� �ʾұ� ������  -->
  	<%
  	 	response.sendRedirect("second.jsp");
  	%>
  </body>
 </html>