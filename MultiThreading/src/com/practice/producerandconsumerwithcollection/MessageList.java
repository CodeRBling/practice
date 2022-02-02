package com.practice.producerandconsumerwithcollection;

import java.util.concurrent.LinkedBlockingQueue;

public class MessageList {
	LinkedBlockingQueue<String> linkedQueue = new LinkedBlockingQueue<String>(2);
	
	public String read() throws InterruptedException {
		return linkedQueue.take();
	}
	
	public void write(String message) {
		this.linkedQueue.offer(message);
	}
}
