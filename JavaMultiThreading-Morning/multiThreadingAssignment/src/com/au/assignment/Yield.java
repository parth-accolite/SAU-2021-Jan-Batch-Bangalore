package com.au.assignment;

public class Yield {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " : Priority :"+Thread.currentThread().getPriority());
		// Main
		
		ThreadYield thread1 = new ThreadYield();
		thread1.start();
		// Child Thread
		
		//only one thread - main
		Thread.yield();  // Main thread will wait here and see is there any thread having high priority than main thread
		//System.out.println(Thread.currentThread().getName() + " in control");
		for(int i=0;i<10;i++) {
			System.out.println("main Thread");
		}
	}

}

class ThreadYield extends Thread {

	public void run() {
		//System.out.println(Thread.currentThread().getName() + " : Priority :"+Thread.currentThread().getPriority());
		
			for(int i=0;i<10;i++) {
				System.out.println("Child Thread");
			}
	}

}
