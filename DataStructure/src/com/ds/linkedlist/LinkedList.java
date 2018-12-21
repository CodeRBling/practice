package com.ds.linkedlist;

import java.util.ArrayList;

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
			Node head = this.head;
			while (head.next != null) {
				head = head.next;
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
		if(this.head==null){
			System.out.println("deletion not possible");
		}else if(this.head.data==key){
			this.head = this.head.next;
		}else{
			Node prev = this.head;
			Node next = this.head.next;
			while(next.data!=key){
				next = next.next;
				prev = prev.next;
			}
			prev.next = next.next;
			next = null;
		}
	}
	
	/**
	 * Find length of linked list Iterative approach
	 */
	public int length(){
		if(this.head==null){
			return 0;
		}else{
			Node head = this.head;
			int len = 0;
			while (head != null) {
				head = head.next;
				len++;
			}
			return len;
		}
	}
	
	/**
	 * Get length by recursion
	 */
	public int lengthR(Node node){
		if(node==null){
			return 0;
		}else{
			return lengthR(node.next)+1;
		}
	}
	
	/**
	 * Prints data of nth node from last recursive approach
	 * @param n
	 */
	public int getNthNodeFromlast(int n,Node node){
		  if(node==null)
			  return 0;
		  else{
			  int spot = getNthNodeFromlast(n,node.next)+1;
			  if(spot==n){
				  System.out.println("data: "+node.data);
			  }
			  return spot;
		  }
	}
	
	/**
	 * find loop in linked list my idea 
	 * After further reading floyd cycle detection algo which take 2 pointer move 1-pointer by one step other by 2-step 
	 * length can be found by incrementing counter till starting and end are equal
	 */
	public void detectLoop(){
		if(this.head==null){
			System.out.println("List is empty");
		}else if(this.head.next ==null){
			System.out.println("No loop");
		}else{
			Node prev = this.head;
			Node next = this.head.next;
			int i=1;
			while(prev!=next){
				for(int j=1;j<=i;j++){
					if(next.next==null){
						System.out.println("No loop");
						return;
					}else{
						next = next.next;
					}
				}
				if(prev==next){
					System.out.println("Loop of size :"+(i+1)+" exist");
					return;
				}
				for(int j=1;j<=i;j++){
					prev = prev.next;
				}
				i++;
			}
			
		}
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 */
	public void swap(int a,int b){
		//making sure list is not empty and atleast 2 nodes are there
		if(a!=b && this.head!=null && this.head.next!=null){
			//push fake node at start 
			Node fake = new Node(0);
			fake.next = this.head;
			this.head = fake;
			boolean flag1 = true;
			boolean flag2 = true;
			Node swap1 = null;
			Node swap2 = null;
			//find previous nodes 
			while(fake.next!=null){
				if(flag1 && a==fake.next.data){
					if(swap1==null){
						swap1 = fake;
					}else{
						swap2 = fake;
					}
				}
				if(flag2 && b==fake.next.data){
					if(swap1==null){
						swap1 = fake;
					}else{
						swap2 = fake;
					}
				}
				fake = fake.next;
			}
			//if nodes found 
			if(swap1!=null&&swap2!=null){
				Node n1 = swap1.next;
				Node n2 = swap2.next;
				if(n1.equals(swap2)){
					swap2.next = n2.next;
					n2.next = n1;
					swap1.next = n2;
				}else{
					swap1.next = n1.next;
					swap2.next = n2.next;
					n2.next = n1.next;
					n1.next = swap2.next;
					swap1.next = n2;
					swap2.next = n1;
				}
				System.out.println("Swapping comlete");
			}else{
				System.out.println("Node not found");
			}
			this.head = this.head.next;
		}
	}
	
	/**
	 * Method to reverse the linked list
	 */
	public void reverseList(){
		Node reverseHead = null;
		if(this.head!=null && this.head.next!=null){
			Node temp = this.head;
			while(temp!=null){
				if(reverseHead==null){
					reverseHead = new Node(temp.data);
					reverseHead.next = null;
				}else{
					Node newNode = new Node(temp.data);
					newNode.next = reverseHead;
					reverseHead = newNode;
				}
				temp = temp.next;
			}
			this.head = reverseHead;
		}
	}
}
