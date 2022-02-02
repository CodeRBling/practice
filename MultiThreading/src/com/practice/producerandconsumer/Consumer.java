package com.practice.producerandconsumer;

import java.util.Random;

public class Consumer implements Runnable{
	Message message;

	Consumer(Message message){
		this.message = message;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		String msg = message.read();
		for (; !msg.equals("End"); ) {
			System.out.println(msg);
			msg = message.read();
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
