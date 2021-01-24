package com.au.libraryManagement;

public class BookBuyer implements Runnable{

	private BookBlockingQueue bbq;
	private Student student;
	private Book book;
	public BookBuyer(BookBlockingQueue bbq, Student student, Book book) {
		super();
		this.bbq = bbq;
		this.student = student;
		this.book= book;
	}
	@Override
	public void run() {
		// new Book(this.name[i], this.id[i], this.ISBN[i],"Library",this.isOwned[i]);
		try {
			bbq.checkout(student,book);
//			book.getDetails();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}