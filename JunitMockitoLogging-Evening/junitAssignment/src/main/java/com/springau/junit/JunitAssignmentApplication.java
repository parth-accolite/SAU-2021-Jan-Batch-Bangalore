package com.springau.junit;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitAssignmentApplication {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        LeapYear obj = new LeapYear();
	        int year = sc.nextInt();
	        if (obj.isLeapYear(year)) {
	            System.out.println("Year is a Leap Year");
	        } else {
	            System.out.println("Year is not a Leap Year");
	        }
	    }

}
