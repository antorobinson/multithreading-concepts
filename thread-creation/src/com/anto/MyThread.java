package com.anto;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" : Inside thread class");
	}
}