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
  			<%-- java 코드 주석  및 아래코드는 자바 코드 --%>
  		<%!
  			int num = 10;
  			String str = "jsp";
  			ArrayList<String> list = new ArrayList<String>();
  			
  			public void jspMethod() {
  				System.out.println("-- jspmethod()--");
  			}
  	
  		%>
  		
  		<!-- 주석태그 HTML -->
  		
  		<!-- 스크립트릿 태그 -->
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
  		
  		<!--  표현식 태그 -->
  		<!-- java의 변수 및 메서드의 반환값을 출력하는 태그 
  		 여기서는 위에 전역 변수로 선언한 변수 num의 값 10을 출력 하게 될것이다. -->
  		num is<%= num %>
  		
  </body>
 </html>