package com.practice.racecondition.staticmethod;

public class Counter {
	public static int count = 10;
	
	public static synchronized void countdown() {
		for (count = 10; count >= 0 ; count--) {
			System.out.println("Thread " + Thread.currentThread().getName() + " : " + count);
		}
	}
	
	
	
	public static synchronized void countdown2() {
		System.out.println("--2nd counter---");
		for (count = 10; count >= 0 ; count--) {
			System.out.println("Thread " + Thread.currentThread().getName() + " : " + count);
		}
	}
}
