package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
	    HashMap<String, List<String>> keysToAnaMap = new HashMap<String, List<String>>();
	    for(String str : strs){
	        String key = getAnagramKey(str); // sorts the strings so that we can tell if they exist in our words hashmap
	        if(keysToAnaMap.containsKey(key)){ // if this is an anagram of another word, add it to the subset of anagrams it belogs to from the original string
	            keysToAnaMap.get(key).add(str);
	        } else {							//if this isn't an anagram we have seen before add a new subset of anagrams
	            List<String> l = new ArrayList<String>();
	            l.add(str); 					// add the original string (not key) into the new subset of anagrams
	            keysToAnaMap.put(key, l);      // put this new anagram key and subset into the hashmap
	        }
	    }
	    List<List<String>> results = new ArrayList<List<String>>();
	    for(String anagram : keysToAnaMap.keySet()){
	        List<String> r = keysToAnaMap.get(anagram);
	        Collections.sort(r);
	        results.add(r);
	    }
	    return results;
	}

	public static String getAnagramKey(String str){ // sort the strings as arrays and return
	    char[] c = str.toCharArray();
	    Arrays.sort(c);
	    return String.valueOf(c);
	}
	
	static HashMap<String, List<String> > anagramKeyToSubset; 

    public static List<List<String>> getAnagramLists(String[] input) 
    {
        anagramKeyToSubset = new HashMap<String, List<String>>(); 
        for(String s : input)
        {
           String key = getKey(s); 
           if(anagramKeyToSubset.containsKey(key)){
               anagramKeyToSubset.get(key).add(s); 
           }
           else{
            ArrayList<String> a = new ArrayList<String>(); 
            a.add(s); 
            anagramKeyToSubset.put(key, a) ; 
           }
        }
        List<List<String>> result = new ArrayList<List<String>>(); 
        for(Entry<String, List<String>> entry : anagramKeyToSubset.entrySet())
        {
            result.add(entry.getValue()); 
        }
        return result; 
        
    }


    public static String getKey(String word)
    {
        char[] letters = word.toCharArray(); 
        Arrays.sort(letters); 
        return new String(letters); 
    }

	
	public static void main(String[] args) {
		System.out.println(getAnagramLists(new String[] {"ear","lear","pear","rea","rae", "dyl","rap","era"})); 
	}

}
