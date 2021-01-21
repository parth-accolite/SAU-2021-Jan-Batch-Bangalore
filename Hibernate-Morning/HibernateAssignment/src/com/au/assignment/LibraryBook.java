package com.au.assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class LibraryBook {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String genre;
	
	@Column
	private String publisher;
	
	@Column
	private String releasedOn;
	
	public LibraryBook() {}
	
	public LibraryBook(String name, String genre, String publisher, String releasedOn) {
		super();
		this.name = name;
		this.genre = genre;
		this.publisher = publisher;
		this.releasedOn = releasedOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getReleasedOn() {
		return releasedOn;
	}

	public void setReleasedOn(String releasedOn) {
		this.releasedOn = releasedOn;
	}

	public int getId() {
		return id;
	}

	
}

//create table MOVIES (
//		   id INT NOT NULL auto_increment,
//		   name VARCHAR(20) default NULL,
//		   language  VARCHAR(20) default NULL,
//		   year     INT  default NULL,
//		   PRIMARY KEY (id)
//		);
//
//
//		create table genre (
//		   id INT NOT NULL auto_increment,
//		   movie_name VARCHAR(20) default NULL,
//		   genre_name  VARCHAR(20) default NULL,
//		   year     INT  default NULL,
//		   PRIMARY KEY (id)
//		);
