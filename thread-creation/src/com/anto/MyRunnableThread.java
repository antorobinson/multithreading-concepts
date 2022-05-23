package com.anto;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class MyRunnableThread implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName()+" : Inside runnable thread");
	}
}
