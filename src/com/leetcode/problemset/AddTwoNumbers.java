package com.leetcode.problemset;

public class AddTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        Long l1Decoded = decode(l1, new StringBuilder()); 
	        Long l2Decoded = decode(l2, new StringBuilder()); 
	        StringBuilder sb = new StringBuilder(String.valueOf(l1Decoded+l2Decoded)); 
	        return encode(sb.reverse().toString()); 
	    }
	    
	    public Long decode(ListNode listNode, StringBuilder sb)
	    {
	       sb.append(String.valueOf(listNode.val)); 
	       ListNode nextNode = listNode.next; 
	       while(nextNode!=null)
	       {
	           sb.append(nextNode.val); 
	           nextNode=nextNode.next; 
	       }
	       return Long.valueOf(sb.reverse().toString()); 
	    }
	    
	    public ListNode encode(String stringRep)
	    {
	    	if(stringRep.length()==0)return null; 
	    	String firstChar = stringRep.length()!=1 ? stringRep.substring(0, 1) : stringRep; 
	        ListNode node = new ListNode(Integer.valueOf(firstChar));
	       //we arent at the last character in the string yet recursively call yourself again
	        node.next = encode(stringRep.substring(1,stringRep.length())); 
	        return node; 
	    }
	    
	    public static void main(String[] args) {
	    	ListNode l1 = new ListNode(1); 
			ListNode l2 = new ListNode(9); 
			ListNode l3 = new ListNode(9); 
			ListNode l4 = new ListNode(9); 
			ListNode l5 = new ListNode(9); 
			ListNode l6 = new ListNode(9); 
			ListNode l7 = new ListNode(9); 
			ListNode l8 = new ListNode(9); 
			l1.next=l2; 
			l2.next=l3; 
			l3.next=l4; 
			l4.next=l5; 
			l5.next=l6; 
			l6.next=l7; 
			l7.next=l8; 
			ListNode l9 = new ListNode(1); 
			ListNode l10 = new ListNode(9); 
			ListNode l11 = new ListNode(9); 
			ListNode l12 = new ListNode(9); 
			ListNode l13 = new ListNode(9); 
			ListNode l14 = new ListNode(9); 
			ListNode l15 = new ListNode(9); 
			ListNode l16 = new ListNode(9); 
			ListNode l17 = new ListNode(9); 
			ListNode l18 = new ListNode(9); 
			l9.next = l10; 
			l10.next = l11; 
			l11.next = l12; 
			l12.next = l13; 
			l13.next = l14; 
			l14.next = l15; 
			l15.next = l16; 
			l16.next = l17; 
			l17.next = l18; 
	
			AddTwoNumbers testClass = new AddTwoNumbers();
			testClass.addTwoNumbers(l1, l9); 
		}
}
