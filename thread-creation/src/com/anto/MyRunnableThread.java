package com.anto;

public class MyRunnableThread implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName()+" : Inside runnable thread");
	}
}
