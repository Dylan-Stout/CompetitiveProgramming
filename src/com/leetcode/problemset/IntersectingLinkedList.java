package com.leetcode.problemset;

import java.util.HashSet;

public class IntersectingLinkedList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	       if(headA==null || headB==null)
	           return null; 
			if(headA == headB)
	            return headA; 
	       HashSet<ListNode> nodeSet = new HashSet<ListNode>(); 
	       ListNode a = headA; 
	       while(a.next!=null)
	       {
	            nodeSet.add(a); 
	       }
	       
	       ListNode b = headB; 
	       while(b.next != null)
	       {
	           if(nodeSet.contains(b))
	               return b; 
	       }
	       return null; 
		}
		
		public static void main(String[] args) {
			ListNode l1 = new ListNode(2); 
			ListNode l2 = new ListNode(3); 
			l1.next = l2; 
			if(getIntersectionNode(l1, l2)==null)
				System.out.println("NONE");
			else
				System.out.println(getIntersectionNode(l1, l2).val);
		}

}
