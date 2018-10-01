<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  		<!-- 사용자의 요청을 받을 리퀘스트 객체 받기-->
  		
  		<!-- 변수 선언 -->
  		<%!
  		String m_name;
  		String m_pass;
  		String[] m_bobby;
  		%>
  		
  		
  		<!-- 리퀘스트(요청) 에 있는 값을 가져 오기위해 getparameter(request 메서드) 사용 -->
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