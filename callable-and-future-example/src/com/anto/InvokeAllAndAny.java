package com.anto;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class InvokeAllAndAny {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		Callable<String> task1 = () -> {
			Thread.sleep(2000);
			return "results from task1";
		};
		
		Callable<String> task2 = () -> {
			Thread.sleep(5000);
			return "results from task2";
		};
		
		Callable<String> task3 = () -> {
			Thread.sleep(1000);
			return "results from task3";
		};
		
		List<Future<String>> results = executorService.invokeAll(Arrays.asList(task1, task2, task3));
		
		for(Future<String> result : results) {
			System.out.println("Result is : "+result.get());
		}
		
		// this will return the fastest response from given tasks
		String result = executorService.invokeAny(Arrays.asList(task1, task2, task3));
		
		System.out.println("Result is : "+result);
		
		executorService.shutdown();
	}

}
