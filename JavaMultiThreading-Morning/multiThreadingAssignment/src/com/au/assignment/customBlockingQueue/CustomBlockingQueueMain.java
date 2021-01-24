package com.au.assignment.customBlockingQueue;

public class CustomBlockingQueueMain {
	
	public static void main(String[] args) {
		CustomBlockingQueue cbq=new CustomBlockingQueue();
		Thread t1=new Thread(new Producer(cbq));
		
		Thread t2=new Thread(new Consumer(cbq));
		Thread t3=new Thread(new Consumer(cbq));
		Thread t4=new Thread(new Producer(cbq));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
