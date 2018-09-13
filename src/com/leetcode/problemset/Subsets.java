package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * https://leetcode.com/problems/subsets/description/
 * 
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @author dystout
 *
 */
public class Subsets {
	
	/**
	 * Implemented with backtracking
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>(); // this reference will be passed down to method to populate list of list of integers (our subsets)
		Arrays.sort(nums);
		backtrack(subsets, new ArrayList<>(), nums, 0); 
        return null; 
    }

	private static void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] nums, int start) {
		// TODO Auto-generated method stub
		subsets.add(new ArrayList<>(tempList)); // add obligatory empty set because this is a subset of all sets
		for(int i = start; i<nums.length; i++)
		{
			tempList.add(nums[i]); 
			backtrack(subsets, tempList, nums, i+1); 
			tempList.remove(tempList.size()-1); 
		}
	}
	
	public static List<List<Integer>> subsetsEx(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) { return ans; }
        Arrays.sort(nums);  // non-descending order
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans; 
    }
    
    private static void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) { ans.add(new ArrayList<Integer>(list)); return; }
        dfs(ans, nums, list, index+1);  // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index+1);  // pick the number at this index
        list.remove(list.size()-1);
    }

	
	public static void main(String[] args) {
		subsetsEx(new int[] {1,2,3,4,5}); 
	}
	
	
	
	
}
