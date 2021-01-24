package com.au.assignment;

public class Join {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadJoiningDemo1 thread1=new ThreadJoiningDemo1();
		ThreadJoiningDemo2 thread2=new ThreadJoiningDemo2();
		ThreadJoiningDemo3 thread3=new ThreadJoiningDemo3();
		thread1.start();
		thread2.start();
		thread3.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		System.out.println("Main thread execution completed");
	}

}

class ThreadJoiningDemo1 extends Thread{
	
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Joining Demo1");
	}
	
}

class ThreadJoiningDemo2 extends Thread{
	
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Joining Demo2");
	}
	
}

class ThreadJoiningDemo3 extends Thread{
	
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Joining Demo3");
	}
	
}
