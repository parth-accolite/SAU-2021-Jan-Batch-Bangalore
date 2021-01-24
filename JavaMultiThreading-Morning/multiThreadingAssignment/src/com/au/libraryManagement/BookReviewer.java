package com.au.libraryManagement;

import java.util.ArrayList;

public class BookReviewer implements Runnable{
	
	private BookBlockingQueue bbq;
	private Student student;
	private ArrayList<Book> book;
	
	BookReviewer(BookBlockingQueue bbq, Student student, ArrayList<Book> book) {
		super();
		this.bbq = bbq;
		this.student = student;
		this.book= book;
	}
	@Override
	public void run() {
		// new Book(this.name[i], this.id[i], this.ISBN[i],"Library",this.isOwned[i]);
		try {
			bbq.review(student,book.get(0));
//			book.getDetails();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
