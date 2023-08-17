package com.librarymanagementsystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryManage {
	static List<Member> members = new ArrayList<>();
	static List<Book> books = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);

	// メイン メソッド
	public static void main(String[] args) {
		initializeMember();
		initializeBook();
		displayOptions();
	}

	// 図書館のメンバー一覧を配列に追加する
	public static void initializeMember() {
		members.add(new Member(1, "John"));
		members.add(new Member(2, "Mike"));
	}

	// 図書館の本一覧を配列に追加する
	public static void initializeBook() {
		books.add(new Book(1, "The Lord of the Rings", 0));
		books.add(new Book(2, "The Hobbit", 0));
		books.add(new Book(3, "Harry Potter and the Philosopher's Stone", 0));
		books.add(new Book(4, "Harry Potter and the Chamber of Secrets", 0));
	}

	// オプションの表示
	public static void displayOptions() {
		String selectedOption;

		do {
			System.out.println("Welcome to the library management system. Please choose an option:");
			System.out.println(
					"1. Display All Books\n2. Display All Members\n3. Lend Book\n4. Return Book\n5. Exit\nEnter your choice:");
			selectedOption = scan.nextLine();
			switch (selectedOption) {
			case "1":
				showAllBooks();
				break;
			case "2":
				showAllMembers();
				break;
			case "3":
				lendBook();
				break;
			case "4":
				returnBook();
				break;
			case "5":
				exit();
				break;
			default:
				System.out.println("Invalid choice. Please enter a number from 1-5.");
			}
		} while (true);
	}

	// システムの終了
	public static void exit() {
		System.out.println("Existing Library Management System. Goodbye!");
		scan.close();
		System.exit(0);
	}

	// 本一覧の表示
	public static void showAllBooks() {
		books.forEach(System.out::println);
	}

	// メンバー一覧の表示
	public static void showAllMembers() {
		members.forEach(System.out::println);
	}

	// 本を借りる
	public static void lendBook() {
		int lendBookId;
		int lendMemberId;
		int bookArrId = -1;
		do {

			System.out.println("Enter book ID:");

			try {
				lendBookId = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Please enter the valid input.");
				continue;
			}

			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getBookId() == lendBookId) {
					if (books.get(i).getLendFlag() == 0) {
						bookArrId = i;
						break;
					}
					System.out.println("Your choise is already lended.");
				}
			}
			if (bookArrId >= 0)
				break;
			System.out.println("Please enter the correct book ID");
		} while (true);

		do {

			System.out.println("Enter member ID:");

			try {
				lendMemberId = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Please enter the valid input.");
				continue;
			}

			for (int j = 0; j < members.size(); j++) {
				if (members.get(j).getMemberId() == lendMemberId) {
					books.get(bookArrId).setLendFlag(1);
					members.get(j).setBorrowedBooks(books.get(bookArrId).getBookId());
					break;
				}
			}

			if (books.get(bookArrId).getLendFlag() == 1)
				break;
			System.out.println("Please enter correct member ID");
		} while (true);

		System.out.println("Thank you!");
	}

	// 本を帰る
	public static void returnBook() {
		int lendBookId;
		int lendMemberId;
		int bookArrId = -1;
		do {

			System.out.println("Enter book ID:");

			try {
				lendBookId = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Please enter the valid input.");
				continue;
			}

			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getBookId() == lendBookId) {
					if (books.get(i).getLendFlag() == 1) {
						bookArrId = i;
						break;
					}
					System.out.println("Your choise is not lended.");
				}
			}
			if (bookArrId >= 0)
				break;
			System.out.println("Please enter the correct book ID");
		} while (true);

		do {

			System.out.println("Enter member ID:");

			try {
				lendMemberId = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Please enter the valid input.");
				continue;
			}

			for (int j = 0; j < members.size(); j++) {
				if (members.get(j).getMemberId() == lendMemberId
						&& members.get(j).getBorrowedBooks().contains(books.get(bookArrId).getBookId())) {
					books.get(bookArrId).setLendFlag(0);
					members.get(j).unsetBorrowedBooks(books.get(bookArrId).getBookId());
					break;
				}
			}

			if (books.get(bookArrId).getLendFlag() == 0)
				break;
			System.out.println("Please enter correct member ID");
		} while (true);

		System.out.println("Thank you!");
	}
}
