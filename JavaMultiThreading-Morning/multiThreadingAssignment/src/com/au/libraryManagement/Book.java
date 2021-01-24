package com.au.libraryManagement;

public class Book {
	private String name;
	private int id;
	private String ISBN;
	private Boolean isInReview;
	private String Reviewer;
	private Boolean isInCart;
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getReviewer() {
		return Reviewer;
	}
	public Boolean getIsInReview() {
		return isInReview;
	}	
	public Boolean getIsInCart() {
		return isInCart;
	}
	
	
	public void setIsInCart(Boolean isInCart) {
		this.isInCart = isInCart;
	}
	public void setIsInReview(Boolean isInReview) {
		this.isInReview = isInReview;
	}
	public void setReviewer(String Reviewer) {
		this.Reviewer = Reviewer;
	}
	public Book(String name, int id, String ISBN, String Reviewer, Boolean isInReview, Boolean isInCart) {
		super();
		this.name = name;
		this.id = id;
		this.ISBN = ISBN;
		this.Reviewer = Reviewer;
		this.isInReview = isInReview;
		this.isInCart = isInCart;
	}
	
	public void getDetails() {
		System.out.print(this.getId() + "\t");
		System.out.print(this.getName()+ "\t");
		System.out.print(this.getISBN()+ "\t");
		System.out.print(this.getReviewer()+ "\t");
		System.out.print(this.getIsInReview() + "\t");
		System.out.println(this.getIsInCart());
	}
}
