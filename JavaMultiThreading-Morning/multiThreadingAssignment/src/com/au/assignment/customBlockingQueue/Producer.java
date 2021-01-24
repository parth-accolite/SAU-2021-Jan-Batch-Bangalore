package com.au.assignment.customBlockingQueue;

public class Producer implements Runnable{
	
	private CustomBlockingQueue cbq;
	
	public Producer(CustomBlockingQueue cbq){
		this.cbq=cbq;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			try {
				cbq.put(i+1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
