package com.au.assignment;

public class Deadlock {
	
	private Object lock1=new Object(); // user1
	private Object lock2=new Object(); // user2
	
	public static void main(String[] args) {
		User user1=new User(2000);
		User user2=new User(1000);  
		Deadlock dead=new Deadlock();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				dead.addMoneyForUser1(user1,user2,500);
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			public void run() {
				dead.addMoneyForUser2(user1,user2,500);
			}
		});
		t1.start();
		t2.start();
	}
	
	public void addMoneyForUser1(User user1,User user2,int amount) {
		synchronized(lock1) {
			System.out.println("User1 takes lock1 to read the balance");// thread1 is having the lock1
			synchronized (lock2) {
				System.out.println("user1 expects lock2 to update the balance");
			}
			//lock2 is no loger with any other thread
		}
		// lock1 is no other with any other rhread
	}
	
	public void addMoneyForUser2(User user1,User user2,int amout) {
//		synchronized (lock2) {
			System.out.println("User2 takes lock2 to read the balance");// Thread2 is having lock2
			synchronized (lock1) {
				System.out.println("user2 expects lock1 to update the balance");
//			}
		}
	}

}


class User{
	int balance;
	
	public User(int balance) {
		this.balance=balance;
	}
	
}

