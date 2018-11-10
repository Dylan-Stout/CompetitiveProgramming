package com.crackingthecodinginterview.problemset.chapter2;

import java.util.Stack;


//given the head node in a singly linked list return true/false if it is a palindrome or not
public class PalindromeLinkedList {
	
	public static boolean isPalindromeList(Node head)
	{
		if(head==null) 
			return false; 
		if(head.next==null)
			return true; 
		if(head.next.next == null)
			return (head.value==head.next.value); 
		int length =1; 
		
		Stack<String> leftHalfStack = new Stack<String>(); 
		Node fast = head; 
		Node slow = head; 
		while(fast.next !=null && fast.next.next!=null)
		{
			leftHalfStack.add((String)slow.value); 
			slow = slow.next; 
			fast = fast.next.next; 
			length+=2; 
		}
		if(fast.next!=null)
			length++; 
		if(length%2==0)
			leftHalfStack.add((String)slow.value); 
		
		while(!leftHalfStack.isEmpty())
		{
			slow=slow.next; 
			if(!slow.value.equals(leftHalfStack.pop()))
				return false; 
		}
		return true; 
	}
	
	public static void main(String[] args) {
		Node head = new Node("A"); 
		System.out.println("EXPECTED: TRUE ACTUAL: "+isPalindromeList(head));
		Node s = new Node("S"); 
		Node t = new Node("T"); 
		Node e = new Node("E"); 
		Node w = new Node("W"); 
		Node e2 = new Node("E"); 
		Node t2 = new Node("T"); 
		Node s2 = new Node("S"); 
		s.next = t; 
		t.next = e; 
		e.next = w; 
		w.next = e2; 
		e2.next = t2; 
		t2.next = s2; 
		System.out.println("STEWETS EXPECTED: TRUE ACTUAL: "+isPalindromeList(s));
		Node ss = new Node("S"); 
		Node tt = new Node("T"); 
		Node ee = new Node("E"); 
		Node ww = new Node("W"); 
		Node ee2 = new Node("E"); 
		Node tt2 = new Node("S"); 
		Node ss2 = new Node("S"); 
		ss.next = tt; 
		tt.next = ee; 
		ee.next = ww; 
		ww.next = ee2; 
		ee2.next = tt2; 
		tt2.next = ss2; 
		System.out.println("STEWESS EXPECTED: FALSE ACTUAL: "+isPalindromeList(ss));
		Node a = new Node("A"); 
		Node b = new Node("B"); 
		Node bb = new Node("B"); 
		Node aa = new Node("A"); 
		a.next=b; 
		b.next=bb; 
		bb.next=aa; 
		System.out.println("ABBA EXPECTED: TRUE ACTUAL: "+isPalindromeList(a));
		Node a1 = new Node("A"); 
		Node b1 = new Node("B"); 
		Node aa1 = new Node("A"); 
		a1.next=b1; 
		b1.next=aa1;
		System.out.println("ABA EXPECTED: TRUE ACTUAL: "+isPalindromeList(a1));
		
	}

}
