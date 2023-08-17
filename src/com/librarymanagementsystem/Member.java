package com.librarymanagementsystem;

import java.util.ArrayList;

public class Member {
	private int memberId;
	private String name;
	private ArrayList<Integer> borrowedBooks = new ArrayList<>();

	public Member(int memberId, String name) {
		super();
		this.memberId = memberId;
		this.name = name;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(int borrowedBook) {
		this.borrowedBooks.add(borrowedBook);
	}

	public void unsetBorrowedBooks(int borrowedBook) {
		this.borrowedBooks.removeIf(b -> b == borrowedBook);
	}

	@Override
	public String toString() {
		return "memberId=" + memberId + ", name=" + name + ", borrowedBooks=" + borrowedBooks;
	}

}
