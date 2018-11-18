package com.servlet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.servlet.DTO.BookDTOO;

public class bookDAO {
	
//	오라클 드라이버 
	String driver = "oracle.jdbc.driver.OracleDriver";
//	오라클 접속정보
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String id = "SYSTEM";
	String pw = "root";
	
	
//	디폴트 생성자 -- 객체를 생성 하게되면 바로 메모리에 드라이버를 로딩 시킨다.
	public bookDAO() {
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//select 라는메소드를 생성해준다.
	// object 에는 dto 클래스가 담기게 된다.
	// 이메소드를 사용하게 된다면 어레이 리스트담기는 값은 bookDTOO 클래스를 받아준다.
	public ArrayList<BookDTOO> select() {
		
		ArrayList<BookDTOO> list = new ArrayList<BookDTOO>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet set = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			String sql = "select * from book";
			pst = con.prepareStatement(sql);
			set = pst.executeQuery();
			
			
			while (set.next()) {
				int bookId = set.getInt("book_Id");
				String bookName = set.getString("book_name");
				String bookloc = set.getString("book_loc");
				
				BookDTOO bookDTO = new BookDTOO(bookId, bookName, bookloc);
				list.add(bookDTO);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(set != null)set.close();
				if(pst != null)pst.close();
				if(con != null)con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	return list;
	}

}
