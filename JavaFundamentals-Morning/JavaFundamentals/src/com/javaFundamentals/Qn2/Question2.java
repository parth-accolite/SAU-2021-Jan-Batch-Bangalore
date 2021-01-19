package com.javaFundamentals.Qn2;

import java.util.ArrayList;
import java.util.Collections;

public class Question2 {

	static void div(){ 
        int x = 10 / 0;
    } 
	static void div2() throws ArithmeticException {

//			int x = 10/0;
			throw new ArithmeticException("divide by 0");
	}
    public static void main(String args[]) 
    { 
        try
        { 
            div(); 
        } 
        catch(ArithmeticException e) 
        { 
            System.out.println("Artihmetic exception occured."); 
            
          try {
           div2();
          }catch(ArithmeticException k) {
              System.out.println("Arithmetic exception");	
          }
           System.out.println("end of program");	
        } 
    } 
}
