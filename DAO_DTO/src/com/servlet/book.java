package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.DAO.bookDAO;
import com.servlet.DTO.BookDTOO;


@WebServlet("/book")
public class book extends HttpServlet {
	
       
   
    public book() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		���ڵ� 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
/*		
//		����Ŭ ����̹� 
		String driver = "oracle.jdbc.driver.OracleDriver";
//		����Ŭ ��������
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "SYSTEM";
		String pw = "root";
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);
			st = con.createStatement();
			String sql = "select * from book";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int bookid = rs.getInt("book_id");
				String bookname = rs.getString("book_name");
				String bookloc = rs.getString("book_loc");
				
				out.print("bookid :"+ bookid +"<br>");
				out.print("bookid :"+ bookname +"<br>");
				out.print("bookid :"+ bookloc +"<br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null)rs.close();
				if(st != null)st.close();
				if(con != null)con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	*/	
		// �����ͺ��̽��� ����ϴ� ����� dao ��ü ����
		bookDAO bookdao = new bookDAO();
		// ������ �޼ҵ尡 ���� �ȵ� ����� ���ʿ� ��´�. ����� bookdtoo ��� ��̸���Ʈ�� ������� Ŭ���� �λ���
		ArrayList<BookDTOO> list = bookdao.select();
		
		for(int i =0;i<list.size();i++) {
			BookDTOO dto = list.get(i);
			int bookId = dto.getBookId();
			String bookName = dto.getBookName();
			String bookloc = dto.getBookloc();
			
			out.print("bookid :"+ bookId +"<br>");
			out.print("bookid :"+ bookName +"<br>");
			out.print("bookid :"+ bookloc +"<br>");
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
