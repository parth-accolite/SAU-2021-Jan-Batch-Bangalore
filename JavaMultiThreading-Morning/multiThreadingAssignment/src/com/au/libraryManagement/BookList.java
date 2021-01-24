package com.au.libraryManagement;

import java.util.ArrayList;

public class BookList {
	private ArrayList<Book> list;
	
	BookList(ArrayList<Book> list){
		this.list = list;
	}

	public ArrayList<Book> getList() {
		return list;
	}

	public void setList(ArrayList<Book> list) {
		this.list = list;
	}
	
	public void appendList(ArrayList<Book> list) {
		this.list.addAll(list);
	}
	public void addBook(Book book) {
		this.list.add(book);
	}
		public void listAll() {
			System.out.println("ID\tName\tISBN\tReviewer\tisInReview");
		for(Book b : this.list) {
			System.out.print(b.getId() + "\t");
			System.out.print(b.getName()+ "\t");
			System.out.print(b.getISBN()+ "\t");
			System.out.print(b.getReviewer()+ "\t");
			System.out.println(b.getIsInReview() + "\t");
			System.out.println(b.getIsInCart());
		}
	}
	
	public int length() {
		return this.list.size();
	}
}
