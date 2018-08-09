package com.leetcode.problemset;

/**
 * Given a sorted array consisting of only integers where every element 
 * appears twice except for one element which appears once. Find this single 
 * element that appears only once.
 * 
	Example 1:
	Input: [1,1,2,3,3,4,4,8,8]
	Output: 2
	Example 2:
	Input: [3,3,7,7,10,11,11]
	Output: 10
	Note: Your solution should run in O(log n) time and O(1) space.
	
 * @author dylan
 *
 */
public class SingleElementSortedArray {
	
	public int singleElementInDuplicateArray(int[] arr)
	{
		if(arr.length>=3)
		{
			int firstEnd = arr.length/2; 
			int compareMid = arr.length/2 + arr.length%2; 
			int endStart = compareMid + 1; 
			if(compareMid)
		}
		
		

		
		
		return 0; 
	}

}
