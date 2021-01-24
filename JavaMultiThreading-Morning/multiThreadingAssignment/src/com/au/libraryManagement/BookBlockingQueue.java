package com.au.libraryManagement;

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BookBlockingQueue {
	
	private BookList bookList;
	private Lock lock = new ReentrantLock();
	private Condition addBookCondition = lock.newCondition();
	private Condition buyerCondition = lock.newCondition();
	private ArrayList<Book> blockingQueue = new ArrayList<Book>();
	private int bookCount = 0;
	
	BookBlockingQueue(){
//		this.bookList = bookList;
	}
		
	public ArrayList<Book> listBooks() {
		System.out.println("----------List of Books----------");
		for(Book b: blockingQueue) {
			try {
				b.getDetails();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return blockingQueue;
	}
	public void removeFromCart(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
				if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
					blockingQueue.get(i).setIsInCart(false);
					blockingQueue.get(i).setReviewer("Library");
					break;
				}
			}
			addBookCondition.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();	
		}
	}
	
	public void addToCart(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			if(student.doesOwnBook(book)) {
				System.out.println("the Student already owns a copy of the book. You cannot add it to cart");
				return;
			}
			for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
				if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
					blockingQueue.get(i).setIsInCart(true);
					blockingQueue.get(i).setReviewer(student.getId() + "^" + student.getDepartment());
					break;
				}
			}
			addBookCondition.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();

		}
	}
	
	public void put(Book book) throws InterruptedException{
		lock.lock();
//		System.out.println("Lock acquired for \t");
//		book.getDetails();
		try {
			blockingQueue.add(book);
//			System.out.print("added book\t");
//			book.getDetails();
			bookCount++;
			buyerCondition.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
//			System.out.println("Releasing the Lock");
			lock.unlock();
		}
	}
	
	public Object review(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			if(book == null) {
				System.out.println("No Book exists");
				return null;
			}
			while(bookCount == 0) {
				buyerCondition.await();
			}
			if(student.doesOwnBook(book)) {
				System.out.println("the Student already owns a copy of the book. You cannot take it for review");
				return null;
			}
			for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
				if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
					blockingQueue.get(i).setIsInReview(true);
					blockingQueue.get(i).setReviewer(student.getId() + "^" + student.getDepartment());
					student.addReviewBook(blockingQueue.get(i));
					break;
				}
			}
			addBookCondition.signalAll();
			return null;
		} finally{
			lock.unlock();
		}		
	}
	
	public Object checkout(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			while(bookCount == 0) {
				buyerCondition.await();
			}
			if(student.doesOwnBook(book)) {
				System.out.println("the Student already owns a copy of the book. Purchase cannot move forward");
				return null;
			}
			for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
				if(blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
					blockingQueue.get(i).setIsInReview(true);
					blockingQueue.get(i).setReviewer(student.getId() + "^" + student.getDepartment());
					student.addBoughtBook(blockingQueue.get(i));
					blockingQueue.remove(i);
					break;
				}
			}
			System.out.println("book bought");
			addBookCondition.signalAll();
			return null;
		} finally{
			lock.unlock();
		}
	}	
}
