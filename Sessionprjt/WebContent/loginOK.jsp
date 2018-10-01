<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	session = request.getSession();
	
	out.print("sesseion = "+ session.getAttribute("memberId") + "<br>");
	
	%>
	
	<!-- 로그아웃 할시 세션 날리기 -->
	
	<form action="loginoutCon" method="post">
		<input type="submit" value="logout">
	</form>

</body>
</html>