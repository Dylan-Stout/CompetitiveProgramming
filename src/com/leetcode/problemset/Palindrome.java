package com.leetcode.problemset;
/**
 * 9. Palindrome Number
 * 
 * https://leetcode.com/problems/palindrome-number/description/
 * 
 * Common palindrome problem 
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

	Example 1:
	
	Input: 121
	Output: true
	Example 2:
	
	Input: -121
	Output: false
	Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
	Example 3:
	
	Input: 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
	Follow up:
	
	Coud you solve it without converting the integer to a string?
 * 
 * @author dystout
 *
 */
public class Palindrome {
	
	public static boolean isPalindrome(int x) {
	    if(x<9 && x>=0) return true; 
        String forward = String.valueOf(x); 
        StringBuilder sb = new StringBuilder(String.valueOf(x)); 
        String backwards = sb.reverse().toString(); 
        return forward.equals(backwards); 
        
    }
	
	/**
	 * Lazy test drive method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome(-122)); 
		System.out.println(isPalindrome(100)); 
		System.out.println(isPalindrome(983847)); 
		System.out.println(isPalindrome(111121111)); 
		System.out.println(isPalindrome(143414341)); 
	}
	
	

}
