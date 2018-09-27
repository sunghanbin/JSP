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
  		
  		<!-- 여기는 서버페이지 이다. 그렇기 때문에 자바코드와 html 문서 가 다 보이지만
  		 사용자가 페이지에 접속하여 소스를 보게된다면 자바코드는 서버 컨테이너에서 동작이 끝나고(사용자 볼수없음)
  		  결과값이나 보여줄문서 들만 사용자 브라우저에 띄우게된다 위에 if문이 실행 되고 사용자 페이지에 보여줄 값은 num 이 0보다 크기때문에 if 문을 타고
  		  p태그 html 문서를 보여주게 된다. 나머지 else문에 있는 문서는 보여지지 않는다. 서버컨테이너에서 작업을 마무리 한뒤 결과 값만 사용자 페이지에
  		  보여준다.  -->
  		
  </body>
 </html>