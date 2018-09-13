package com.youtube.csdojo;
/**
 * Given an array of positive integers that represent building/tower heights;
 * you are an individual standing on the building at index 0 while a height of
 * towers[i]. Also given that your ability to jump from tower to tower is limited 
 * by the height of the tower that you are standing on; see if it is possible to clear the 
 * "building obstacle course" or the bounds of the given array. 
 * 
 * Example - [1,4,0,0,0,1] -> True
 * Example - [4,2,0,0,2] -> True
 * Example - [0,1] -> False
 * Example - [1,0] -> False 
 * Example - [2,1,0]-> False
 * Exammple - [2,1,2,0,1,1,2,0,2,0,2] -> True
 * 
 * 
 * @author dylan
 *
 */
public class TowerHopper {
	
	public boolean isHoppable(int[] towers)
	{
		return jumpBuildings(towers,0)>towers.length; //did all our jump attempts make it outside of the array? 
	}
	
	
	public int jumpBuildings(int[] towers, int position)
	{
		if(towers[position]==0) return position; 
		int updatedPosition = position; 
		
		
		return position; 
	}

	public int nextStep(int[] towers, int start, int end)
	{
		int max = -1; 
		//TODO impl
		return 0; 
	}
}
