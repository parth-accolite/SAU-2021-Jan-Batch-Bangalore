package com.au.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCreation {
	
	public static void main(String[] args) {
//		//Main
//		System.out.println(Thread.currentThread().getName());
//		ThreadDemo thread1=new ThreadDemo();
//		thread1.start();
//		//thread1.start(); - IllegalThreadStateException
//		// T.S gives time slice to Main
//		// T.S gives 
//		// Main ThreadDemo
//		
//		ThreadDemo1 runnabble=new ThreadDemo1();
//		Thread thread2=new Thread(runnabble);
//		thread2.start();
//		
//		System.out.println("Main Thread");

		ExecutorService ws=Executors.newFixedThreadPool(100);
		ws.execute(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getId());
				}
			}
		});
		
		ws.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println();
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getId());
				}
			}
		});
		
		ws.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println();
				for(int i=0;i<10;i++) {
					System.out.println(Thread.currentThread().getId());
				}
			}
		});
		
		AtomicInteger ref=new AtomicInteger(0);
	}

}

class ThreadDemo extends Thread{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Child Thread");
	}
	
}

class ThreadDemo1 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Child thread started with Runnable");
	}
	
}
