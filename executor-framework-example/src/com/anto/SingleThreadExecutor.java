package com.anto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Runnable task = () -> System.out.println(Thread.currentThread().getName() +": executing task 1");
		
		executorService.submit(task);
		executorService.shutdown();
	}
}
