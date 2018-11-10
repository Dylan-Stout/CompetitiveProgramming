package com.leetcode.problemset;


/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

	Example:
	
	Given linked list: 1->2->3->4->5, and n = 2.
	
	After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	
	Given n will always be valid.
	
	Follow up:
	
	Could you do this in one pass?
 * @author dylan
 *
 */
public class RemoveNthNodeFromEndOfList {
	
	public static ListNode removeNthFromEnd(ListNode head, int n )
	{
		ListNode dummy = new ListNode(0); 
		dummy.next = head; 
		ListNode fast = head; 
		ListNode slow = head; 
		ListNode prevSlow = dummy; 
		int goAhead = n-1; 
		while(goAhead>0)
		{
			fast = fast.next; 
			goAhead--; 
		} // go ahead n spaces
		
		while(fast.next!=null) // move together until fast reaches end
		{
			fast = fast.next; 
			slow = slow.next; 
			prevSlow = prevSlow.next; 
		} 
		
		if(prevSlow == dummy){
			// the slow is the original head
			if(n==1) //is it also the last?
				return null;
			else{
				slow.next = null; 
				head = slow.next; 
			}
				
		}
		else{
			prevSlow.next = slow.next; 
			slow.next = null; 
		}
		
		return head; 
	}
	
	public static void printList(ListNode node)
	{
		System.out.print("[");
		while(node!=null)
		{
			System.out.print(node.val+"->");
			node = node.next; 
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		head.next = l2; 
//		l2.next = l3; 
//		l3.next = l4; 
//		l4.next = l5; 
		printList(head); 
		removeNthFromEnd(head, 2); 
		printList(head); 
	}

}
