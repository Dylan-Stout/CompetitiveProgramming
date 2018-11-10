package com.leetcode.problemset;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share 
 * common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
	
	Example 1:
	
	Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
	Output: 16 
	Explanation: The two words can be "abcw", "xtfn".
	Example 2:
	
	Input: ["a","ab","abc","d","cd","bcd","abcd"]
	Output: 4 
	Explanation: The two words can be "ab", "cd".
	Example 3:
	
	Input: ["a","aa","aaa","aaaa"]
	Output: 0 
	Explanation: No such pair of words.

 * @author dylan
 *
 */
public class MaximumProductOfWordLength {
	
	//public static int maxProduct(String[] words)
	//{
		
	//}
	public HashMap<Integer, HashSet<Character>> stringCharFreq = new HashMap<Integer, HashSet<Character>>(); 
	
	public static void main(String[] args) {
		MaximumProductOfWordLength mpwl = new MaximumProductOfWordLength(); 
		MaximumProductOfWordLength mpwl2 = new MaximumProductOfWordLength(); 
		MaximumProductOfWordLength mpwl3 = new MaximumProductOfWordLength(); 
		String[] testArr = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}; 
		String[] testArr2 = new String[]{"a","ab","abc","d","cd","bcd","abcd"}; 
		String[] testArr3 = new String[]{"a","aa","aaa","aaaa"}; 
		System.out.println(mpwl.maxProduct(testArr));
		System.out.println(mpwl2.maxProduct(testArr2));
		System.out.println(mpwl3.maxProduct(testArr3));
	}
	
	public  int maxProduct(String[] words)
	{
		Comparator<String> lenCompare = new LengthComparator(); 
		printArray(words); 
		Arrays.sort(words, lenCompare); 
		printArray(words); 
		countFrequencies(words); 
		System.out.println(stringCharFreq.toString());
		for(int i =0; i< stringCharFreq.size()-2; i++)
		{
			for(int j = 1; j<stringCharFreq.size()-1; j++)
			{
				Iterator<Character> iter = stringCharFreq.get(i).iterator(); 
				boolean isValidCombo = true;
				while(iter.hasNext() && isValidCombo)
				{
					Character c = iter.next(); 
					if(stringCharFreq.get(j).contains(c))
						isValidCombo = false; 
				}
				if(isValidCombo)
					return stringCharFreq.get(i).size() * stringCharFreq.get(j).size(); 
			}
		}
		return 0; 
	}
	
	public  void countFrequencies(String[] arr)
	{
		for(int i =0; i< arr.length; i++)
		{
			for(int j=0; j<arr[i].length(); j++)
			{
				Character c = arr[i].charAt(j); 
		
				if(!stringCharFreq.containsKey(i))
				{
					HashSet<Character> set = new HashSet<Character>(); 
					set.add(c); 
					stringCharFreq.put(i, set); 
				}else{
					stringCharFreq.get(i).add(c); 
				}
					
			}
		}
	}


	public static void printArray(String[] arr)
	{
		System.out.print("[");
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i]);
			if(i!=arr.length-1)
				System.out.print(","); 
				
		}
		System.out.println("]");
		
	}
}
