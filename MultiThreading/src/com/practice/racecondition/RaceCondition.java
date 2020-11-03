package com.practice.racecondition;

public class RaceCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter counter = new Counter();
		Thread t1 = new Thread(()-> {counter.countdown();}, "Thread 1");
		Thread t2 = new Thread(()-> {counter.countdown();}, "Thread 2");
		t1.start();
		t2.start();
	}

}
