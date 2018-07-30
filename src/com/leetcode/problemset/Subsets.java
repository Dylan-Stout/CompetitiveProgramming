package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	protected List<List<Integer>> knownSubsets = new ArrayList<List<Integer>>(); 


	public List<List<Integer>> subsets(int[] nums)
	{
		knownSubsets.add(null); //every set has the empty set
		if(nums.length==0) // trivial solution when the set is empty
			return knownSubsets; 
		Integer[] objNums = new Integer[nums.length]; 
		for(int i =0; i<nums.length;i++)
		{
			objNums[i] = (Integer)nums[i]; 
		}

		if(objNums.length==1){ // trivial solution when the set is length 1 
			knownSubsets.add(Arrays.asList(objNums)); 
			return knownSubsets; 
		}
		addSubsets(objNums,null); //recursively add two subsets of the set subsets to list of known subsets 
		return knownSubsets; 
	}

	public void addSubsets(Integer[] leftDivision, Integer[] rightDivision)
	{
		if(rightDivision==null) knownSubsets.add(null); // add null set on first go
		else if
		if(leftDivision.length==1){ knownSubsets.add(Arrays.asList(leftDivision)); return; } // reached leaf nodes return
		else knownSubsets.add(Arrays.asList(rightDivision)); //add right 
		knownSubsets.add(Arrays.asList(leftDivision)); 		//add left 
		if(leftDivision.)
		int leftMid = leftDivision.length%2==0?leftDivision.length/2:(leftDivision.length/2)+1; 
		int rightMid = rightDivision.length%2==0?rightDivision.length/2:(rightDivision.length/2)-1; 
		
		
	}
}
