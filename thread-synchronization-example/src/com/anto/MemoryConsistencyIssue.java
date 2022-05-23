package com.anto;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class MemoryConsistencyIssue {

	private static boolean sayHello = false;

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(() -> {
			while (!sayHello) {
			}

			System.out.println("Hello World!");

			while (sayHello) {
			}

			System.out.println("Good Bye!");
		});

		thread.start();

		Thread.sleep(1000);
		System.out.println("Say Hello..");
		
		// this change will not be reflected to the thread we have started just before.
		// so that while loop will run forever. this issue happens because threads are reading value from CPU cache
		// which can have stale data. this can be avoided by using volatile keyword which will force the thread to 
		// values from main memory directly.
		sayHello = true;

		Thread.sleep(1000);
		System.out.println("Say Bye..");
		sayHello = false;
	}
}
