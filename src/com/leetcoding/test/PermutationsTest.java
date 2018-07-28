package com.leetcoding.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.leetcoding.problemset.Permutations;

public class PermutationsTest {

	@Test
	public void testOnlineExample(){
		int[] testSet = {1,2,3}; 
		List<List<Integer>> solution = new ArrayList<List<Integer>>(); 
		Integer[] sArray1 = {1,2,3}; 
		Integer[] sArray2 = {1,3,2}; 
		Integer[] sArray3 = {2,1,3}; 
		Integer[] sArray4 = {2,3,1}; 
		Integer[] sArray5 = {3,2,1}; 
		Integer[] sArray6 = {3,1,2}; 

		solution.add(Arrays.asList(sArray1));
		solution.add(Arrays.asList(sArray2));
		solution.add(Arrays.asList(sArray3));
		solution.add(Arrays.asList(sArray4));
		solution.add(Arrays.asList(sArray5));
		solution.add(Arrays.asList(sArray6));
		Permutations p = new Permutations(); 
		assertEquals(solution, p.permute(testSet)); 
	}
}
