package com.au.libraryManagement;

import java.util.ArrayList;

public class BookAdder implements Runnable{

	private BookBlockingQueue bbq;
	private String[] name;
	private int[] id;
	private String[] ISBN;
	private Boolean[] isOwned;
	private Boolean[] isInCart;

	public BookAdder(BookBlockingQueue bbq, String[] name, int[] id, String[] ISBN, Boolean[] isOwned, Boolean[] isInCart) {
		super();
		this.bbq = bbq;
		this.name = name;
		this.id = id;
		this.ISBN = ISBN;
		this.isOwned = isOwned;
		this.isInCart = isInCart;
		
	}

	@Override
	public void run() {
		for(int i=0;i<id.length;i++) {
//			 System.out.println("inserting book " + name[i] + " " +  id[i] + " " + ISBN[i]);
			Book b = new Book(this.name[i], this.id[i], this.ISBN[i],"Library",this.isOwned[i], this.isInCart[i]);
			try {
				bbq.put(b);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
	
}
