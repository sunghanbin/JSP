<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- ��Ű�� �ִ� ����ڿ��Դ� ���� �α��� ��ȭ���� ������ �ʿ䰡 ����. 
	�׷��� ������  �Ʒ��� ���� ��Ű �� �ִ� ����ڰ� �α��� ȭ�� �� ������ �� ó�� �ϴ¹�� -->
	
	<%
	 Cookie[] cookies = request.getCookies();
	/* �鿣�忡�� �� ó�� ��� �����ֵ��� �����ش�. */
	System.out.print("cookies :" +cookies);
	 
	if(cookies != null){
		/* ���� cookies �� ���� �ƴ϶�� �ٷ� �����̷�Ʈ �ص� �ǰ�����
			memberId ���ƴ� �ٸ� ��Ű�� ������ �־ ���� �ƴϱ� ������ for in������ �˻� ���ش�.*/
		for(Cookie c : cookies){
			if(c.getName().equals("memberId")){
				/* ���������� ��Ű�� �ε� �ƴϰ� ������ �ִ� ��Ű�̸��� ��� ���̵��� �����̷�Ʈ */
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