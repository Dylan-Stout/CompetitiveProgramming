package com.crackingthecodinginterview.test.chapter7;

import org.junit.Assert;
import org.junit.Test;

import com.crackingthecodinginterview.problemset.chapter7.TrainingInsertionSort;

public class TrainingInsertionSortTest {
	
	@Test
	public void insertionSortTest()
	{
		int[] testArr = new int[]{34,2,3,5,13,341,23,45,14,6,}; 
		int[] expected = new int[]{2,3,5,6,13,14,23,34,45,345};
		int[] actual = TrainingInsertionSort.insertionSort(testArr);
		Assert.assertArrayEquals(expected, actual); 
	}

}
