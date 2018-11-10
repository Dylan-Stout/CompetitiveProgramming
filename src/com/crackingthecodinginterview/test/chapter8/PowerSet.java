package com.crackingthecodinginterview.test.chapter8;

import java.util.ArrayList;

public class PowerSet {
	
	
	public static void reverse(String[]	array){
		for(int i=0; i<array.length/2; i++){
			  String temp = array[i];
			  array[i] = array[array.length -i -1];
			  array[array.length -i -1] = temp;
			}
	}
	
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
	{
		String[] s = new String[10]; 
		reverse(s); 
		ArrayList<ArrayList<Integer>> allSubsets ; 
		if(set.size()==index) // base case -- add empty set 
		{
			allSubsets = new ArrayList<ArrayList<Integer>>(); 
			allSubsets.add(new ArrayList<Integer>()); // EMPTY SET
		}else
		{
			allSubsets = getSubsets(set, index+1); 
			int item = set.get(index); 
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>(); 
			for(ArrayList<Integer> subset : allSubsets)
			{
				ArrayList<Integer> newSubset = new ArrayList<Integer>(); 
				newSubset.addAll(subset); 
				newSubset.add(item); 
				moreSubsets.add(newSubset); 
			}
			allSubsets.addAll(moreSubsets); 
		}
		return allSubsets; 
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> testSet = new ArrayList<Integer>();
		testSet.add(1); 
		testSet.add(2);
		testSet.add(3);
		//testSet.add(4);
		System.out.println(getSubsets(testSet, 0));
	}
	

}
