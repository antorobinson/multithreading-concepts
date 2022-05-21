package com.anto;

class MyRunnableThread implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName()+" : Inside runnable thread");
	}
}
