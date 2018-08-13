package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-closest-time/description/
 * 
 * 681. Next Closest Time
 * 
 * 
 * Given a time represented in the format "HH:MM", form the next closest time by reusing 
 * the current digits. There is no limit on how many times a digit can be reused.
	
	You may assume the given input string is always valid. For example, 
	"01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
	
	
	Input: "19:34"
	Output: "19:39"
	
	Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, 
	which occurs 5 minutes later.  It is not 19:33, because this 
	occurs 23 hours and 59 minutes later.

 * @author dylan
 *
 */
public class NextClosestTime {

	   public static String nextClosestTime(String time) {
		    StringBuilder t = new StringBuilder( time.replace(":", "")); 
		    HashSet<Character> numCharSet = new HashSet<Character>();
		    numCharSet.add(t.charAt(0)); 
		    numCharSet.add(t.charAt(1)); 
		    numCharSet.add(t.charAt(2)); 
		    numCharSet.add(t.charAt(3)); 
		    // trivial case where all numbers are the same
		    if(numCharSet.size()==1) return time; 
		    
		    /**
		     * Sorted list of numbers in set
		     */
		    List<Character> numCharList = new ArrayList<Character>(numCharSet); 
		    Collections.sort(numCharList);
		    
		    /**
		     * Implements a constant time lookup map for getting the index of a character in the array
		     */
		    HashMap<Character,Integer> indexLookupMap = new HashMap<Character,Integer>(); 
		    for(int i =0; i<numCharList.size(); i++)
		    {
		    	if(indexLookupMap.containsKey(numCharList.get(i))) continue; 
		    	indexLookupMap.put(numCharList.get(i), i); 
		    }
		    int timeInMinutes = (Integer.parseInt(t.substring(0,2))*60)+Integer.parseInt(t.substring(2,4)); 
		    
		    /**
		     * move through the string backwards and determine if there are larger values for the indices
		     */
		    for(int i=3; i>=0;i--)
		    {
		    	char value = t.charAt(i); 
		    	int index = indexLookupMap.get(value); 
		    	if(index<numCharList.size()-1) { //if there is a higher value try using it
		    		t.setCharAt(i,  numCharList.get(value));
		    		
		    	}
		    	
		    }
		    
		    
		    
		    //determine iteratively which number from the set is closest to the index value
		    
	        return null; 
	    }
	   
	   /**
	    * Check to see if given string is a parseable time of "0000" to "2359"
	    * @param time
	    * @return
	    */
	   public static boolean isValidTime(String time) {
		   if(Integer.valueOf(time.substring(0, 1))<0 || Integer.valueOf(time.substring(0,1))>2)
			   return false; 
		   if(Integer.valueOf(time.substring(1,2))<0 || Integer.valueOf(time.substring(1,2))>9)
			   return false; 
		   if(Integer.valueOf(time.substring(2,3))<0 || Integer.valueOf(time.substring(2,3)) > 5)
			   return false; 
		   if(Integer.valueOf(time.substring(3,4))<0 || Integer.valueOf(time.substring(3,4)) > 9)
			   return false; 
		   return true;    		   
	   }
	   /**
	    * Check to see if given string is a parseable time of "00:00" to "23:59"
	    * @param time
	    * @return
	    */
	   public boolean isValidColonTime(String time) {
		   if(Integer.valueOf(time.substring(0, 1))<0 || Integer.valueOf(time.substring(0,1))>2)
			   return false; 
		   if(Integer.valueOf(time.substring(1,2))<0 || Integer.valueOf(time.substring(1,2))>9)
			   return false; 
		   if(!time.substring(2,3).equals(":"))
			   return false; 
		   if(Integer.valueOf(time.substring(3,4))<0 || Integer.valueOf(time.substring(3,4)) > 5)
			   return false; 
		   if(Integer.valueOf(time.substring(4,5))<0 || Integer.valueOf(time.substring(4,5)) > 9)
			   return false; 
		   return true;    		   
	   }
	   /**
	    * Taken from solutions since i couldnt figure it out :(
	    * @param time
	    * @return
	    */
	   public static String nextClosestTimeExample(String time) {
	        int[] arr = new int[4];
	        int[] arr2 = new int[4];
	        int[] arr3 = new int[4]; 
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0, j = 0; i < 5; i++) {
	            if (i == 2) continue;
	            arr[j] = time.charAt(i) - '0';
	            arr2[j] = time.charAt(i) - '0';
	            arr3[j] = time.charAt(i) - '0';
	            j++;
	        }
	        Arrays.sort(arr2);
	        for (int i = 0; i < 4; i++) {
	            map.put(arr2[i], i);
	        }
	        for (int i = 3; i >= 0; i--) {
	            int ind = map.get(arr[i]);
	            if (ind < 3) {
	                arr3[i] = arr2[ind + 1];
	                for (int j = i + 1; j < 4; j++) {
	                    arr3[j] = arr2[0];
	                }
	                if (arr3[0] * 10 + arr3[1] < 24 && arr3[2] * 10 + arr3[3] < 60) {
	                    return "" + arr3[0] + arr3[1] + ":" + arr3[2] + arr3[3];
	                }
	            }
	        }
	        return "" + arr2[0] + arr2[0] + ":" + arr2[0] + arr2[0];
	    }
	   
	   public static void main(String[] args) {
		   System.out.println(nextClosestTime("23:45")); 
	   }
}
