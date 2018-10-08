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
		
//		오라클 db 설정
		
//		오라클 드라이버 
		String driver = "oracle.jdbc.driver.OracleDriver";
//		오라클 접속정보
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "SYSTEM";
		String pw = "root";
		
//		java와 DB연결 접속정보를 접속할때 마다 초기화 하려고 null을 주는것 같다 ---- 강의에서는 Connection 로 선언함
		java.sql.Connection con = null;
//		 query 전송 객체  이부분도 접속할때 마다 그전 데이터를 지우기 위해서 null로 초기화 하는듯  ---- 강의에서는 Statement 로 선언함
		java.sql.Statement stmt = null;
		
//		 db 와 통신 할때 는 exception 문인 try~ catch 문 안에 작성해야 한다. 이유는 연결이 되지 않았을때 개발자와 클라이언트에게 알려주며 가장중요한것은 커넥션과 전송객체의 리소스를 
//		반환 시키기 위해서 인것 같다.
		
		try {
//			java 메모리 에 오라클 드라이버를 로딩 시키는 구문
			Class.forName(driver);
			
//			커넥션 정보들 
			con = DriverManager.getConnection(url, id, pw);
//			전송 객체 생성 
			stmt = con.createStatement();
//			db 에 던질 쿼리 작성
			String query = "insert into book(book_id,book_name ,book_loc)";
				   query += "values (book_seq.nextval,'" + bookname + "','" + bookloc +"')";
				   
//			실제 적으로 db와 통신하여 데이터를 주는 부분이 stmt.executeUpdate(query) 이부분이며 result 에 반환 되는 값은 몇개의 데이터가 입력 되었는지를 정수로 반환해준다.
			int result = stmt.executeUpdate(query);
			
//			아래 if 문은 데이터가 입력 되지 않았을 때를 사용자에게 알려주기위해 result 에 데이터가 몇개 입력되었는지 알려주기 때문에 만약 입력이 되지 않았다면 0이 나오게 된다.
			if(result > 0) {
				out.print("insert success!!");
			}else {
				out.print("insert fail!!");
			}
			
			
		} catch (Exception e) {
//			 오류 출력
			e.printStackTrace();
		}finally {
			try {
//				리소스 반환,해제
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
