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
	
//		init-param ������ ������ ��밡���� ������
//		   			���Ǳ� ��ü ��������.�װ�ü �� ���� �Ķ������ ���� �����´�(Ű)
		String id = getServletConfig().getInitParameter("adminId");
		String pw = getServletConfig().getInitParameter("adminPw");
		
//		�������� ��� �ϱ� PrintWriter ��ü�� ��� �Ҽ��ִ�.
		
		PrintWriter out = response.getWriter();
		out.print("<P>adminId :"+ id + "</P>");
		out.print("<P>adminPw :"+ pw + "</P>");
		
//		context -param ��� ���� �������� ������
		
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
