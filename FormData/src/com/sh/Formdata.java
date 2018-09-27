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
//		폼데이터는 http 요청 안에 폼내용이 함께 끼워져 서버로 날아오는데 폼 내용이 http 요청의 파라미터가 된다.
//		파라미터의 값을 얻어내기 위해서 사용하는 메소드가 request.getParameter 이다
		String m_name = request.getParameter("m_name");
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
//		 취미 는 여러가지를 선택할수 있기 때문에 데이터를 배열로 받기 위해서 배열로 변수를 선언하고 파라미터의 경우도 Values 로 받는다
		String [] m_hobbys = request.getParameterValues("m_hobby");
		String m_residence = request.getParameter("m_residence");
		
		
//		위에 정보를 넣은 변수를 보기위 해 프린트로 찍어보자.
		
		System.out.println("name =" + m_name);
		System.out.println("pass =" + m_pass);
		System.out.println("gender =" + m_gender);
		System.out.println("hobbys =" + m_hobbys);
		System.out.println("residence =" + m_residence);
		
//		 Enumeration 은 인터페이스 로 객체들의 집합 에서 각각의 개체들을 한순간에?? 하나씩 처리할수 있는 메소드를 제공하는 컬렉션
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name" + name);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 포스트 로 받은 정보를 겟으로 포워딩 함.
		System.out.println("--doPost()--");
		doGet(request, response);
	}

}
