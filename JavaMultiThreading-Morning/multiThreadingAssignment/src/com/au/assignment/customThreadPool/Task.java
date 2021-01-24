package com.au.assignment.customThreadPool;

public class Task implements Runnable{
	
	public void run(){
		try{
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" is executing task");
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
