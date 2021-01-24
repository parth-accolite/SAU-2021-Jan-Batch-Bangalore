package com.au.assignment;

public class Test3 {
	
	public static void main(String[] args) throws InterruptedException {
		Thread mainThread=Thread.currentThread();
		ThraedDemoJoin join=new ThraedDemoJoin(mainThread);
		join.start();
		for(int i=0;i<10;i++) {
			System.out.println("Hi");
		}
	}

}

class ThraedDemoJoin extends Thread{ //t11
	
	public Thread t1;
	
	public ThraedDemoJoin(Thread t) {
		this.t1=t;
	}
	
	public void run() {
		try {
			t1.join();
			for(int i=0;i<10;i++) {
				System.out.println("Hello");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}




