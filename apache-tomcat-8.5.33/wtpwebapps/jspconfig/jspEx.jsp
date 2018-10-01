<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 예외처리(exception)객체 사용을 위해  에러 발생시 에레페이지.jsp로 보내라-->
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
 <html>
  <head>
  	<meta charset="EUC-KR">
  	<title>Insert title here</title>
  </head>
  <body>
  	<%! 
  		String admin;
  		String adminPass;
  		String imgDir;
  		String testServerIp;
  		
  		String str;
  	%>
  	
  	<!-- config 객체 -->
  	
  	<!-- init param
  		 web.xml 에서 서블릿 안에 정의 해 놓은 키와밸류 형태 
  		 의 데이터를  가져와서 사용할 수있는데 
  		 config(xml을 가르키는것 같다).getInitParameter("키")가져오겠다 해당하는 키의 값을
  		 xml 파일의 servlet 에서 지정한 jsp-file만 데이터 사용할수 있다 .-->
  	<%
  	admin = config.getInitParameter("adminId");
  	adminPass = config.getInitParameter("adminPw");
  	%>
  	
  	<p>admin = <%= admin %></p>
  	<p>adminpass = <%= adminPass %></p>
  	
  	<!-- ///////////////////////////////////////////////////////////// -->
  	
  	
  	<!-- application 객체  -->
  	
  	
  	<!-- context param 
  		 공통적으로 사용할 데이터 들을 쓸때  -->
  	<%
  	imgDir = application.getInitParameter("imgDir");
  	testServerIp = application.getInitParameter("testServerIp");
  	%>
  	
  	<p>imgDir = <%= imgDir %></p>
  	<p>testServerIp = <%= testServerIp %></p>
  	
  	
  	<!-- setAttribute context
  		set으로 추가한 어트리뷰트는 get 으로 가져올때 (String)application.get 처럼 앞에 string 을 써줘야한다.-->
  	
  	<%
  		application.setAttribute("setAtt", "sung");
  		application.setAttribute("settest", "hanbin");
  	
  	%>
  	
  	
  	<!-- /////////////////////////////////////////////////////// -->
  	
  	<!-- out 객체  -->
  	
  	<%
  		out.print("<h1>Hellow JAVA</h1>");
  		out.print("<h2>Hellow JSP</h2>");
  		out.print("<h1>Hellow servlet</h1>");
  	%>
  	
  	<!--  exception 객체  -->
  	
  	<!-- 현재 str은 초기화 만 해준뒤 값은 담겨 있지 않은데 출력 하라고 하고 있다. -->
  	<%
  	out.print(str.toString());
  	%>
  	
  </body>
 </html>