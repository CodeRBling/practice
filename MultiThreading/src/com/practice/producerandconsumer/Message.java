package com.practice.producerandconsumer;

public class Message {
	String message; 
	boolean isEmpty;
	
	Message(String message){
		this.message = message;
		isEmpty = false;
	}
	
	public Message() {
		isEmpty = true;
	}

	public synchronized String read() {
		//if its empty wait
		while(isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isEmpty = true;
		notifyAll();
		return message;
	}
	
	public synchronized void write(String message) {
		//wait this message is not empty
		while(!isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isEmpty = false;
		this.message = message;
		notifyAll();
	}
}
