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
		list.deleteByKey(2);
		list.traverse();
		System.out.println("--------------------------Lenght of linked list---------------------");
		list = new LinkedList();
		list.addAtHead(new Node(1));
		list.addAtHead(new Node(2));
		list.addAtHead(new Node(3));
		list.addAtHead(new Node(4));
		list.addAtHead(new Node(5));
		System.out.println("lenght by iteration:"+list.length());
		list.traverse();
		System.out.println("lenght by recursion:"+list.lengthR(list.head));
		list.traverse();
		System.out.println("--------------------------Nth Node from last---------------------");
		list.traverse();
		list.getNthNodeFromlast(3, list.head);
		list.getNthNodeFromlast(4, list.head);
		list.getNthNodeFromlast(6, list.head);
		System.out.println("--------------------------loop in linked list---------------------");
		list.detectLoop();
		Node loopnode = new Node(6);
		loopnode.next = list.head;
		list.add(loopnode);
		list.detectLoop();
		//creating loop of two
		list = new LinkedList();
		list.add(new Node(1));
		Node on = new Node(2);
		on.next = list.head;
		list.add(on);
		list.detectLoop();
		//creating loop in middle
		list = new LinkedList();
		list.add(new Node(1));
		list.add(new Node(2));
		Node on1 = new Node(3);
		list.add(on1);
		list.add(new Node(4));
		list.add(new Node(5));
		Node on2 = new Node(6);
		on2.next = on1;
		list.add(on2);
		list.detectLoop();
		System.out.println("--------------------------swapping in linked list---------------------");
		list = new LinkedList();
		list.addAtHead(new Node(1));
		list.addAtHead(new Node(2));
		list.addAtHead(new Node(3));
		list.addAtHead(new Node(4));
		list.addAtHead(new Node(5));
		list.swap(4, 3);
		list.traverse();
		list.swap(1, 6);
	}

}
