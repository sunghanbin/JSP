<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 쿠키가 있는 사용자에게는 현재 로그인 폼화면을 보여줄 필요가 없다. 
	그렇기 때문에  아래와 같이 쿠키 가 있는 사용자가 로그인 화면 에 들어왔을 때 처리 하는방법 -->
	
	<%
	 Cookie[] cookies = request.getCookies();
	/* 백엔드에서 만 처리 결과 볼수있도록 보여준다. */
	System.out.print("cookies :" +cookies);
	 
	if(cookies != null){
		/* 만약 cookies 가 널이 아니라면 바로 리다이렉트 해도 되겠지만
			memberId 가아닌 다른 쿠키를 가지고 있어도 널이 아니기 때문에 for in문으로 검사 해준다.*/
		for(Cookie c : cookies){
			if(c.getName().equals("memberId")){
				/* 최종적으로 쿠키가 널도 아니고 가지고 있는 쿠키이름이 멤버 아이디라면 리다이렉트 */
				response.sendRedirect("loginOk.jsp");
			}
		}
	}
	%>

	<form action="loginCon" method="post">
	
	ID : <input type="text" name="mID"><br>
	PW : <input type="password" name="mPW"><br>
	<input type="submit" value="login">
	
	</form>

</body>
</html>