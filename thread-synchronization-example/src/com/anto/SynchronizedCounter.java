package com.anto;

public class SynchronizedCounter {
	private int count;
	
	public synchronized void increment(){
		System.out.println("Inside synchronized method");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count += 1;
		System.out.println("exiting synchronized method");
	}
	
	public int getCount() {
		System.out.println("Inside getCount method");
		return count;
	}

}
