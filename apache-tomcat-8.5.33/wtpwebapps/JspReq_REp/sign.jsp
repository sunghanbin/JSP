<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  		<!-- ������� ��û�� ���� ������Ʈ ��ü �ޱ�-->
  		
  		<!-- ���� ���� -->
  		<%!
  		String m_name;
  		String m_pass;
  		String[] m_bobby;
  		%>
  		
  		
  		<!-- ������Ʈ(��û) �� �ִ� ���� ���� �������� getparameter(request �޼���) ��� -->
  		<%
  		m_name = request.getParameter("m_name");
  		m_pass = request.getParameter("m_pass");
  		m_bobby = request.getParameterValues("m_bobby");
  		%>
  		
  		m_name = <%= m_name %><br>
  		m_pass = <%= m_pass %><br>
  		m_bobby =
  		<%
  		  for(int i =0; i < m_bobby.length; i++){
  		%>
  		<%= m_bobby[i] %>
  		<%	  
  		 }
  		%>
  		
  
  
  </body>
 </html>