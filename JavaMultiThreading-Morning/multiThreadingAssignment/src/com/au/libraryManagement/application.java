package com.au.libraryManagement;

import java.util.ArrayList;

public class application {
//	private static BookList bookList;
	private static ArrayList<Student> studentList =new ArrayList<Student>();
	private static ArrayList<Book> bookList = new ArrayList<Book>();
	public static void main(String[] args) {
		initializeStudents();
		BookBlockingQueue bbq = new BookBlockingQueue();
		initializeBooks(bbq);
		
//		System.out.println("ID\tName\tISBN\tOwner\tisOwned");
//		bbq.listBooks();
		bookList = bbq.listBooks();
		
		String[] booksToBeBought = {"001"};
		Thread transcation1 = new Thread(new BookCart(bbq,studentList.get(0),findBookByISBN(booksToBeBought)));
		transcation1.run();
//		bbq.listBooks();

		booksToBeBought  = new String[] {"004","003","002"};

		System.out.println("-------------------------adding multiple books to cart-------------------------------");
		Thread transcation2 = new Thread(new BookCart(bbq,studentList.get(4),findBookByISBN(booksToBeBought)));
		transcation2.run();
//		bbq.listBooks();

		addNewBooks(bbq);
		
		booksToBeBought  = new String[] {"005"};
		Thread transcation3 = new Thread(new BookCart(bbq,studentList.get(4),findBookByISBN(booksToBeBought)));
		transcation3.run();	
		bbq.listBooks();

		String[] bookToBeReviewed = {"004"}; 
		Thread transcation4 = new Thread(new BookReviewer(bbq,studentList.get(2), findBookByISBN(bookToBeReviewed)));
		transcation4.run();	

		bookToBeReviewed = new String[] {"001"};
		Thread transcation5 = new Thread(new BookReviewer(bbq,studentList.get(6), findBookByISBN(bookToBeReviewed)));
		transcation5.run();	

		bbq.listBooks();
		
		bookToBeReviewed = new String[] {"004"};
		Thread transcation6 = new Thread(new BookReviewer(bbq,studentList.get(5), findBookByISBN(bookToBeReviewed)));
		transcation6.run();	

		bbq.listBooks();
		
		System.out.println("Books bought by students");
		for(Student student: studentList) {
			student.getBoughtBooks();
			student.getReviewBooks();
		}
		bbq.listBooks();

	}

	private static ArrayList<Book> findBookByISBN(String[] isbnList) {
		ArrayList<Book> books = new ArrayList<Book>();
		for(String isbn : isbnList) {
			for(int i = 0; i < bookList.size();i++) {
				if(bookList.get(i).getISBN() == isbn && !bookList.get(i).getIsInReview() && !bookList.get(i).getIsInCart()) {
					books.add(bookList.get(i));
					break;
				}
			}
		}
		return books;
	}
	private static void initializeBooks(BookBlockingQueue bbq) {
		String[] name = {"1","1","2","2","2","3","4","4","4","4"};
		int[] id = 		{ 1 , 2 , 1 , 2 , 3 , 1 , 1 , 2 , 3 , 4 };
		String[] ISBN = {"001","001","002","002","002","003","004","004","004","004"};
		Boolean [] isOwned = {false,false,false,false,false,false,false,false,false,false};
		
		Boolean[] isInCart = {false,false,false,false,false,false,false,false,false,false}; 
		
		Thread initializingBookList = new Thread(new BookAdder(bbq,name,id,ISBN,isOwned,isInCart));
		initializingBookList.run();
		
	}


	public static void addNewBooks(BookBlockingQueue bbq) {
		
		String[] nameNew = {"5"};
		int[] idNew = 		{ 5};
		String[] ISBNNew= {"005"};
		Boolean [] isOwnedNew = {false};
		Boolean [] isInCart = {false};
		Thread addNewBookList = new Thread(new BookAdder(bbq,nameNew,idNew,ISBNNew,isOwnedNew, isInCart));
		addNewBookList.run();

		System.out.println("All the books in the library are: ");
		System.out.println("ID\tName\tISBN\tOwner\tisOwned");
		bbq.listBooks();
		
	}
	

	  public static void initializeStudents() {
		String[] name = {"A","B","C","D","E","F","G","H","I","J"};
		int[] id = 		{ 1 , 2 , 1 , 2 , 3 , 1 , 1 , 2 , 3 , 4 };
		String[] department = {"comp","comp","it","it","it","extc","etrx","etrx","etrx","etrx"};

		for(int i=0;i<10;i++) {
//			 System.out.println("inserted student " + name[i] + " " +  id[i] + " " + department[i]);
			Student b = new Student(name[i], id[i], department[i]);
			studentList.add(b);
		}
		System.out.println("added students");
//		return studentList;
	}

/*	
	public static ArrayList<Book> generateBooks() {
		ArrayList<Book> bookList =new ArrayList<Book>();
		String[] name = {"1","1","2","2","2","3","4","4","4","4"};
		int[] id = 		{ 1 , 2 , 1 , 2 , 3 , 1 , 1 , 2 , 3 , 4 };
		String[] ISBN = {"001","001","002","002","002","003","004","004","004","004"};
		Boolean [] isOwned = {false,false,false,false,false,false,false,false,false,false};
		for(int i=0;i<10;i++) {
//			 System.out.println("inserted book " + name[i] + " " +  id[i] + " " + ISBN[i]);
			Book b = new Book(name[i], id[i], ISBN[i],"Library",isOwned[i]);
//			bookList.length;
			bookList.add(b);
		}
		return bookList;
	}*/

}
