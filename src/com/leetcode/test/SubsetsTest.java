package com.leetcode.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.leetcode.problemset.Subsets;

public class SubsetsTest {
	
	@Test
	public void testOnlineExample()
	{
		int[] onlineExample = {1,2,3}; 
		ArrayList<List<Integer>> onlineExampleSolution = new ArrayList<List<Integer>>(); 
		List<Integer> subsetList1 = null; 
		List<Integer> subsetList2 = Arrays.asList(1); 
		List<Integer> subsetList3 = Arrays.asList(2); 
		List<Integer> subsetList4 = Arrays.asList(3); 
		List<Integer> subsetList5 = Arrays.asList(1,2,3); 
		List<Integer> subsetList6 = Arrays.asList(1,2); 
		List<Integer> subsetList7 = Arrays.asList(2,3); 
		List<Integer> subsetList8 = Arrays.asList(1,3); 
		onlineExampleSolution.add(0, subsetList1);
		onlineExampleSolution.add(1, subsetList2);
		onlineExampleSolution.add(2, subsetList3);
		onlineExampleSolution.add(3, subsetList4);
		onlineExampleSolution.add(4, subsetList5);
		onlineExampleSolution.add(5, subsetList6);
		onlineExampleSolution.add(6, subsetList7);
		onlineExampleSolution.add(7, subsetList8);
		Subsets s = new Subsets(); 
		assertEquals(onlineExampleSolution,s.subsets(onlineExample)); 
		
	}

}
