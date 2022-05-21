package com.anto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchorizedExecution {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
		
		Thread t2 = new Thread(() -> System.out.println(synchronizedCounter.getCount()));
		
		for(int i=0; i<100; i++) {
			executorService.submit(synchronizedCounter::increment);
		}
		
		Thread.sleep(1000);
		// while calling synchronized method, other threads can access other methods which
		// are not synchronized
		t2.start();
		
		executorService.shutdown();
		// this blocks the main thread to wait for given timeUnit.
		executorService.awaitTermination(10, TimeUnit.SECONDS);
		
		System.out.println(synchronizedCounter.getCount());

	}

}
