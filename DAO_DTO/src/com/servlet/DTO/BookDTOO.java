package com.servlet.DTO;

public class BookDTOO {
	// book ������ ������ ������ ������ȴ�.
	
	int bookId;
	String bookName;
	String bookloc;
	
	public BookDTOO(int bookId, String bookName, String bookloc) {
		// ���� ������ �ڽ������� ������ġ
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookloc = bookloc;
		
		
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookloc() {
		return bookloc;
	}

}
