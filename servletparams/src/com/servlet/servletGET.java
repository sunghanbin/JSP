package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletGET")
public class servletGET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String IP = (String)getServletContext().getAttribute("connectedIP");
		String user = (String)getServletContext().getAttribute("connectedUser");
		
		PrintWriter out =response.getWriter();
		
		out.print("<p>"+IP+"</p>");
		out.print("<p>"+user+"</p>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
