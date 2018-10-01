package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String mID = request.getParameter("mID");
		String mPW = request.getParameter("mPW");
		
		out.print("mID ="+mID);
		out.print("mPW ="+mPW);
		
//		세션에 대하여 세션은 사용자(클라이언트로 부터) 얻어낼수 있다.
//		 세션정보는 httpSession 인터페이스 에 담을수 있다.
		HttpSession session = request.getSession();
//		 멤버아이디 로 서버에 접속한 사용자의 id를 세션에 담아 준다.
		session.setAttribute("memberId",mID);
		
		response.sendRedirect("loginOK.jsp");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
