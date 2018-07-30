package com.leetcode.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.problemset.AddTwoNumbers;
import com.leetcode.problemset.ListNode;

public class AddTwoNumbersTest {

	
	@Test
	public void testOnlineExample()
	{
		ListNode l1 = new ListNode(2); 
		ListNode l2 = new ListNode(4); 
		ListNode l3 = new ListNode(3); 
		l1.next=l2; 
		l2.next=l3; 
		ListNode l4 = new ListNode(5); 
		ListNode l5 = new ListNode(6); 
		ListNode l6 = new ListNode(4); 
		l4.next=l5; 
		l5.next=l6; 
		
		ListNode solutionRoot = new ListNode(7); 
		solutionRoot.next = new ListNode(0); 
		solutionRoot.next.next = new ListNode(8); 
		AddTwoNumbers testClass = new AddTwoNumbers(); 
		assertEquals(solutionRoot,testClass.addTwoNumbers(l1, l4)); 
	}
}
