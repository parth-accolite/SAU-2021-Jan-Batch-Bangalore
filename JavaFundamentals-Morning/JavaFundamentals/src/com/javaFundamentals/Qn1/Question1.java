package com.javaFundamentals.Qn1;

import java.util.ArrayList;
import java.util.Collections;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<25;i++) {
			al.add((int) (Math.random()*100));
		}
		System.out.print(al);
		Collections.sort(al);
		System.out.println("\nthe sorted list is :");
		System.out.println(al);
	}	

}
