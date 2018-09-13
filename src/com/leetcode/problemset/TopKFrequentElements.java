package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 * 
 * Given a non-empty array of integers, return the k most frequent elements.

		Example 1:

		Input: nums = [1,1,1,2,2,3], k = 2
		Output: [1,2]

		Example 2:

		Input: nums = [1], k = 1
		Output: [1]

		Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


 * @author dylan
 *
 */
public class TopKFrequentElements {




	public static List<Integer> topKFrequent(int[] nums, int k)
	{
		HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>(); 
		for(int i=0; i<nums.length; i++)
		{
			if(frequencyMap.containsKey(nums[i]))
				frequencyMap.put( nums[i] , frequencyMap.get(nums[i])+1); 
			else
				frequencyMap.put(nums[i], 1); 
		}
		PriorityQueue<Map.Entry<Integer, Integer>> maxPriorQueue =  new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
		maxPriorQueue.addAll(frequencyMap.entrySet()); 
		List<Integer> solutions = new ArrayList<Integer>();
		for( int i=0; i<k; i++)
		{
			solutions.add(maxPriorQueue.poll().getKey()); 
		}
	
	
		
		return solutions; 

	}
	
	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[] {1,1,1,2,2,3},2).toString()); 
	}


}
