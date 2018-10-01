package com.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginoutCon")
public class loginoutCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 요청으로 세션 정보 가져와서
		HttpSession session = request.getSession();
//		세션 해제 .invalidate()
		session.invalidate();
//		해제후 로그인 페이지로 돌아가도록
		response.sendRedirect("login.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
