package com.ds.linkedlist;

public class LinkedList {
	Node head;

	LinkedList() {
		this.head = null;
	}

	/*
	 * Set head
	 */
	public void setHead(Node node) {
		this.head = node;
	}

	/**
	 * Add node at the end of linked list
	 * linear time 
	 * @param node
	 */
	public void add(Node node) {
		if (this.head == null) {
			setHead(node);
		} else {
			int i = 0;
			Node head = this.head;
			while (head.next != null) {
				head = head.next;
				i++;
			}
			head.next = node;
		}
	}
	
	/**
	 * Add node at head
	 * constant time
	 * @param node
	 */
	public void addAtHead(Node node){
		if(this.head==null){
			setHead(node);
		}else{
			node.next = this.head;
			this.head = node;
		}
	}
	
	
	/**
	 * Traverse the list 
	 */
	public void traverse() {
		if (this.head == null) {
			System.out.print("List is empty");
		} else {
			Node head = this.head;
			while (head != null) {
				System.out.print(head.data);
				if (head.next != null)
					System.out.print("-->");
				head = head.next;
			}
		}
		System.out.println();
	}
	
	/**
	 * deletes node pointed by head
	 */
	public void deleteHeadNode(){
		if(this.head==null){
			System.out.println("List is Empty deletion not possible");
		}else{
			this.head = this.head.next;
		}
	}
	/**
	 * delete node end of link list
	 */
	public void deleteTailNode(){
		if (this.head == null) {
			System.out.println("List is Empty");
		} else {
			Node head = this.head;
			while (head.next != null) {
				if(head.next.next==null){
					head.next = null;
				}else{
					head = head.next;
				}
			}
		}
	}
	
	/**
	 * Any node with data == key then delete that node
	 * 1-key can be at head node 
	 * 2-in middle 
	 * 3-at the tail end 
	 * @param key
	 */
	public void deleteByKey(int key){
		
	}
}
