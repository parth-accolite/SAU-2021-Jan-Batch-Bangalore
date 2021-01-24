package com.au.assignment.customBlockingQueue;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class CustomBlockingQueue {
	
	private Lock lock=new ReentrantLock();
	private Condition producerCondition=lock.newCondition();
	private Condition consumerCondition=lock.newCondition();
	
	private Object[] blockingQueue=new Object[10];
	private int count=0;
	private int putIndex=0;
	private int takeIndex=0;
	
	public void put(Object obj) throws InterruptedException{
		lock.lock();
		try{
			while(count==blockingQueue.length){
				producerCondition.await();
			}
			blockingQueue[putIndex]=obj;
			System.out.println(Thread.currentThread().getName()+" : Producing : "+obj);
			putIndex++;
			if(putIndex==blockingQueue.length){
				putIndex=0;
			}
			++count;
			consumerCondition.signal();
		}
		finally{
			lock.unlock();
		}
	}
	
	public Object take() throws InterruptedException{
		lock.lock();
		try{
			while(count==0){
				consumerCondition.await();
			}
			Object obj=blockingQueue[takeIndex];
			System.out.println(Thread.currentThread().getName()+" : Consuming : "+obj);
			takeIndex++;
			if(takeIndex==blockingQueue.length){
				takeIndex=0;
			}
			--count;
			producerCondition.signal();
			return obj;
		}
		finally{
			lock.unlock();
		}
	}
}
