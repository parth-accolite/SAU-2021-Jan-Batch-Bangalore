package com.au.libraryManagement;

import java.util.ArrayList;

public class BookCart implements Runnable{

	private BookBlockingQueue bbq;
	private Student student;
	private ArrayList<Book> bookList;
	BookCart(BookBlockingQueue bbq, Student student, ArrayList<Book> bookList) {
		super();
		this.bbq = bbq;
		this.student = student;
		this.bookList= bookList;
	}

	@Override
	public void run() {
		try {
			System.out.println("inside cart");
			for(Book book : bookList) {
				book.getDetails();
				bbq.addToCart(student, book);	
			}
			System.out.println("list of books from cart----------------");
			bbq.listBooks();
			System.out.println("----------done ----------");
			Thread t = new Thread(new BookBuyer(bbq,student,bookList.get(0)));
			t.run();
			bookList.remove(0);
			
			if(bookList.size() > 0) {
				Thread.sleep(5000);
				for(Book book: bookList) {
					bbq.removeFromCart(student,book);		
				}
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
