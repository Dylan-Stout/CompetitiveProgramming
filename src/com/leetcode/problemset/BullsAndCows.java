package com.leetcode.problemset;

import java.util.HashMap;

/**
 * 299. Bulls and Cows
 * 
 * https://leetcode.com/problems/bulls-and-cows/description/
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
	
	Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 
	
	Please note that both secret number and friend's guess may contain duplicate digits.
	
	Example 1:
	
	Input: secret = "1807", guess = "7810"
	
	Output: "1A3B"
	
	Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
	
	Example 2:
	
	Input: secret = "1123", guess = "0111"
	
	Output: "1A1B"
	
	Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * 
 * @author dylan
 *
 */
public class BullsAndCows {
	
	
	    public static String getHint(String secret, String guess) {
	        HashMap<Character, Integer> knownNumbers = new HashMap<Character,Integer>(); 
	        int bulls=0; 
	        int cows=0; 
	        char[] secretChar = secret.toCharArray(); 
	        char[] guessChar = guess.toCharArray(); 
	        for(int i=0; i<secret.length(); i++)
	        {
	            if(knownNumbers.containsKey(secretChar[i]))
	                knownNumbers.put(secretChar[i], knownNumbers.get(secretChar[i])+1); 
	            else
	                knownNumbers.put(secretChar[i],1) ; 
	        }
	        for(int i =0; i<secret.length(); i++)
	        {
	            if(knownNumbers.containsKey(guessChar[i]) && knownNumbers.get(guessChar[i])>0){
	                if(guessChar[i]==secretChar[i])
	                    bulls++; 
	                else
	                    cows++; 
	                knownNumbers.put(guessChar[i], knownNumbers.get(guessChar[i])-1);
	            }
	        }
	        return bulls+"A"+cows+"B";
	    }
	
	    public static void main(String[] args) {
	    	getHint("011", "110"); 
		}
}
