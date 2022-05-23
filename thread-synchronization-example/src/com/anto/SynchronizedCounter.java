package com.anto;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class SynchronizedCounter {
	private int count;
	
	
	/**
	 * synchronized keyword allows the calling thread to gain the intrinsic lock of an object of this class. 
	 * this intrinsic lock does not allow other threads to access any synchronized methods in the object.
	 * however other threads can access non-synchronized methods.
	 * 
	 */
	public synchronized void increment(){
		System.out.println("Inside synchronized method");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
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
