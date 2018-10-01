package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/params")
public class params extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		init-param 지정된 서블릿만 사용가능한 데이터
//		   			컴피그 객체 가져오기.그객체 로 부터 파라미터의 값을 가져온다(키)
		String id = getServletConfig().getInitParameter("adminId");
		String pw = getServletConfig().getInitParameter("adminPw");
		
//		서블릿에서 출력 하기 PrintWriter 객체로 출력 할수있다.
		
		PrintWriter out = response.getWriter();
		out.print("<P>adminId :"+ id + "</P>");
		out.print("<P>adminPw :"+ pw + "</P>");
		
//		context -param 모든 서블릿 공유가능 데이터
		
		String img = getServletContext().getInitParameter("imgDir");
		String IP = getServletContext().getInitParameter("testServerIP");
		
		out.print("<p>imgDir="+img+"</p>");
		out.print("<p>itestServerIp="+IP+"</p>");
		
		getServletContext().setAttribute("connectedIP", "165.66.33.33");
		getServletContext().setAttribute("connectedUser", "sunghanbin");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
