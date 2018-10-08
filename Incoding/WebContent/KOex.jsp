<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


jsp 에서 서블릿 으로 보낼 때 한글 인코딩 post
<form action="mSignup" method="post">

	이름 : <input type="text" name="mname"><br>
	별명 : <input type="text" name="mnickname"><br>
		<input type="submit" value="sign up">	
</form>

jsp 에서 jsp 로 보낼 때 한글 인코딩 post
<form action="mSignup.jsp" method="get">

	이름 : <input type="text" name="mname"><br>
	별명 : <input type="text" name="mnickname"><br>
		<input type="submit" value="sign up">
		
		
	
</form>

</body>
</html>