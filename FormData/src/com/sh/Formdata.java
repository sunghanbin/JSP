package com.sh;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/nFormdata")
public class Formdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Formdata() {
        super();
        // TODO Auto-generated constructor stub
    } 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("--doGet()--");
//		�������ʹ� http ��û �ȿ� �������� �Բ� ������ ������ ���ƿ��µ� �� ������ http ��û�� �Ķ���Ͱ� �ȴ�.
//		�Ķ������ ���� ���� ���ؼ� ����ϴ� �޼ҵ尡 request.getParameter �̴�
		String m_name = request.getParameter("m_name");
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
//		 ��� �� ���������� �����Ҽ� �ֱ� ������ �����͸� �迭�� �ޱ� ���ؼ� �迭�� ������ �����ϰ� �Ķ������ ��쵵 Values �� �޴´�
		String [] m_hobbys = request.getParameterValues("m_hobby");
		String m_residence = request.getParameter("m_residence");
		
		
//		���� ������ ���� ������ ������ �� ����Ʈ�� ����.
		
		System.out.println("name =" + m_name);
		System.out.println("pass =" + m_pass);
		System.out.println("gender =" + m_gender);
		System.out.println("hobbys =" + m_hobbys);
		System.out.println("residence =" + m_residence);
		
//		 Enumeration �� �������̽� �� ��ü���� ���� ���� ������ ��ü���� �Ѽ�����?? �ϳ��� ó���Ҽ� �ִ� �޼ҵ带 �����ϴ� �÷���
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name" + name);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ����Ʈ �� ���� ������ ������ ������ ��.
		System.out.println("--doPost()--");
		doGet(request, response);
	}

}
