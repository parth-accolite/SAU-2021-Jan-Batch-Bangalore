package com.au.assignment;

public class ThradSleep {
	
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					try {
						Thread.sleep(500);
						System.out.println("Count : "+i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
	}

}
