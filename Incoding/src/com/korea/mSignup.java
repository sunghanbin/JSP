package com.korea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mSignup")
public class mSignup extends HttpServlet {

       
    
    public mSignup() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		post 방식에서의 한글 처리 jsp ----> servlet 로 보낼때
//		요청한 데이터 가 온다 면 set(다시설정) 인코딩을
		
		request.setCharacterEncoding("UTF-8");
		
//		응답 줄때 
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("mname");
		String nickname = request.getParameter("mnickname");
		
		PrintWriter out = response.getWriter();
		
		out.print("<p>name = "+name+"</p>");
		out.print("<p>mnickname = "+nickname+"</p>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
