package com.crackingthecodinginterview.problemset.chapter1;

import java.util.HashSet;

public class AtoI {
	
	public String getHint(String secret, String guess) {
        HashSet<Character> knownNumbers = new HashSet<Character>(); 
        int bulls=0; 
        int cows=0; 
        char[] secretChar = secret.toCharArray(); 
        char[] guessChar = guess.toCharArray(); 
        for(int i=0; i<secretChar.length; i++)
        {
            knownNumbers.add(secretChar[i]) ; 
        }
        for(int i=0; i<secret.length(); i++)
        {
            if(knownNumbers.contains(guessChar[i])){
                if(guessChar[i]==secretChar[i])
                    bulls++; 
                else
                    cows++; 
            }
        }
        return bulls+"A "+cows+ "B";
    }

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
