package com.practice.one;
/**
 * This class demonstrate
 * 1 - Creation of Thread 
 * 	a.From Runnable Interface
 * 	b.From Thread subclass
 * 	c.Using Functional interface/lambda expression
 * 2 - Starting Thread
 * 3 - Waiting for Thread to complete execution 
 * @author abhishs17
 *
 */
public class MainClass {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("This is " + Thread.currentThread().getName() + "Thread - start");
		/*
		 * Thread object creation using from runnable
		 * 1st arguments is the implementation of Runnable interface
		 * 2nd argument is the name of the Thread 
		 */
		Thread t1 = new Thread(new ThreadOne(), "Thread One");
		/**
		 * Thread object creation from subclass of thread
		 * t2.setName("Thread two") - is used to set the name of the Thread
		 */
		ThreadTwo t2 = new ThreadTwo();
		t2.setName("Thread two");
		
		/**
		 * Start execution of thread one and thread two
		 * Note : Do not call run() method as it will start 
		 * executing run() in same Thread  
		 */
		t2.start();
		t1.start();
		/**
		 * Wait for t2 Thread to finish execution 
		 * throws InterruptedException when thread is interrupted
		 */
		t2.join();
		
		/**
		 * You can also use java 8 lambda expression and functional interface to 
		 * create Thread.
		 * 
		 * It will follow same pattern of creating thread from runnable interface
		 * 
		 * 1- Create runnable object 
		 * 2- pass that object in thread class 
		 * 3- Start the thread by calling start() method
		 * 
		 * Note: Since Runnable have one method it is a functional interface
		 */
		//Step 1
		Runnable r = ()->{
			System.out.println("This is printed from " + Thread.currentThread().getName());
		};
		//Step 2
		Thread t = new Thread(r, "Anonymous thread");
		//Step 3
		t.start();
		
		System.out.println("This is " + Thread.currentThread().getName() + "Thread - end");
	}
}
