package com.anto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceCondition {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Counter counter = new Counter();
		
		// this executes the increment method on same object and due to thread interferences
		// we will not get 1000 as a result. This is called race condition.
		for(int i=0; i<1000; i++) {
			executorService.submit(counter::increment);
		}
		
		System.out.println(counter.getCount());
		
		executorService.shutdown();
	}

}
