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
		
//		인코딩 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
/*		
//		오라클 드라이버 
		String driver = "oracle.jdbc.driver.OracleDriver";
//		오라클 접속정보
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
		// 데이터베이스와 통신하는 모듈인 dao 객체 생성
		bookDAO bookdao = new bookDAO();
		// 오른쪽 메소드가 실행 된뒤 결과를 왼쪽에 담는다. 결과는 bookdtoo 라는 어레이리스트로 만들어준 클래스 로생성
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
