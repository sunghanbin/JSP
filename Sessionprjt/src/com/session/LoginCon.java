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
		
//		���ǿ� ���Ͽ� ������ �����(Ŭ���̾�Ʈ�� ����) ���� �ִ�.
//		 ���������� httpSession �������̽� �� ������ �ִ�.
		HttpSession session = request.getSession();
//		 ������̵� �� ������ ������ ������� id�� ���ǿ� ��� �ش�.
		session.setAttribute("memberId",mID);
		
		response.sendRedirect("loginOK.jsp");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
