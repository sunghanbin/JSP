<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 이페이지 가 에러 페이지 가 맞냐고 물어본다. 여기서 는 여기를 에러페이지로 쓸것 이기때문에
 true 이지만 디폴트 값은 false 다. -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  
  
  <!-- 사용자에게 줄 응답으로 200 에러 로 응답 줌
  	   에러 메세지를 msg에 담아 보여준다. -->
  <%
  	response.setStatus(200);
  	String msg = exception.getMessage();
  %>
  
  <h1>error message = <%= msg %></h1>
  
  </body>
 </html>