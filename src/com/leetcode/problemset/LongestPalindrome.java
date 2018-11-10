package com.leetcode.problemset;

public class LongestPalindrome {
	
	public String longestPalindromicSubstring(String s)
	{
		int length = s.length(); 
		if(s==null || s.length()<2)
		{
			return s; 
		}
		
		boolean[][] isPalindrome = new boolean[length][length]; 
		
		for(int row = 0, col = 0; col<length; row++, col++)
		{ isPalindrome[row][col] = true; }
		
		int l, r = 0; 
		
		for(int row = 0; row<length-1; row++, col++)
		{
			
		}
	}

}
