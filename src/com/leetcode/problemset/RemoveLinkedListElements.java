package com.leetcode.problemset;

public class RemoveLinkedListElements {
	
	
	public static ListNode removeElements(ListNode head, int val) {
		ListNode n = head; 
		while(n.next !=null)
		{ 
			if(n.next.val == val)
			{
				n.next = n.next.next; 
			}
			n = n.next; 
		}
        return head; 
    }
	
	
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1); 
		ListNode l2 = new ListNode(2); 
		l1.next=l2; 
		ListNode l3 = new ListNode(3); 
		l2.next=l3; 
		ListNode l4 = new ListNode(4); 
		l3.next=l4; 
		ListNode l41 = new ListNode(4); 
		l4.next=l41; 
		ListNode l42 = new ListNode(4); 
		l41.next=l42; 
		ListNode l43 = new ListNode(4);
		l42.next=l43; 
		ListNode l5 = new ListNode(5); 
		l43.next = l5; 
		ListNode n = l1; 
		while(n!=null)
		{
			System.out.print(n.val + "->");
			n = n.next; 
		}
		ListNode result = removeElements(l1,4); 
		while(result!=null)
		{
			System.out.print(result.val + "->");
			result = result.next; 
		}
	}

}
