package com.leetcode.problemset;

public class CountOddCharacterWords {
	
	public int countOddCharacterWords(String s)
	{
		int numOddWords = 0; 
		String[] words = s.split(" "); 
		for(String word : words)
		{
			if(words.length%2==1)
				numOddWords= numOddWords + 1; 
		}
		return numOddWords; 
	}

}
