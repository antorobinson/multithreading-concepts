package com.anto;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class FutureIsCancelled {

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
			
			if(!result.isDone()) {
				result.cancel(true);
			}
		}
		
		// calling get method when the thread is cancelled will throw Cancellation exception
		// so better to surround get call with simple check
		if(!result.isCancelled()) {
			// we can pass timout value in get call, which will throw if task doast not 
			// return response within the timeout ex. result.get(1, TimeUnit.SECONDS)
			String output = result.get();
			System.out.println("Result is : "+output );
		}
		
		executorService.shutdown();
	}

}
