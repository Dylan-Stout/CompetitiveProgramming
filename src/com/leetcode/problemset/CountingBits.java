package com.leetcode.problemset;

public class CountingBits {
	
	public static int[] countBits(int num) {

	    int[] answer = new int[num+1]; // create empty array of the size of the integer+1??
	    
	    if(num >= 0)
	    	answer[0] = 0; // sign bit
	    
	    for(int i = 1;i<=num;i++){ // since we signed it, start at [1] and iterate through 
	        int j = i%2; 
	        int a = answer[i/2]; 
	        answer[i] = answer[i/2] + i%2;
	        
	    }
	    
	    return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(countBits(10));
	}

}
