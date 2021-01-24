package com.au.assignment;

public class DemoJanuary {

	public static void main(String[] args) throws InterruptedException {
		//main
		Demo t1=new Demo();
		//main
		t1.start();
		//main and t1
		// main is invoking t1 main-> t1.join()
//		t1.join();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}
}

class Demo extends Thread{
	
	//child therad
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
		}
	}
	
}
