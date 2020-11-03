package com.practice.producerandconsumerwithcollection;

import java.util.Random;

public class Runner {
	public static void main(String[] args) {
		MessageList msg = new MessageList();
		//Consumer thread 
		Thread consumer = new Thread(()-> {
			try {
				String val = "";
				while(!val.equals("Line 4")) {
					val = msg.read();
					if(val != null) {
						System.out.println(Thread.currentThread().getName() + " Thread reads :" + val);
					}
					Random random = new Random();
					Thread.sleep(random.nextInt(2000));
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} , "Consumer");
		//Producer thread
		Thread producer = new Thread(()-> {
			String[] lines = {
					"Line 1",
					"Line 2",
					"Line 3",
					"Line 4"
			};
			for (int i = 0; i < lines.length; i++) {
				msg.write(lines[i]);
				try {
					Thread.sleep((new Random()).nextInt(2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Producer");
		
		consumer.start();
		producer.start();
	}
}
