package com.au.assignment;

public class DataInconsistency {

	private static volatile int balance = 0;
	// no copy will be shared b/w the threads. they have to read the same variable
	Object lock=new Object();

	public static void main(String[] args) throws InterruptedException {
		DataInconsistency sc=new DataInconsistency();
		DataInconsistency sc1=new DataInconsistency();
		DataInconsistency sc2=new DataInconsistency();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					sc.incrementBalance();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					sc.incrementBalance();
				}
			}

		});

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					sc.incrementBalance();
				}
			}

		});
		
		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(100);

		System.out.println("Count : " + balance);
	}

	// synchrinozed method means only one thread can access to the method at any time
	private void incrementBalance() { //m1 //t2
		balance++;
		
		// 100 lines of code
		
		// 55-67
	}
	
	private void incrementAndSetCount() { //m2 //t1
		// 100 lines t1 t2 t3
		synchronized(lock) {
			balance++;
		} // 55-67
		// 100 lines 
	}
	
	
	//t1.test(new Object())
	//t2.test(new Object()) 
	
	//Object - Lock : one to one mapping
	private void test(Object dummy) {
		synchronized(lock) {
			
		}
	}
	
//synchronized(NameOfTheClass.class)
//synchronized(this)
//synchronized(any object of your type)
	
	
	/*t1 - m1
	t2 - m1 - No 
	
	t1 - m1
	t2 - m2 - Yes
	
	t2 - m2
	t3 - m2 - No
	
	t2 - m2 - obj1
	t3 - m3 - Obj2 -Yes*/
	

}
