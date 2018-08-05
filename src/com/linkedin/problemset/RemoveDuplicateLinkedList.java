package com.linkedin.problemset;

import java.util.HashMap;
import java.util.LinkedList;

public class RemoveDuplicateLinkedList {

	public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {
		if(list.isEmpty() || list.size()==1) return list; 
		HashMap<Integer,Integer> valIndexMap = new HashMap<Integer, Integer>(); 
		for(int i =0; i<list.size()-1; i++)
		{
			if(valIndexMap.containsKey(list.get(i)))
			{
				list.remove(i); 
				i=i-1; 
			}else{
				valIndexMap.put(list.get(i), i); 
			}
			
		}
		return list;
	}

}
