package com.crackingthecodinginterview.problemset.chapter6;
/**
 * Calculating the upper bounds for the asymptotic runtime complexity for the
 * following examples for Chapter 6 of cracking the coding interview. 
 * 
 * Comments will provide analysis, no unit tests will be provided. The code is 
 * not meant to be run, only analyzed. 
 * 
 * @author dylan
 *
 */
public class BigORuntimes {
	
	/**
	 * VI.1 - Computes product a and b - O(b-a)
	 */
	public int product(int a, int b) { // we have two separate inputs, no longer dealing with one variable length
		int sum = a; // O(1)
		for (int i = a; i < b; i++) { // this is when a<b where a is iteratively bigger which leads to O(b-a)
			sum += a; //O(1)
		}
		return sum; //O(1)
	}
	
	/**
	 * VI.2 - Calculates a^b - O(b)
	 */
	public int power(int a, int b) { // runtime is not dependent on 'a' at all
		if (b < 0){ // O(1)
			return 0; // O(1)
		} else if (b==0){ // O(1)
			return 1; // O(1)
		}else { // O(1)
			return a * power(a, b - 1); // called recursively until 'b' is 0 - O(b)
		}
	}
	
	
	/**
	 * VI.3 - Computes a % b  - O(1)
	 */
	public int mod(int a, int b)
	{
		if(b<=0){ // O(1)
			return -1; // O(1)
		}
		int div = a/b; //O(1) 
		return a - div * b; // O(1)
	}
	
	
	/**
	 * VI.4 - integer division (assum a and b both positive) - O(a)
	 */
	public int div(int a, int b){
		int count = 0; //O(1)
		int sum = b; //O(1)
		while(sum<=a){ // O(a) worst case this could be the size of a because b could be 1 so we would count a # of times 
			sum+=b; // O(1)
			count++; //O(1)
		}
		return count; //O(1) 
	}
	
	/**
	 * VI.5 - Computes the [integer] square root of a number. If the number is not 
	 * a perfect square (there is no integer square root), then it returns -1. It does
	 * this by successive guessing. If n is 100, it's first guess is 50. Too high? Try
	 * something lower - halfway between 1 and 50. 
	 * 
	 * 
	 */
	public int sqrt(int n){
		return sqrt_helper(n,1,n); // how many times could we potentially call this? - O(N) is the
								  // first logical choice since we could have a number that does not have 
								  // a perfect square, but this is likely wrong because we have conditional
								  //bounds on whether our guess is too high/low. Seems similar to binary search
								  // in the way we move our min/max. 
	}
	
	/**
	 * VI.5 Part 2 - square root helper method -
	 * 
	 * @param n
	 * @param min
	 * @param max
	 * @return
	 */
	public int sqrt_helper(int n, int min, int max) // without the recursive calls this costs O(1) time
	{
		if(max<min) return -1; // no square root // O(1) comparison
		int guess = (min + max) / 2; // O(1) 
		if( guess * guess == n){ // found it! // O(1)
			return guess;  //O(1) 
		}else if(guess * guess < n){ //too low // O(1)
			return sqrt_helper(n, guess+1, max); // try higher 
		}else{ // too high
			return sqrt_helper(n, min, guess -1); // try lower
		}
	}
	/**
	 * 
	 * VI.6 
	 * The following code computes the [integer) square root of a number. If the number is not 
	 * a perfect square (there is no integer square root), then it returns -1. It does this by 
	 * trying increasingly large numbers until it finds the right value (or is too high). 
	 * What is its runtime?
	 * 
	 * @param n
	 * @return
	 */
	public int sqrt_proper(int n){
		for(int guess = 1; guess * guess <= n; guess++)
		{
			if(guess*guess==n){
				return guess;
			}
		}
		return -1; 
	}
	
	/***
	 * VI.7 - If a binary search tree is not balanced how long might it take (worst case)
	 * to find an element in it?
	 */
	
	/**
	 * VI.8 - You are looking for a specific value in a binary tree, but the tree is not 
	 * a binary search tree. What is the time complexity of this?
	 */
	
	/**
	 * VI.9 - The appendToNew method appends a value to an array by creating a new, longer
	 *  array and returning this longer array. You've used the appendToNew method to create
	 *   a copyArray function that repeatedly calls appendToNew. How long does copying an 
	 *   array take?
	 */
	public int[] copyArray(int[] array){
		int[] copy = new int[0]; 
		for(int value: array){
			copy = appendToNew(copy, value); 
		}
		return copy; 
	}
	/** VI.9 - part 2 **/
	public int[] appendToNew(int[] array, int value)
	{
		//copy all elements over to new array
		int[] bigger = new int[array.length + 1]; 
		for(int i=0; i<array.length; i++)
		{
			bigger[i] = array[i]; 
		}
		
		//add new element
		bigger[bigger.length-1] = value; 
		return bigger; 
	}
	
	/**
	 * VI.10 - Sums the digits in a number what is the big O time?
	 */
	public int sumDigits(int n){
		int sum = 0; 
		while(n>0){
			sum+=n %10; 
			n/=10; 
		}
		return sum; 
	}
}
