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

//	servlet 실행 부분   service 이용하는경우는 드물다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("-- doget --");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//	서블릿 생성 되기전 에
	@PostConstruct
	public void postConstruct() {
		System.out.println("--postConstruct()--");
	}
	
//	생성
	@Override
	public void init() throws ServletException {
		System.out.println("---init-------");
	}
//	종료
	@Override
	public void destroy() {
		System.out.println("--destroy()--");
//		자원 해제 할때
	}
//	서블릿 종료된 후에 
	@PreDestroy
	public void preDestroy() {
		System.out.println("-- preDestroy--");

	}

}
