package com.linkedin.test;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.linkedin.problemset.RemoveDuplicateLinkedList;

public class RemoveDuplicateLinkedListTest {
	
	@Test
	public void trivialTestCases()
	{
		LinkedList<Integer> testList = new LinkedList<Integer>(); 
		testList.add(1); 
		testList.add(9); 
		testList.add(10); 
		testList.add(1); //duplicate
		testList.add(3); 
		testList.add(3); //duplicate
		testList.add(10); //duplicate
		testList.add(1); //duplicate
		testList.add(-1); 
		testList.add(-2); 
		LinkedList<Integer> expected = new LinkedList<Integer>(); 
		expected.add(1); 
		expected.add(9); 
		expected.add(10); 
		expected.add(3); 
		expected.add(-1); 
		expected.add(-2);
		LinkedList<Integer> empty = new LinkedList<Integer>(); 
		LinkedList<Integer> actual = RemoveDuplicateLinkedList.removeDuplicates(testList); 
		Assert.assertArrayEquals(empty.toArray(),  RemoveDuplicateLinkedList.removeDuplicates(empty).toArray()); // empty trivial case
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void mediumTestCases()
	{
		LinkedList<Integer> testList = new LinkedList<Integer>(); 
		testList.add(Integer.MIN_VALUE); 
		testList.add(Integer.MAX_VALUE); 
		testList.add(Integer.MIN_VALUE); //duplicate
		testList.add(56); 
		testList.add(45); 
		testList.add(34563); 
		testList.add(3546); 
		testList.add(345); 
		testList.add(34); 
		testList.add(74); 
		testList.add(62); 
		testList.add(51); 
		testList.add(41); 
		testList.add(14); 
		testList.add(18); 
		testList.add(19); 
		testList.add(10); 
		testList.add(100); 
		testList.add(900); 
		testList.add(1000); 
		testList.add(1); //duplicate
		testList.add(3); 
		testList.add(3); //duplicate
		testList.add(1); //duplicate
		testList.add(-1); 
		testList.add(-2); 
		LinkedList<Integer> expected = new LinkedList<Integer>(); 
		expected.add(Integer.MIN_VALUE); 
		expected.add(Integer.MAX_VALUE); 
		expected.add(56); 
		expected.add(45); 
		expected.add(34563); 
		expected.add(3546); 
		expected.add(345); 
		expected.add(34); 
		expected.add(74); 
		expected.add(62); 
		expected.add(51); 
		expected.add(41); 
		expected.add(14); 
		expected.add(18); 
		expected.add(19); 
		expected.add(10); 
		expected.add(100); 
		expected.add(900); 
		expected.add(1000); 
		expected.add(3); 
		expected.add(-1); 
		expected.add(-2); 
		LinkedList<Integer> actual = RemoveDuplicateLinkedList.removeDuplicates(testList); 
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
