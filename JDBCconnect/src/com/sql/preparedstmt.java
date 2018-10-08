package com.sql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/preparedstmt")
public class preparedstmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public preparedstmt() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter  out = response.getWriter();
		
//		오라클 드라이버 
		String driver = "oracle.jdbc.driver.OracleDriver";
//		오라클 접속정보
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "SYSTEM";
		String pw = "root";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw);
			
//			 ? 는 내가 넣을 정보 를 비워 둔다. 직접 넣는 스테이트먼트 는 퀄리가 복잡하고 휴먼에러가 나오기 쉽다 
			String sql = "update book set book_loc = ? where 1=1 and book_id =  ?";
			
			pstmt = con.prepareStatement(sql);
//			내가 넣을 정보를 물음표의 번호 index를 쓴후 입력 하면 된다. 
			pstmt.setString(1,"1234562");
			pstmt.setInt(2, 1);
			
			int n = pstmt.executeUpdate();
			
			if(n > 0) {
				out.print("update success!");
			}else {
				out.print("update fail!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
