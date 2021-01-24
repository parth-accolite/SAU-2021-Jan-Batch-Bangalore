package com.au.assignment.customBlockingQueue;

public class Consumer implements Runnable{
	
	private CustomBlockingQueue cbq;
	
	public Consumer(CustomBlockingQueue cbq){
		this.cbq=cbq;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			try {
				cbq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
