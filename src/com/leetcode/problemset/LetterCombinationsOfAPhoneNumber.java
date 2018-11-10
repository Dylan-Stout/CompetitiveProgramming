package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	
	HashMap<Integer, Character[]> dialPadMap = new HashMap<Integer, Character[]>(); 
	
	
	public LetterCombinationsOfAPhoneNumber()
	{
		dialPadMap.put(2, new Character[]{'a','b','c'}); 
		dialPadMap.put(3, new Character[]{'d','e','f'}); 
		dialPadMap.put(4, new Character[]{'g','h','i'}); 
		dialPadMap.put(5, new Character[]{'j','k','l'}); 
		dialPadMap.put(6, new Character[]{'m','n','o'}); 
		dialPadMap.put(7, new Character[]{'p','q','r','s'}); 
		dialPadMap.put(8, new Character[]{'t','u','v'}); 
		dialPadMap.put(9, new Character[]{'w','x','y','z'}); 
	}

	
	public List<String> letterCombinations(String digits)
	{
		ArrayList<String> result = new ArrayList<String>(); 
		letterCombosHelper(digits.toCharArray(), result, 0, new StringBuilder()); 
		return result; 
	}
	
	public void letterCombosHelper(char[] digits, ArrayList<String> result, int index, StringBuilder path)
	{
		if(index==digits.length)
		{
			result.add(path.toString()); 
			return; 
		}
		Character[] buttonLetters = dialPadMap.get(digits[index] - '0'); 
		for(char letter : buttonLetters){
			path.append(letter); 
			letterCombosHelper(digits,result,index+1, path); 
			path.setLength(path.length()-1);
		}
		
	}

	
	public static void main(String[] args)
	{
		LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber(); 
		System.out.println(l.letterCombinations("23").toString());  //expected 'ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce' , 'cf' 
		System.out.println(l.letterCombinations("234435").toString());
	}
}
