package com.crackingthecodinginterview.problemset.chapter7;

import java.util.HashSet;

import com.crackingthecodinginterview.problemset.chapter7.TrainingSinglyLinkedList.Node;

public class TrainingDoublyLinkedList<T> {
	
	private Node head; 
	
	public class Node{
		public Node next; 
		public Node prev; 
		public T value; 
		public Node(T val) {
			this.value = val; 
		}
		public void appendToTail(T val) {
			Node endTail = new Node(val);
			Node n = this; 
			Node prev = null; 
			while(n.next != null) {
				prev = n; 
				n = n.next; 
			}
			n.next = endTail; 
		}
		
		public void printList() {
			Node n = this; 
			while(n.next!=null)
			{
				System.out.print("["+n.value.toString()+"]->");
				n=n.next; 
			}
		}
		
		public Node removeNodesWithValue(T val) {
			Node root = this; 
			Node n= this;
			Node prev = null; 
			Node next = this.next; 
			while(n.next!=null) {
				if(n.value==val) {
					if(prev == null) { //this is the root node
						root = n.next; 
					}
					else {
						prev.next=n.next;
						n=prev; 
					}
				}
				prev=n; 
				n=n.next; 
				
			}
			return root; 
		}
		

		public Node removeDuplicates() {
			Node root = this; 
			Node n = this; 
			Node prev = null; 
			Node next = this.next; 
			HashSet<T> seenValues = new HashSet<T>(); 
			while(n.next!=null)
			{
				if(seenValues.contains(n.value))
				{
						prev.next=n.next;
						n=prev; 
				}else {
					seenValues.add(n.value); 
				}
				prev=n; 
				n=n.next; 
				
			}
			return root; 
		}
		public void removeKthFromLast(int k) {
			
		}
	}
	
	public TrainingSinglyLinkedList(T rootVal){
		this.head = new Node(rootVal);
	}
	
	public void removeWithValue(T val) {
		head = this.head.removeNodesWithValue(val); 
	}
	
	public void removeDuplicates() {
		head = this.head.removeDuplicates(); 
	}

	public Node getFirst() {
		return head; 
	}

	public void printList() {
		head.printList(); 
	}
	
	public void add(T val) {
		this.head.appendToTail(val); 
	}

}