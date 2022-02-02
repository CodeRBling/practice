package com.practice.racecondition;

public class Counter {
	private int count;
	
	public void countdown() {
		synchronized (this) {
			for (count = 10; count >= 0 ; count--) {
				System.out.println("Thread " + Thread.currentThread().getName() + " : " + count);
			}
		}
	}
}
