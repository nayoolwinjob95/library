package com.librarymanagementsystem;

public class Book {
	private int bookId;
	private String title;
	private int lendFlag;

	public Book(int bookId, String title, int lendFlag) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.lendFlag = lendFlag;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLendFlag() {
		return lendFlag;
	}

	public void setLendFlag(int lendFlag) {
		this.lendFlag = lendFlag;
	}

	@Override
	public String toString() {
		return "bookId=" + bookId + ", title=" + title + ", lendFlag=" + lendFlag;
	}

}
