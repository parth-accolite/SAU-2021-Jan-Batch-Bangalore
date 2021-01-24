package com.au.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test6 {
	
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(100);
		es.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hi");
			}
		});
		
		es.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello");
			}
		});
		es.shutdown();
		es.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello");
			}
		});
	}

}
