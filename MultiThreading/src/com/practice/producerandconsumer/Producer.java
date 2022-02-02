package com.practice.producerandconsumer;

import java.util.Random;

public class Producer implements Runnable{
	private Message message;
	
	Producer(Message message){
		this.message = message;
	}
	
	@Override
	public void run() {
		String[] messages = {
				"Line 1",
				"Line 2",
				"Line 3",
				"Line 4"
		};
		
		Random random = new Random();
		
 		for (int i = 0; i < messages.length; i++) {
			message.write(messages[i]);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		message.write("End");
	}
	
}
