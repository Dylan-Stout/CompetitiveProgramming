package com.leetcode.problemset;

import java.util.Map;
import java.util.TreeMap;

/**
 * 846. Hand of Straights
 * 
 * https://leetcode.com/problems/hand-of-straights/description/
 * 
 * 
 * Alice has a hand of cards, given as an array of integers.
	
	Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
	
	Return true if and only if she can.
	
	 
	
	Example 1:
	
	Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
				  [1,2,2,3,3,4,6,7,8]
	Output: true
	Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
	Example 2:
	
	Input: hand = [1,2,3,4,5], W = 4
	Output: false
	Explanation: Alice's hand can't be rearranged into groups of 4.
	 
	
	Note:
	
	1 <= hand.length <= 10000
	0 <= hand[i] <= 10^9
	1 <= W <= hand.length
 * 
 * @author dystout
 *
 */
public class HandOfStraights {
	
	/*public boolean isNStraightHand(int[] hand, int W)
	{
		//trivial cases
		if(hand.length<W | hand.length % W > 0) return false; // we dont have enough cards to make this combination TODO maybe make this recursive
		Arrays.sort(hand);
		for(int i = 0; i<hand.length; i++)
		{
			
		}
		
		
		return false; 
	}*/
	
	
	 public static boolean isNStraightHand(int[] hand, int W) {
	        Map<Integer, Integer> cardFreq = new TreeMap<>();
	        for (int card : hand)
	        {
	        	if(!cardFreq.containsKey(card))
	        		cardFreq.put(card,1); 
	        	if(cardFreq.containsKey(card))
	        		cardFreq.put(card, cardFreq.get(card)+1); 
	        	
	        }
	        for (int freq : cardFreq.keySet()){
	            if (cardFreq.get(freq) > 0)
	                for (int i = W - 1; i >= 0; --i) {
	                	if(!cardFreq.containsKey(i)){
	                		 if (cardFreq.get(freq + i) < cardFreq.get(freq)) return false;
	                	}
	                    cardFreq.put(freq + i, cardFreq.get(freq + i) - cardFreq.get(freq));
	                }
	        }
	        return true;
	    }
	 
	 public static void main(String[] args) {
		int[] testHand = new int[]{1,1,2,2,3,3,4,4,5,5,6,6}; 
		int w = 7; 
		System.out.println(isNStraightHand(testHand, w)); 
	}

}
