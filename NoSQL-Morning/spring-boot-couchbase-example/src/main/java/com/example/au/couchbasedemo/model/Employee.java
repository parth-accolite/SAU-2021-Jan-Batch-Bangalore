package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import com.sun.istack.NotNull;


@Document	
public class Employee {
	
	@Id
	private String empId;
	
	@NotNull
	@Field
	private String empName;
	
	@NotNull
	@Field
	private String location;
	
	@NotNull
	@Field
	private String pinCode;
	
	
	public Employee(String empId, String empName, String location, String pinCode) {
		this.empId = empId;
		this.empName = empName;
		this.location= location;
		this.pinCode = pinCode;
		
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
