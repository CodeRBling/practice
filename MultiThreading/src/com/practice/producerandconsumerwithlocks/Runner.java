package com.practice.producerandconsumerwithlocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

	public static void main(String[] args) {
		/**
		 * Common resource that is shared between multiple threads
		 */
		Message msg = new Message();

		/**
		 * 1st consumer thread
		 */
		Runnable consumer = ()-> {
			String val = "";
			while(!val.equals("EOF")) {
				try {
					val = msg.read();
					if(val != null) {
						System.out.println(Thread.currentThread().getName() + " value :" + val);
					}else {
						val = "";
					}
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Something went wrong");
					e.printStackTrace();
				}
			}
		};
		
		/*
		 * 2nd consumer thread
		 */
		Runnable consumer2 = ()-> {
			String val = "";
			while(!val.equals("EOF")) {
				try {
					val = msg.read();
					if(val != null) {
						System.out.println(Thread.currentThread().getName() + " value :" + val);
					}else {
						val = "";
					}
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Something went wrong");
					e.printStackTrace();
				}
			}
		};
		
		
		/*
		 * Producer thread 
		 */
		Runnable producer = ()-> {
			String[] lines = {
					"Line 1",
					"Line 2",
					"Line 3",
					"Line 4",
					"EOF"
			};
			for (int i = 0; i < lines.length; i++) {
				msg.write(lines[i]);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		/**
		 * Note : Creating thread  and managing is an overhead which can be 
		 * reduced by using executor services
		 * 
		 * Calling the execute will start the execution of threads 
		 * For Runnable use execute method 
		 * For Callable use submit method
		 */
		ExecutorService exec = Executors.newFixedThreadPool(4);
		exec.execute(consumer);
		exec.execute(consumer2);
		exec.execute(producer);
		
		/**
		 * Its important to shutdown the executer service as program will not 
		 * terminate 
		 * 
		 * In order to terminate there are two methods used 
		 * 		1 - shutdown now which make executor service to stop taking any more runnable/callable
		 * 		and it will wait for all the job to execute in queue 
		 * 
		 * 		2- shutdownNow will shutdown immediately and return the Runnable which are in queue which
		 * 		 are not executed
		 */
		
		exec.shutdown();
		
	}

}
