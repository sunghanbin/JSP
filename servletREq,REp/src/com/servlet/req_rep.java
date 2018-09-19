package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RE")
public class req_rep extends HttpServlet {
							/* HttpServletRequest
							 * 요청에 대한 정보를 가지고 있는 객체 // 이용자가 서버에게 로그인이나 데이터 요청
							 * -주요 메소드 
							 * request.getCookies(); = 쿠키정보 		request.getParameter(null); ??
							 * request.getSession(); = 세션정보		request.getParameterNames(); ??
							 * request.getAttribute(null); = 속성값 가져올수있다	request.getParameterValues(null);  ??
							 * request.setAttribute(null,null); = 속성값을 추가할수있다.(속성,넣을속성값)
							 * ================================================================
							 * HttpServletResponse
							 * 응답에 대한 정보를 가지고 있는 객체 // 서버가 이용자에게 데이터를 줄때
							 * -주요 메소드
							 * response.addCookie(null); = 
							 * response.getStatus();
							 * response.sendRedirect();
							 * response.getWriter();
							 * response.getOutputStream();
							 */
    
    public req_rep() {
        super();
        
    }

//	 클래스를 생성할때 기본 클래스로 생성 하지 않고 servlet 클래스로 생성하기 때문에 servlet 클래스의
//    반드시 필요한 httpServlet 상속을 받은 상태의 클래스 가만 들어지게 된다.
    
//    HttpServletRequest :요청객체 HttpServletResponse:응답 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
