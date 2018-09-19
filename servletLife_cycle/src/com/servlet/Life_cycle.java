package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Life_cycle")
public class Life_cycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Life_cycle() {
        super();
        // TODO Auto-generated constructor stub
    }

//	servlet ���� �κ�   service �̿��ϴ°��� �幰��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("-- doget --");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//	���� ���� �Ǳ��� ��
	@PostConstruct
	public void postConstruct() {
		System.out.println("--postConstruct()--");
	}
	
//	����
	@Override
	public void init() throws ServletException {
		System.out.println("---init-------");
	}
//	����
	@Override
	public void destroy() {
		System.out.println("--destroy()--");
//		�ڿ� ���� �Ҷ�
	}
//	���� ����� �Ŀ� 
	@PreDestroy
	public void preDestroy() {
		System.out.println("-- preDestroy--");

	}

}
