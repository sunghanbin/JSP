package com.sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;


@WebServlet("/SelectBook")
public class SelectBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SelectBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
//		오라클 db 설정
		
//		오라클 드라이버 
		String driver = "oracle.jdbc.driver.OracleDriver";
//		오라클 접속정보
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "SYSTEM";
		String pw = "root";
		
		
		java.sql.Connection con = null;
		java.sql.Statement stmt = null;
//		 데이터를 select 하게되면 많은 정보가 오기 때문에 Result 가 아닌 ResultSet 으로 받는다.
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			String sql = "select * from book";
//			조회 쿼리는 executeQuery 를 사용한다.
			rs = stmt.executeQuery(sql);
			
			
//			ResultSet 의 메소드 next를 이용하여 데이터를 뽑아낼수 있다. 커서뒤에 데이터
			while(rs.next()) {
				int bookID = rs.getInt("book_id");
				String bookname = rs.getString("book_name");
				String bookloc = rs.getString("book_loc");
				
				out.print("bookid = "+ bookID +"<br>"+"bookname = "+bookname+"<br>"+"bookloc = "+bookloc);
						
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		try {
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();
			if(con != null)con.close();
			}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
