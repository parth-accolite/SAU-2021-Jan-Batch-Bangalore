package com.au.libraryManagement;

import java.util.ArrayList;

public final class Student {
	private String name;
	private int id;
	private String department;
	private ArrayList<Book> boughtBooks;
	private ArrayList<Book> reviewBooks;

	public Student(String name, int id, String department) {
		super();
		this.name = name;
		this.id = id;
		this.department = department;
		this.boughtBooks = new ArrayList<Book>();
		this.reviewBooks = new ArrayList<Book>();
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public String getDepartment() {
		return department;
	}
		
	public void addReviewBook(Book book) {
		this.reviewBooks.add(book);
	}
	public void getReviewBooks() {
		try {
//			System.out.println("get books");
			if(reviewBooks.size() > 0) {
				System.out.println(this.name +"'s review books are");
				for(Book book : reviewBooks) {
					book.getDetails();	
				}
			}else {
				System.out.println("No books taken for review by "+this.name);

			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addBoughtBook(Book book) {
		this.boughtBooks.add(book);
	}
	public void getBoughtBooks() {
		try {
//			System.out.println("get books");
			if(boughtBooks.size() > 0) {
				System.out.println(this.name +"'s bought books are");
				for(Book book : boughtBooks) {
					book.getDetails();	
				}
			}else {
				System.out.println("No books purchased by " + this.name);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public boolean doesOwnBook(Book book) {
		for(Book bk: boughtBooks) {
			if(bk.getISBN() == book.getISBN()) {
				return true;
			}
		}
		return false;
	}
	
}
