package com.anto;

public class ThreadCreation {

	public static void main(String[] args) {

		// new thread by extending Thread class
		Thread thread = new MyThread();
		thread.start();

		// new thread by passing runnable object
		Thread runnableThread = new Thread(new MyRunnableThread());
		runnableThread.start();

		// from java8, we can pass implementation of runnable 
		// objects directly to Thread Constructor
		Thread runnableThread2 = new Thread(
				() -> System.out.println("Hi, I am from a lambda implemented runnbale thread"));
		runnableThread2.start();
	}

}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("Hi, I am from a thread class");
	}

}

class MyRunnableThread implements Runnable {

	public void run() {
		System.out.println("Hi, I am from a runnable thread class");
	}

}
