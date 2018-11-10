package com.leetcode.problemset;



public class ReverseLinkedList {
	
	public static ListNode reverseList(ListNode head)
	{
		if(head.next==null || head == null)
			return head; 
		ListNode prev = null; 
		ListNode curr = head; 
		while(curr!=null)
		{
			ListNode n = curr.next; 
			curr.next = prev; 
			prev = curr; 
			curr = n; 
		}
		return prev; 
	}
	
	public static void printList(ListNode node){
		System.out.print("["); 
		while(node!=null)
		{
			System.out.print(node.val+"->");
			node = node.next; 
		}
		System.out.print("]"); 
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1); 
		ListNode n2 = new ListNode(2); 
		ListNode n3 = new ListNode(3); 
//	    ListNode n4 = new ListNode(4); 
	    n1.next = n2; 
	    n2.next = n3; 
//	    n3.next = n4; 
	    printList(n1); 
	    ListNode h = reverseList(n1); 
	    printList(h); 
	}
}
