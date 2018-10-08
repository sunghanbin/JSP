package com.sql;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;


@WebServlet("/newbook")
public class newbook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public newbook() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String bookname = request.getParameter("bookname");
		String bookloc = request.getParameter("bookloc");
		
//		����Ŭ db ����
		
//		����Ŭ ����̹� 
		String driver = "oracle.jdbc.driver.OracleDriver";
//		����Ŭ ��������
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "SYSTEM";
		String pw = "root";
		
//		java�� DB���� ���������� �����Ҷ� ���� �ʱ�ȭ �Ϸ��� null�� �ִ°� ���� ---- ���ǿ����� Connection �� ������
		java.sql.Connection con = null;
//		 query ���� ��ü  �̺κе� �����Ҷ� ���� ���� �����͸� ����� ���ؼ� null�� �ʱ�ȭ �ϴµ�  ---- ���ǿ����� Statement �� ������
		java.sql.Statement stmt = null;
		
//		 db �� ��� �Ҷ� �� exception ���� try~ catch �� �ȿ� �ۼ��ؾ� �Ѵ�. ������ ������ ���� �ʾ����� �����ڿ� Ŭ���̾�Ʈ���� �˷��ָ� �����߿��Ѱ��� Ŀ�ؼǰ� ���۰�ü�� ���ҽ��� 
//		��ȯ ��Ű�� ���ؼ� �ΰ� ����.
		
		try {
//			java �޸� �� ����Ŭ ����̹��� �ε� ��Ű�� ����
			Class.forName(driver);
			
//			Ŀ�ؼ� ������ 
			con = DriverManager.getConnection(url, id, pw);
//			���� ��ü ���� 
			stmt = con.createStatement();
//			db �� ���� ���� �ۼ�
			String query = "insert into book(book_id,book_name ,book_loc)";
				   query += "values (book_seq.nextval,'" + bookname + "','" + bookloc +"')";
				   
//			���� ������ db�� ����Ͽ� �����͸� �ִ� �κ��� stmt.executeUpdate(query) �̺κ��̸� result �� ��ȯ �Ǵ� ���� ��� �����Ͱ� �Է� �Ǿ������� ������ ��ȯ���ش�.
			int result = stmt.executeUpdate(query);
			
//			�Ʒ� if ���� �����Ͱ� �Է� ���� �ʾ��� ���� ����ڿ��� �˷��ֱ����� result �� �����Ͱ� � �ԷµǾ����� �˷��ֱ� ������ ���� �Է��� ���� �ʾҴٸ� 0�� ������ �ȴ�.
			if(result > 0) {
				out.print("insert success!!");
			}else {
				out.print("insert fail!!");
			}
			
			
		} catch (Exception e) {
//			 ���� ���
			e.printStackTrace();
		}finally {
			try {
//				���ҽ� ��ȯ,����
				if(stmt != null)stmt.close();
				if(con != null)con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
