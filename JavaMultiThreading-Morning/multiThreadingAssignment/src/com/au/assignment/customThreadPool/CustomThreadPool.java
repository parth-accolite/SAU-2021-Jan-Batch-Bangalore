package com.au.assignment.customThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	private BlockingQueue<Runnable> taskQueue;
	private boolean poolShutdownInitiated = false;

	public CustomThreadPool(int noOfThreads) {
		this.taskQueue = new LinkedBlockingQueue<>(noOfThreads);
		for (int i = 0; i < noOfThreads; i++) {
			WorkerThread workerThread = new WorkerThread(taskQueue, this);
			workerThread.setName("Thread-" + (i + 1));
			System.out.println("Thread-" + (i + 1) + " creadted in Threadpool");
			workerThread.start();
		}
	}

	public synchronized void execute(Runnable runnable) throws Exception {
		if (this.poolShutdownInitiated) {
			throw new Exception("ThreadPool has been shutdown. No new tasks can be added.");
		}
		System.out.println("Task has been added to the queue.");
		taskQueue.add(runnable);
	}

	public boolean ispoolShutdownInitiated() {
		return poolShutdownInitiated;
	}

	public synchronized void shutdown() {
		this.poolShutdownInitiated = true;
		System.out.println("ThreadPool shutdown initiated.");
	}
}
