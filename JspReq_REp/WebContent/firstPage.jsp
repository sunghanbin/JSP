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
  	
  	<!-- 사용자에게 응답  response 다른페이지로 이동 -->
  	<!-- first 페이지 로 들어오자 마자 세컨드 페이지로 이동 시킨다 ..
  	어떠한 액션이나 동작 안에 응답 메서드를 넣어 주지 않았기 때문에  -->
  	<%
  	 	response.sendRedirect("second.jsp");
  	%>
  </body>
 </html>