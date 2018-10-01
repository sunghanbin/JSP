<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- ����ó��(exception)��ü ����� ����  ���� �߻��� ����������.jsp�� ������-->
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
  	
  	<!-- config ��ü -->
  	
  	<!-- init param
  		 web.xml ���� ���� �ȿ� ���� �� ���� Ű�͹�� ���� 
  		 �� �����͸�  �����ͼ� ����� ���ִµ� 
  		 config(xml�� ����Ű�°� ����).getInitParameter("Ű")�������ڴ� �ش��ϴ� Ű�� ����
  		 xml ������ servlet ���� ������ jsp-file�� ������ ����Ҽ� �ִ� .-->
  	<%
  	admin = config.getInitParameter("adminId");
  	adminPass = config.getInitParameter("adminPw");
  	%>
  	
  	<p>admin = <%= admin %></p>
  	<p>adminpass = <%= adminPass %></p>
  	
  	<!-- ///////////////////////////////////////////////////////////// -->
  	
  	
  	<!-- application ��ü  -->
  	
  	
  	<!-- context param 
  		 ���������� ����� ������ ���� ����  -->
  	<%
  	imgDir = application.getInitParameter("imgDir");
  	testServerIp = application.getInitParameter("testServerIp");
  	%>
  	
  	<p>imgDir = <%= imgDir %></p>
  	<p>testServerIp = <%= testServerIp %></p>
  	
  	
  	<!-- setAttribute context
  		set���� �߰��� ��Ʈ����Ʈ�� get ���� �����ö� (String)application.get ó�� �տ� string �� ������Ѵ�.-->
  	
  	<%
  		application.setAttribute("setAtt", "sung");
  		application.setAttribute("settest", "hanbin");
  	
  	%>
  	
  	
  	<!-- /////////////////////////////////////////////////////// -->
  	
  	<!-- out ��ü  -->
  	
  	<%
  		out.print("<h1>Hellow JAVA</h1>");
  		out.print("<h2>Hellow JSP</h2>");
  		out.print("<h1>Hellow servlet</h1>");
  	%>
  	
  	<!--  exception ��ü  -->
  	
  	<!-- ���� str�� �ʱ�ȭ �� ���ص� ���� ��� ���� ������ ��� �϶�� �ϰ� �ִ�. -->
  	<%
  	out.print(str.toString());
  	%>
  	
  </body>
 </html>