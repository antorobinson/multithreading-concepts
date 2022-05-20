package com.anto;

public class ThreadCreation {

	public static void main(String[] args) {

		Thread thread = new MyThread();
		thread.start();

		Thread runnableThread = new Thread(new MyRunnableThread());
		runnableThread.start();

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
