package com.au.spring;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Triangle {
	
	/* Question 1
	private Map<String,Point> points;
	public Map<String, Point> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}*/
	
	/*Question 2*/
	private HashSet<Point> points;
	
	public HashSet<Point> getPoints() {
		return points;
	}


	public void setPoints(HashSet<Point> points) {
		this.points = points;
	}
	
	/*
	private List<Point> points; 
	
	public List<Point> getPoints(){
		return points;
	}
	
	public void setPoints(List<Point> points){
		this.points = points;
	}
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}*/

	public void draw() {
		
		/* Question 1 part 1
		for(Map.Entry<String, Point> entry: points.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().getX() +"\t" +entry.getValue().getY());
		} */
		
		/* Question 1 part 2 */ 
		Iterator<Point> i= points.iterator();  
           while(i.hasNext())  
           {  
        	  Point temp = i.next();
        	   
        	  System.out.println(temp.getX() +"\t"+ temp.getY());  
           }  
		
		/*
		 * 
		for(Point point:points) {
			System.out.println("PointA = "+point.getX()+","+point.getY());
		}
		 * System.out.println("PointA"+getPointA().getX()+"PointA"+getPointA().getX());
		System.out.println("PointB"+getPointA().getX()+"PointB"+getPointB().getX());
		System.out.println("PointC"+getPointA().getX()+"PointC"+getPointC().getX());*/
	}

}
