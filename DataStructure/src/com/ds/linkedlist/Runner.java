package com.ds.linkedlist;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		System.out.println("--------------------------Adding note to tail---------------------");
		list.add(new Node(1));
		list.add(new Node(2));
		list.add(new Node(3));
		list.add(new Node(4));
		list.add(new Node(5));
		list.traverse();
		//null list 
		list = new LinkedList();
		list.traverse();
		//add node at head
		System.out.println("--------------------------Adding note to head---------------------");
		list.addAtHead(new Node(1));
		list.addAtHead(new Node(2));
		list.addAtHead(new Node(3));
		list.addAtHead(new Node(4));
		list.addAtHead(new Node(5));
		list.traverse();
		System.out.println("--------------------------delete note to head---------------------");
		list.deleteHeadNode();
		list.traverse();
		list.deleteTailNode();
		list.traverse();
	}

}
