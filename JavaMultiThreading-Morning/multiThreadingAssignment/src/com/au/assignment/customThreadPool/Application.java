package com.au.assignment.customThreadPool;

public class Application {
	
	public static void main(String[] args) throws Exception {
		CustomThreadPool ctp=new CustomThreadPool(2);
		ctp.execute(new Task());
		ctp.execute(new Task());
		ctp.execute(new Task());
		ctp.execute(new Task());
		/*ctp.execute(new Task());
		ctp.execute(new Task());
		ctp.execute(new Task());*/
		ctp.shutdown();
		ctp.execute(new Task());
	}

}
