package com.practice.producerandconsumerwithlocks;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * This class demos the use of reentrant lock 
 * 
 * Problems with Synchronized block that locks overcome
 * 1 - locking and unlocking can't span across multiple methods in SB 
 * 2 - No info about the lock in SB i.e whether lock is free or not we can't know 
 * 3 - Thread are blocked when waiting to get lock - those threads can't be interrupted 
 * 4 - SB provide no fairness when lock is released i.e when lock is released its not guaranteed that 
 * 	   longest waiting thread will get the lock (in FIFO Order)
 * 
 * Problems with lock
 * 1 - locking/unlocking must be done manually 
 * 
 * @author abhishs17
 *
 */
public class Message {
	LinkedList<String> list;
	//java.util.concurrent.locks.ReentrantReadWriteLock readWriteLocks;
	//ReadLock readLock;
	//WriteLock writeLock;
	ReentrantLock lock;
	Condition listFull;
	Condition listEmpty;
	
	
	Message(){
		list = new LinkedList<String>();
		/**
		 * True passed in the lock is to use fairness parameter
		 */
		lock = new ReentrantLock(true);
		listEmpty = lock.newCondition();
		listFull = lock.newCondition();
	}
	
	public String read() throws InterruptedException {
		/*
		 * Tried read write lock which is causing reading null values 
		 * if you notice the method below its functionality in not only read it is
		 * also removing the element so just read lock won't work here
		 */
		try {
			lock.lock();
			while(list.isEmpty()) {
				listEmpty.await();
			}
			String val = list.peek();
			if(val != null && !val.equals("EOF")) {
				list.remove();
			}
			return val;
		} finally {
			
			lock.unlock();
		}
	}
	
	
	public void write(String data) {
		try {
			lock.lock();
			list.add(data);
		}finally {
			listEmpty.signalAll();
			lock.unlock();
		}
		
	}
	
	
	
}
