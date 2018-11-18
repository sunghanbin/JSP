package com.servlet.DTO;

public class BookDTOO {
	// book 에대한 정보를 가지고 있으면된다.
	
	int bookId;
	String bookName;
	String bookloc;
	
	public BookDTOO(int bookId, String bookName, String bookloc) {
		// 들어온 값들을 자신의한테 변수배치
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
