<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- �������� �� ���� ������ �� �³İ� �����. ���⼭ �� ���⸦ ������������ ���� �̱⶧����
 true ������ ����Ʈ ���� false ��. -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  
  
  <!-- ����ڿ��� �� �������� 200 ���� �� ���� ��
  	   ���� �޼����� msg�� ��� �����ش�. -->
  <%
  	response.setStatus(200);
  	String msg = exception.getMessage();
  %>
  
  <h1>error message = <%= msg %></h1>
  
  </body>
 </html>