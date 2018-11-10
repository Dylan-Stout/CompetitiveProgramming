package com.leetcode.problemset;
/**\
 * Find the square root of a number without using sqrt function
 * @author dylan
 *
 */
public class SquareRoot {
	
	public static double squareRoot(double n)
	{
		
		for(double i = 0.0000000001; i<n; i+=0.0000000001)
		{
			if(i*i==n) return i; 
		}
		return -1; 
	}
	
	
	public static void main(String[] args) {
		System.out.println("SQRT:4 = " + squareRoot(4));
		System.out.println("SQRT:16 = " + squareRoot(16));
		System.out.println("SQRT:32 = " + squareRoot(32));
		System.out.println("SQRT:64 = " + squareRoot(64));
		
	}

}
