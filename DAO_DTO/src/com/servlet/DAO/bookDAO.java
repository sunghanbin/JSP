package com.servlet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.servlet.DTO.BookDTOO;

public class bookDAO {
	
//	����Ŭ ����̹� 
	String driver = "oracle.jdbc.driver.OracleDriver";
//	����Ŭ ��������
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String id = "SYSTEM";
	String pw = "root";
	
	
//	����Ʈ ������ -- ��ü�� ���� �ϰԵǸ� �ٷ� �޸𸮿� ����̹��� �ε� ��Ų��.
	public bookDAO() {
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//select ��¸޼ҵ带 �������ش�.
	// object ���� dto Ŭ������ ���� �ȴ�.
	// �̸޼ҵ带 ����ϰ� �ȴٸ� ��� ����Ʈ���� ���� bookDTOO Ŭ������ �޾��ش�.
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
