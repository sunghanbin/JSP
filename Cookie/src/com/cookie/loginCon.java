package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
//		      요청으로 들어온 정보의 파라미터중 mid 와 mpw 의 속성을 변수에 담는다.
		String mID = request.getParameter("mID");
		String mPW = request.getParameter("mPW");
		
//		결과 출력 해 보기 
		out.print("mID = "+ mID);
		out.print("mID = "+ mPW);
		
//		쿠키는 여러가지 정보를 담고 있기 에 배열에 담아준다.
//		왜 request(요청)에서 쿠키를 가져오냐 하면 연결접속 정보(쿠키)는 클라이언트 에서 가지고 있기 때문이다.
//		쿠키즈 는 요청에 담겨 있는 쿠키를 담고 for in문 에서 확인 할수 있는데이터를 만들어 준것이다()
		Cookie[] cookies = request.getCookies();
//		cookie 객체로 쿠키라는 변수에 null값을 넣어준다
		Cookie cookie = null;
		
//		 for in문 오른쪽 정보를 왼쪽으로 넘겨 검사한다. 보통 for 루프를 이용하면 랭스나
//		int i 를 생성해 돌아야 하지만 이경우 데이터가 있을경우 하나씩담아서 다돌때 까지 스스로 하는것 같다 라는 내생각
//		 Cookie 라는 객체 타입으로 c 라는 변수를 만들어 cookies의 데이터를 하나씩 담아 검사한다.
		for(Cookie c : cookies){
//			c.getName....?
			System.out.println("c.getName()="+c.getName()+"c.getValue()="+c.getValue());
//			만약 쿠키에 memberId 라는 이름의 쿠키가 있다면 c 에 있는 쿠키를 null로 초기화한
//			 cookie 에 담아라 라는 뜻
			if(c.getName().equals("memberId")){
				cookie = c;
			}
		}
		
//		for 문이 끝난뒤에 cookie에 아무런 값이 담기지 않았다면(cookie 에 memberId 없었다면)
//		cookie 를 새로 생성 한다 객체 생성 쿠키의 (name)은 memberId 로 속성 은 요청온(request)에 있는 ID로 설정
		if(cookie ==null){
			System.out.println("cookie is null");
			cookie = new Cookie("memberId",mID);
		}
		
//		쿠키는 사용자가 가지고 있기 때문에 응답에(response) 쿠키를 붙혀(만들어 졌거나 있었거나) 보낸다. 
		response.addCookie(cookie);
//		쿠키의 유효 시간 을 만들어 준다. 3600초 1시간---- 1분에 60초 1시간 은 60분 
		cookie.setMaxAge(60*60);
		
//		로그인이완료 되었고 로그인 성공 페이지로  보내기 위해 Redirect-사전:(다른 주소·방향으로) 다시 보내다
		response.sendRedirect("loginOk.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
