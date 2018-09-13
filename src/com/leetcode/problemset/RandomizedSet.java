package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1); 
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * 
 * Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

	// Init an empty set.
	RandomizedSet randomSet = new RandomizedSet();
	
	// Inserts 1 to the set. Returns true as 1 was inserted successfully.
	randomSet.insert(1);
	
	// Returns false as 2 does not exist in the set.
	randomSet.remove(2);
	
	// Inserts 2 to the set, returns true. Set now contains [1,2].
	randomSet.insert(2);
	
	// getRandom should return either 1 or 2 randomly.
	randomSet.getRandom();
	
	// Removes 1 from the set, returns true. Set now contains [2].
	randomSet.remove(1);
	
	// 2 was already in the set, so return false.
	randomSet.insert(2);
	
	// Since 2 is the only number in the set, getRandom always return 2.
	randomSet.getRandom();
 * 
 * 
 * @author dylan
 * 
 *  Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 * 
 * Think of a hashset implementation and what that means. In this case it means hashing the 
 * integer and getting an index in a resizable array. Then using that index to insert/remove 
 * in O(1) time 
 *
 */
public class RandomizedSet {
	
	ArrayList<Integer> randomSet; // set holding unique values 
	HashMap<Integer,Integer> hashedLocations; // hash to index lookup O(1)
	Random rand; 
    /** Initialize your data structure here. */
    public RandomizedSet() {
    	randomSet = new ArrayList<Integer>(); 
    	hashedLocations = new HashMap<Integer, Integer>(); 
    	rand = new Random(); 
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(hashedLocations.containsKey(val))
    		return false; 
    	hashedLocations.put(val, randomSet.size()); 
    	randomSet.add(val);
    	return true; 
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hashedLocations.containsKey(val)) {
        	randomSet.remove(hashedLocations.get(val)); 
        	hashedLocations.remove(val); 
        	return true; 
        }
        else {
        	return false; 
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	
    	return randomSet.get(rand.nextInt(randomSet.size())); 
        
    }
    
    public static void main(String[] args) {
		RandomizedSet randSet = new RandomizedSet(); 
		System.out.println(randSet.insert(1)); 
		System.out.println(randSet.remove(2)); 
		System.out.println(randSet.insert(2)); 
		System.out.println(randSet.getRandom()); 
		System.out.println(randSet.remove(1)); 
		System.out.println(randSet.insert(2)); 
		System.out.println(randSet.getRandom()); 
	}

}
