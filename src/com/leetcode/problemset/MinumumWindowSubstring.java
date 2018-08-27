package com.leetcode.problemset;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

	Example:
	
	Input: S = "ADOBECODEBANC", T = "ABC"
	Output: "BANC"
	
	Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


 * @author dylan
 *
 */
public class MinumumWindowSubstring {
	
	/**
	 * The thought process here is to create a frequency counter of the letters in String s
	 * and place them in HashMap. We may possibly need a Set to hold the values of t to account 
	 * for duplicates?  or maybe a frequency counter there as well? 
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static String minWindow(String s, String t)
	{
		//trivial cases
		if(s==null || t==null || t.length()>s.length() || s.length() ==0) 
			return ""; 
		
		/**
		 * Count the frequency of the characters in S
		 */
		HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>(); 
		for(char c : t.toCharArray())
		{
			if(!frequencyMap.containsKey(c))
				frequencyMap.put(c, 1); 
			else
				frequencyMap.put(c, frequencyMap.get(c)+1); 
		}

		int left = 0; 
		int pointLeft = 0; 
		int minLength = s.length(); 
		int count = 0; 
		
		for(int right = 0; right < s.length(); right++){
	        if(frequencyMap.containsKey(s.charAt(right))){
	        	frequencyMap.put(s.charAt(right),frequencyMap.get(s.charAt(right))-1);
	            if(frequencyMap.get(s.charAt(right)) >= 0){
	                count ++;
	            }
	            while(count == t.length()){
	                if(right-left+1 < pointLeft){
	                	pointLeft = left;
	                	pointLeft = right-left+1;
	                }
	                if(frequencyMap.containsKey(s.charAt(left))){
	                	frequencyMap.put(s.charAt(left),frequencyMap.get(s.charAt(left))+1);
	                    if(frequencyMap.get(s.charAt(left)) > 0){
	                        count --;
	                    }
	                }
	                left ++ ;
	            }
	        }
	    }
	    if(pointLeft>s.length())  
	    {  
	        return "";  
	    }  
	    
	    return s.substring(pointLeft,pointLeft+minLength);
	}
	
	public static void main(String[] args) {
		System.out.println("POOP->DASDDSKKJGLSKDJFLSDKFJSDLKGJLKDFOOPSDOFIFPOAOPFDJFKDSLKFJIDIOPFOFOSP");
		System.out.println(minWindow("DASDDSKKJGLSKDJFLSDKFJSDLKGJLKDFOOPSDOFIFPOAOPFDJFKDSLKFJIDIOPFOFOSP", "POOP")); 
	}

}
