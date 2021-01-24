package com.au.assignment;

public class JoinExample {
	
	public static void main(String[] args) throws InterruptedException {
		// Main
		ThreadJoin thread1=new ThreadJoin();
		//	Main
		thread1.start();
		// Main & thread1
		thread1.join();
		// only main
		//Thread.yield();// This line will be executed by the main thread
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}

}


class ThreadJoin extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			Thread.yield();
			System.out.println("Child Thread");
		}
	}
}
