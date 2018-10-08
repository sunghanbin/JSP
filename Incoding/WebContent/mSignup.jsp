<!-- servlet 과 마찬 가지로 set캐릭터인코딩 -->
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%/*다른 jsp 에서 넘어온 데이터 받기  */
		String name,nickname;
	%>
	
	<%
		name = request.getParameter("mname");
		nickname = request.getParameter("mnickname");
		
	%>
	
	이름 : <%= name %>
	<br>
	별명 : <%= nickname %>

</body>
</html>