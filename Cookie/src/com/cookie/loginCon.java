package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
//		      ��û���� ���� ������ �Ķ������ mid �� mpw �� �Ӽ��� ������ ��´�.
		String mID = request.getParameter("mID");
		String mPW = request.getParameter("mPW");
		
//		��� ��� �� ���� 
		out.print("mID = "+ mID);
		out.print("mID = "+ mPW);
		
//		��Ű�� �������� ������ ��� �ֱ� �� �迭�� ����ش�.
//		�� request(��û)���� ��Ű�� �������� �ϸ� �������� ����(��Ű)�� Ŭ���̾�Ʈ ���� ������ �ֱ� �����̴�.
//		��Ű�� �� ��û�� ��� �ִ� ��Ű�� ��� for in�� ���� Ȯ�� �Ҽ� �ִµ����͸� ����� �ذ��̴�()
		Cookie[] cookies = request.getCookies();
//		cookie ��ü�� ��Ű��� ������ null���� �־��ش�
		Cookie cookie = null;
		
//		 for in�� ������ ������ �������� �Ѱ� �˻��Ѵ�. ���� for ������ �̿��ϸ� ������
//		int i �� ������ ���ƾ� ������ �̰�� �����Ͱ� ������� �ϳ�����Ƽ� �ٵ��� ���� ������ �ϴ°� ���� ��� ������
//		 Cookie ��� ��ü Ÿ������ c ��� ������ ����� cookies�� �����͸� �ϳ��� ��� �˻��Ѵ�.
		for(Cookie c : cookies){
//			c.getName....?
			System.out.println("c.getName()="+c.getName()+"c.getValue()="+c.getValue());
//			���� ��Ű�� memberId ��� �̸��� ��Ű�� �ִٸ� c �� �ִ� ��Ű�� null�� �ʱ�ȭ��
//			 cookie �� ��ƶ� ��� ��
			if(c.getName().equals("memberId")){
				cookie = c;
			}
		}
		
//		for ���� �����ڿ� cookie�� �ƹ��� ���� ����� �ʾҴٸ�(cookie �� memberId �����ٸ�)
//		cookie �� ���� ���� �Ѵ� ��ü ���� ��Ű�� (name)�� memberId �� �Ӽ� �� ��û��(request)�� �ִ� ID�� ����
		if(cookie ==null){
			System.out.println("cookie is null");
			cookie = new Cookie("memberId",mID);
		}
		
//		��Ű�� ����ڰ� ������ �ֱ� ������ ���信(response) ��Ű�� ����(����� ���ų� �־��ų�) ������. 
		response.addCookie(cookie);
//		��Ű�� ��ȿ �ð� �� ����� �ش�. 3600�� 1�ð�---- 1�п� 60�� 1�ð� �� 60�� 
		cookie.setMaxAge(60*60);
		
//		�α����̿Ϸ� �Ǿ��� �α��� ���� ��������  ������ ���� Redirect-����:(�ٸ� �ּҡ���������) �ٽ� ������
		response.sendRedirect("loginOk.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
