package com.leetcode.problemset;

public class SwapNodesInPairs {

	public static ListNode swapPairs(ListNode head)
	{

		if(head==null || head.next == null)
			return head; 
		ListNode dummy = new ListNode(0); 
		dummy.next = head; 
		swapHelper(dummy, head, head.next); 
		ListNode result = dummy.next;
		dummy.next = null; 
		return result; 
	}
	
	public static void swapHelper(ListNode p, ListNode head, ListNode n)
	{
		if(head == null || n == null)
			return; 
		ListNode afterNode = n.next; 
		n.next = head; 
		head.next = afterNode; 
		p.next = n; 
		swapHelper(head, afterNode, afterNode == null ? null : afterNode.next); 
	}
	
	public static void printLinkedList(ListNode l)
	{
		System.out.print("[");
		while(l!=null)
		{
			System.out.print(l.val+"->");
			l = l.next; 
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1); 
		ListNode node2 = new ListNode(2); 
		ListNode node3 = new ListNode(3); 
		ListNode node4 = new ListNode(4); 
		ListNode node5 = new ListNode(5); 
		ListNode node6 = new ListNode(6); 
		ListNode node7 = new ListNode(7); 
		ListNode node8 = new ListNode(8); 
		ListNode node9 = new ListNode(9); 
		head.next = node2; 
		node2.next = node3; 
		node3.next = node4; 
		node4.next = node5; 
		node5.next = node6; 
		node6.next = node7; 
		node7.next = node8; 
		node8.next = node9; 
		printLinkedList(head); 
		printLinkedList(swapPairs(head)); 
		
	}
}
