package com.ds.linkedlist;

/**
 * Node of linked list
 * @author Mechy
 *
 */
class Node{
	int data;
	Node next;
	//on creation set next to null
	Node(int data){
		this.data = data;
		this.next = null;
	}
}