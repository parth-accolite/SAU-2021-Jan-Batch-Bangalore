package com.au.assignment;

public class Test1 {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " : "+Thread.currentThread().getPriority());
		// Creating Threads by extending Thread class
		ThreadDemo11 demo=new ThreadDemo11();
		demo.start();
		System.out.println("Extending Thread class");
		
		// By Implementing Runnbale interface
		Thread t1=new Thread(new ThreadDemo12());
		t1.start();
		Thread.yield();
		System.out.println("Hi");
	}
	

}

class ThreadDemo11 extends Thread{
	
	public void run() {
		/*for(int i=0;i<10;i++) {
			System.out.println("Hi");
		}*/
		System.out.println(Thread.currentThread().getName() + " : "+Thread.currentThread().getPriority());
		System.out.println("First Thread");
	}
	
}

class ThreadDemo12 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : "+Thread.currentThread().getPriority());
		System.out.println("Runnable implementation");
	}
	
}

// priority - 1 to 10
// main - 5 (priority)


