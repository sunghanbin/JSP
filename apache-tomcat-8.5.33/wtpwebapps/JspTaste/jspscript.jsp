<!--  는 지시어 로 서버에서 jsp페이지를 처리하는 방법에 대한 정의 를 해주는것이다
아래 구성은  속성="속성값" -->
<!-- import 지시어 로서  자바 임폴트와 동일하게 사용되며 속성="속성값" -->
<%@page import="java.util.ArrayList"%>
<!--페이지에 사용되는 언어는 java 이고 컨텐트 타입은 text와 html 을 사용하며 캐릭터셋 은 euc-kr 인코딩은 euc-kr을 사용한다. -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  
  <!-- 외부 파일들을 불러 올수 있는 지시어 include 이다 같은경로상 에 파일이 있기 때문에 파일이름만 적어준다.
  	   이렇게 하게 되면 외부에 있는 파일을 이 페이지 상에 뿌려 줄수 있다.-->
  <%@ include file="haeder.jsp" %>
  
  
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
  		
  		<!-- 외부파일 불러오는 지시어  -->
  		<%@ include file="Footer.jsp" %>
  		
  		
  		<!--지시어 taglib:외부라이브러리 태그 설정(jsp에 없는 외부라이브 러리)
  		    prefix(사전 :접두사-(Dr나 Mrs 같이 이름 앞에 붙는)경칭) : 현재 페이지 내에서 url값을 사용하려 할때 너무 길기 때문에 별칭 을붙혀줌 네임스페이스-->
  		<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  		
  		
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