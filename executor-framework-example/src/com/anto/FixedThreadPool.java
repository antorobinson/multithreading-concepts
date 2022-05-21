package com.anto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Sahaya Anto Robinson
 *
 */
public class FixedThreadPool {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		Runnable task1 = () -> {
			System.out.println(Thread.currentThread().getName() +": executing task 1");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable task2 = () -> {
			System.out.println(Thread.currentThread().getName() +": executing task 2");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable task3 = () -> {
			System.out.println(Thread.currentThread().getName() +": executing task 3");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		executorService.submit(task1);
		executorService.submit(task2);
		executorService.submit(task3);
		
		executorService.shutdown();
	}
}
