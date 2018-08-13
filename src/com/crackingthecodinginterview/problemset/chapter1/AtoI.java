package com.crackingthecodinginterview.problemset.chapter1;

public class AtoI {

	/**
	 * Given an ASCII String convert it to an integer. 
	 * 
	 * @param string
	 * @return
	 */
	public static int stringToInteger(String string)
	{
		
		int total =0; 
		boolean isNegative = false; 
		for(int i =0; i<string.length(); i++)
		{ 
			if(i==0 && string.charAt(0)=='-')
			{
				isNegative = true; 
				continue; 
			}
			total=total*10; 
			total+= string.charAt(i)-'0'; 
		}
		total = isNegative ? total*-1 : total; 
		return total; 
	}
	
	public static void main(String[] args) {
		System.out.println(stringToInteger("-10203493")); 
	}
}
