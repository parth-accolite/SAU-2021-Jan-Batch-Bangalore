package com.au.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LibraryManager {

	private static SessionFactory factory;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
			
		} catch (Exception e) {
			System.err.println(e);// TODO: handle exception
		}
		LibraryManager libManager = new LibraryManager();
		
//		libManager.addBook();
//		libManager.getBooks();
//		libManager.updateBookByID(3);
//		libManager.deleteBookById(4);
		
		int countOfBooks = libManager.getBooks();
		System.out.println("There are " + countOfBooks +" books in the library currently");
		
		
		
	}
	private void deleteBookById(int id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LibraryBook book = session.get(LibraryBook.class,id);
			System.out.println("Book to be deleted");
			System.out.print(book.getId()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.print(book.getPublisher()+"\t");
			System.out.print(book.getGenre()+"\t");
			System.out.println(book.getReleasedOn());
			
			session.delete(book);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
		
	}
	private void updateBookByID(int id) {
		System.out.println("----------------Update Book Id "+id+"----------------");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LibraryBook book = session.get(LibraryBook.class, id);
			System.out.println("Fetched Book Details for id"+id);
			System.out.print(book.getId()+"\t");
			System.out.print(book.getName()+"\t");
			System.out.print(book.getPublisher()+"\t");
			System.out.print(book.getGenre()+"\t");
			System.out.println(book.getReleasedOn());
			
			book.setName("2020 Edition Rich dad Poor dad");
			book.setReleasedOn("2020");
			
			session.update(book);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();
		}
	}
	private int getBooks() {
		System.out.println("----------------Fetching Books----------------");
		
		Session session = factory.openSession();
		Transaction tx = null;
		int count= 0;
		try {
			tx = session.beginTransaction();
			List<LibraryBook> libBooks = session.createQuery("FROM LibraryBook").list();
			System.out.println("All the books are fetched from the DB. They are");
			count = libBooks.size();
			
			for(LibraryBook book : libBooks) {
				System.out.print(book.getId()+"\t");
				System.out.print(book.getName()+"\t");
				System.out.print(book.getPublisher()+"\t");
				System.out.print(book.getGenre()+"\t");
				System.out.println(book.getReleasedOn());
			}
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
		return count;
	}
	private static void addBook() {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		String[] bookNames = {"Harry Potter", "Rich dad Poor dad","Da vince Code", "Famous Five", "Angels and Demons"};
		String[] bookGenres = {"Thriller", "Educational", "Adventure", "Adventure", "Action"};
		String[] publisher = {"JK ROwling", "Robert Kiyosaki","Dan Brown", "Enid Blyton", "Dan Brown"};
		String [] releasedOn = {"2000","2002","2004","2006","2008"};
		
		for(int i=0; i<5;i++) {
			try {
				tx = session.beginTransaction();
				LibraryBook libBook = new LibraryBook( bookNames[i] ,bookGenres[i] ,publisher[i] ,releasedOn[i] );
				bookId = (Integer) session.save(libBook);
				tx.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if(tx!=null)
					tx.rollback();
			}finally {
//				session.close();
				System.out.println("Details of added book ");
				System.out.println(bookNames[i]+"\t " +bookGenres[i]+"\t " +publisher[i]+"\t " +releasedOn[i]);
				
			}
		}
		session.close();
//		return bookId;
	}
	
	

}
