package com.practice.one;
/**
 * You can create threads in following ways
 * 1 - by implementing runnable interface 
 * 2 - by extending Thread class 
 * 
 * @author CodeRBling
 *
 */
public class ThreadOne implements Runnable{
	/**
	 * Its important to override run method 
	 */
	@Override
	public void run() {
		System.out.println("This is printed from " + Thread.currentThread().getName());
	}
}

/**
 * Thread creation by extending Thread class
 * @author CodeRBling
 *
 */
class ThreadTwo extends Thread{
	public void run(){  
		System.out.println("This is printed from " + Thread.currentThread().getName());  
	}  
}