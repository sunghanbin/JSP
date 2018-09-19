package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RE")
public class req_rep extends HttpServlet {
							/* HttpServletRequest
							 * ��û�� ���� ������ ������ �ִ� ��ü // �̿��ڰ� �������� �α����̳� ������ ��û
							 * -�ֿ� �޼ҵ� 
							 * request.getCookies(); = ��Ű���� 		request.getParameter(null); ??
							 * request.getSession(); = ��������		request.getParameterNames(); ??
							 * request.getAttribute(null); = �Ӽ��� �����ü��ִ�	request.getParameterValues(null);  ??
							 * request.setAttribute(null,null); = �Ӽ����� �߰��Ҽ��ִ�.(�Ӽ�,�����Ӽ���)
							 * ================================================================
							 * HttpServletResponse
							 * ���信 ���� ������ ������ �ִ� ��ü // ������ �̿��ڿ��� �����͸� �ٶ�
							 * -�ֿ� �޼ҵ�
							 * response.addCookie(null); = 
							 * response.getStatus();
							 * response.sendRedirect();
							 * response.getWriter();
							 * response.getOutputStream();
							 */
    
    public req_rep() {
        super();
        
    }

//	 Ŭ������ �����Ҷ� �⺻ Ŭ������ ���� ���� �ʰ� servlet Ŭ������ �����ϱ� ������ servlet Ŭ������
//    �ݵ�� �ʿ��� httpServlet ����� ���� ������ Ŭ���� ���� ������� �ȴ�.
    
//    HttpServletRequest :��û��ü HttpServletResponse:���� ��ü
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
