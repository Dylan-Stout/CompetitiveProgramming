package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;



/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 * @author dystout
 *
 */
public class ThreeSum {
	
	public String concatNumbers(int i, int j, int k){
		return String.valueOf(i) + "|" + String.valueOf(j)+"|"+String.valueOf(k); 
	}
	
	public List<List<Integer>>	threeSum(int[] nums)
	{
		Arrays.sort(nums);
		HashSet<String> combos = new HashSet<String>(); 
		ArrayList<List<Integer>> solution = new ArrayList<List<Integer>>(); 
		for(int i =0; i<nums.length-2; i++) // only go up to 3rd to last position since that will be the last combination
		{
			for(int j=i+1;j<nums.length-1; j++)// only go up to 2nd to last position since that will be the last combination
			{
				for(int k=j+1;k<nums.length;k++) // last position
				{
					if(nums[i]+nums[j]+nums[k]==0 && !combos.contains(concatNumbers(nums[i],nums[j],nums[k]))){
						solution.add(Arrays.asList(nums[i],nums[j],nums[k]));
						combos.add(concatNumbers(nums[i],nums[j],nums[k])); 
					}
				}
			}
			
		}
		return solution;
		
	}

}
