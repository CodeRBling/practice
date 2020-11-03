package com.practice.racecondition.staticmethod;

public class RaceCondition {

	public static void main(String[] args) {
		Thread t1 = new Thread(()-> {Counter.countdown();}, "Thread 1");
		Thread t2 = new Thread(()-> {Counter.countdown2();}, "Thread 2");
		t1.start();
		t2.start();
	}

}
