package com.leetcode.problemset;

import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/top-k-frequent-words/description/
public class TopKFrequent {
	
	 public static List<String> topKFrequent(String[] words, int k) 
	 {
	        HashMap<String, Integer> wordFreq = new HashMap<String,Integer>(); 
	        for(String word : words)
	        {
	            if(wordFreq.containsKey(word))
	                wordFreq.put(word, wordFreq.get(word)+1); //increment count
	            else
	                wordFreq.put(word, 1); //first time we are seeing it
	        }
			return null; 
	}

	 
	 public static void main(String[] args) {
		String[] testCase = new String[]{"i", "love", "leetcode", "i", "love", "coding"}; //["i", "love"]
		topKFrequent(testCase, 2); 
		String[] testCase2 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}; // ["the", "is", "sunny", "day"]
		topKFrequent(testCase2, 4); 
	}
}
