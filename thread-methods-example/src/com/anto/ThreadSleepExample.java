package com.anto;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class ThreadSleepExample {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());
		
		String[] messages = {"hi", "hello", "how are you"};
		
		Runnable runnable = () -> {
			System.out.println("Inside : " + Thread.currentThread().getName());
			
			for(String m : messages) {
				System.out.println(Thread.currentThread().getName()+":"+m);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread0 = new Thread(runnable);
		Thread thread1 = new Thread(runnable);
		
		thread0.start();
		thread1.start();
	}

}
