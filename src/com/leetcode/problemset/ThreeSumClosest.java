package com.leetcode.problemset;
/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	
	Example:
	
	Given array nums = [-1, 2, 1, -4], and target = 1.
	
	The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author dylan
 *
 */
public class ThreeSumClosest {
	
	public static int threeSumClosest(int[] nums, int target)
	{
		if(nums.length<3)
			return 0; 
		if(nums.length==3)
			return nums[0] + nums[1] + nums[2]; 
		int closestDist = Integer.MAX_VALUE;
		int closestSum = 0; 
		for(int i =0; i<nums.length-2; i++)
		{
			for(int j=i+1; j<nums.length-1; j++)
			{
				for(int k=j+1; k<nums.length; k++)
				{
					if(distanceBetween(nums[i], nums[j], nums[k], target)<closestDist)
					{
						closestDist = distanceBetween(nums[i], nums[j], nums[k], target);
						closestSum = nums[i] + nums[j] + nums[k]; 
					}
				}
			}
		}
		return closestSum; 
	}
	
	/*
	 * Find distance between target and the sum of i, j, k
	 */
	public static int distanceBetween(int i, int j, int k, int target)
	{
		return Math.abs((i+j+k)-target); 
	}

	public static void main(String[] args) {
		int[] testArr = new int[]{0,0,0}; 
		System.out.println(threeSumClosest(testArr, 1));
	}
}
