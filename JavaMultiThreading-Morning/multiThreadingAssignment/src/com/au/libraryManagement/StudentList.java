package com.au.libraryManagement;

import java.util.ArrayList;

public class StudentList {
	private ArrayList<Student> studentList;
	
	StudentList(ArrayList<Student> studentList){
		this.studentList = studentList;
	}

	public ArrayList<Student> getstudentList() {
		return studentList;
	}

	public void setstudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	
	public void getDetails() {
		for(Student s: this.studentList) {
			System.out.print(s.getId());
			System.out.print(s.getName());
			System.out.println(s.getDepartment());
//			System.out.println(s.get());
		}
	}

	public Student get(int i) {
		
		return this.studentList.get(i);
	}

}
