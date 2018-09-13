package com.linkedin.problemset;
/**
 * Problem found on linkedIn forum. 
 * 
 * @author dylan
 *
 */
public class RegularExpressions {

	/**
	 * Given a String s find the number of occurences of the target string
	 * 
	 * BRUTE FORCE Windowing
	 * O(o/t) where 0 is original length and t is target length
	 */
	public static int numberOcurrances(String original, String target)
	{
		int totalOccurances = 0; 

		for(int i=0; i<original.length()-target.length()+1; i++)
		{
			int beginWindow = i; 
			int endWindow = i + target.length(); 
			if(original.substring(beginWindow, endWindow).equals(target))
				totalOccurances++; 
	
		}
		return totalOccurances;  
	}
	
	public static int numberOcurrancesRegex(String original, String target)
	{

		return (original.length() -original.replaceAll(target, "").length())/target.length(); 
		
	}
	
	

	public static void main(String[] args) {
		//System.out.println(numberOcurrances("katarinaiskatarinawhoisbeautifulandiloveherkatarina", "katarina" ));
		System.out.println(numberOcurrancesRegex("katarinaiskatarinawhoisbeautifulandiloveherkatarina", "katarina" ));
		
	}
}
