package com.crackingthecodinginterview.test.chapter7;

import java.util.LinkedList;

import org.junit.Test;

import com.crackingthecodinginterview.problemset.chapter7.TrainingLinkedList;

/**
 * Implement a Linked List from scratch
 * 
 * @author dystout
 *
 */
public class TrainingLinkedListTest {
	
		@Test
		public void trivialCaseTest()
		{
			LinkedList<Integer> iLinkedList = new LinkedList<Integer>(); 
			iLinkedList.add(1); 
			iLinkedList.add(2); 
			iLinkedList.add(3); 
			TrainingLinkedList testLinkedList = new TrainingLinkedList(); 
			testLinkedList.add(1); 
			testLinkedList.add(2); 
			testLinkedList.add(3); 
			assertEquals(iLinkedList.remove(),testLinkedList.remove()); 
			assertEquals(iLinkedList.remove(),testLinkedList.remove()); 
			assertEquals(iLinkedList.remove(),testLinkedList.remove()); 
			
		}

}
