package com.anto;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class ThreadJoinExample {

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
		
		try {
			// main thread will wait for the specified time given in join method.
			thread0.join(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Waited enough! Starting Thread 1 now");
		thread1.start();
	}


}
