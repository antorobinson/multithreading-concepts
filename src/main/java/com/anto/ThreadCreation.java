package com.anto;

public class ThreadCreation {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName()+" : Inside main ");
		// new thread by extending Thread class
		Thread thread = new MyThread();
		thread.start();

		// new thread by passing runnable object
		Thread runnableThread = new Thread(new MyRunnableThread());
		runnableThread.start();
		
		// new thread by creating anonymous inner class of runnable interface
		Runnable anonymousRunnable = new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" : Inside anonymous runnable ");
			}
		};
		Thread runnableThread2 = new Thread(anonymousRunnable);
		runnableThread2.start();
		
		// from java8, we can pass implementation of runnable 
		// objects directly to Thread Constructor
		Thread runnableThread3 = new Thread(
				() -> System.out.println(Thread.currentThread().getName()+ " : Inside lambda runnable"));
		runnableThread3.start();
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" : Inside thread class");
	}
}

class MyRunnableThread implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName()+" : Inside runnable thread");
	}
}
