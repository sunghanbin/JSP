<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  			<%-- java �ڵ� �ּ�  �� �Ʒ��ڵ�� �ڹ� �ڵ� --%>
  		<%!
  			int num = 10;
  			String str = "jsp";
  			ArrayList<String> list = new ArrayList<String>();
  			
  			public void jspMethod() {
  				System.out.println("-- jspmethod()--");
  			}
  	
  		%>
  		
  		<!-- �ּ��±� HTML -->
  		
  		<!-- ��ũ��Ʈ�� �±� -->
  		<%
  		if(num > 0){
  		%>
  		<p> num > 0 </p>
  		<%
  		} else { 
  		%>
  		<p> num <= 0 </p>
  		<%
  		}
  		%>
  		
  		<!--  ǥ���� �±� -->
  		<!-- java�� ���� �� �޼����� ��ȯ���� ����ϴ� �±� 
  		 ���⼭�� ���� ���� ������ ������ ���� num�� �� 10�� ��� �ϰ� �ɰ��̴�. -->
  		num is<%= num %>
  		
  		<!-- ����� ���������� �̴�. �׷��� ������ �ڹ��ڵ�� html ���� �� �� ��������
  		 ����ڰ� �������� �����Ͽ� �ҽ��� ���Եȴٸ� �ڹ��ڵ�� ���� �����̳ʿ��� ������ ������(����� ��������)
  		  ������̳� �����ٹ��� �鸸 ����� �������� ���Եȴ� ���� if���� ���� �ǰ� ����� �������� ������ ���� num �� 0���� ũ�⶧���� if ���� Ÿ��
  		  p�±� html ������ �����ְ� �ȴ�. ������ else���� �ִ� ������ �������� �ʴ´�. ���������̳ʿ��� �۾��� ������ �ѵ� ��� ���� ����� ��������
  		  �����ش�.  -->
  		
  </body>
 </html>