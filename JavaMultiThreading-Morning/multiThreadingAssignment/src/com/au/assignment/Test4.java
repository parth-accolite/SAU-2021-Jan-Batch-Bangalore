package com.au.assignment;

public class Test4 {
	
	public static void main(String[] args) throws InterruptedException {
		// one thread
		Thread t1=new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("heello");
				}
			}
		});
		t1.start();
		// t1 & main
		t1.join(); // main thread is saying I will wait till t1 will complete
		for(int i=0;i<10;i++) {
			System.out.println("Hi");
		}
	}

}
