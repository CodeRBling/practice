package com.practice.producerandconsumer;

public class Runner {

	public static void main(String[] args) {
		Message msg = new Message();
		
		Producer producer = new Producer(msg);
		Consumer consumer = new Consumer(msg);
		
		Thread t1 = new Thread(producer, "Producer");
		Thread t2 = new Thread(consumer, "Consumer");
		
		t1.start();
		t2.start();
	}

}
