package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Blogs {
    
    @Id
    String id;
    
    @NotNull
    @Field
    String topic;
    
    @NotNull
    @Field
    String author;
    
    @Field
    String tag1;
    
    @Field
    String tag2;
    
    public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	@Field
    String tag3;
    
    @Field
    Date date;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String gettag1() {
		return tag1;
	}

	public void settag1(String tag1) {
		this.tag1 = tag1;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public Blogs(String id, String topic, String author, String tag1, String tag2, String tag3, Date date) {
		super();
		this.id = id;
		this.topic = topic;
		this.author = author;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.date = date;
	}
    
    
    
}
