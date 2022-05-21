package com.anto;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	public static void main(String[] args) {
		
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		
		Runnable task1 = () -> System.out.println("Execting the task1 at "+ System.nanoTime());
		Runnable task2 = () -> System.out.println("Execting the task2 at "+ System.nanoTime());
		
		// executes only once
		executorService.schedule(task1, 5, TimeUnit.SECONDS);
		
		// executes the task repeatedly for given rate. it does not worry whether
		// previous task has completed or not.
		executorService.scheduleAtFixedRate(task1, 0, 2, TimeUnit.SECONDS);
		
		// executes the task repeatedly for given delay sequentially.
		executorService.scheduleWithFixedDelay(task2, 0, 2, TimeUnit.SECONDS);
		
	}
}
