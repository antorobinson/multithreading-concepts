package com.anto;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureIsDone {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		Callable<String> task1 = () -> {
			Thread.sleep(2000);
			return "results from task1";
		};
		
		System.out.println("submiting the task");
		
		Future<String> result = executorService.submit(task1);
		
		System.out.println("I can do any other operation here while the task is running");
		
		
		while(!result.isDone()) {
			System.out.println("task has not completed yet");
			
			Thread.sleep(3000);
		}
		
		// get() method call is blocked
		String output = result.get();
		
		System.out.println("Result is : "+output );
		
		executorService.shutdown();
	}

}
