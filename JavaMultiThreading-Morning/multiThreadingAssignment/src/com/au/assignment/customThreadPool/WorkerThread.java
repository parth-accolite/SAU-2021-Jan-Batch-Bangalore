package com.au.assignment.customThreadPool;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread{
	
	private BlockingQueue<Runnable> taskQueue;
	private CustomThreadPool customThreadPool;
	
	public WorkerThread(BlockingQueue<Runnable> taskQueue, CustomThreadPool customThreadPool){
		this.taskQueue=taskQueue;
		this.customThreadPool=customThreadPool;
	}
	
	 public void run(){
		 try{
			while(true){
				System.out.println(Thread.currentThread().getName()+" is ready to execute a task.");
				Runnable runnable=taskQueue.take();
				System.out.println(Thread.currentThread().getName()+" has taken a task.");
				runnable.run();
				System.out.println(Thread.currentThread().getName()+" has executed the task.");
				if(this.customThreadPool.ispoolShutdownInitiated() && this.taskQueue.size()==0){
					this.interrupt();
					Thread.sleep(1000);
				}
			}
		 }
		 catch (Exception e) {
             System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
		 }
	 }

}
