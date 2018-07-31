package com.leetcode.problemset;
/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 * @author dystout
 *
 */
public class TrappingRainWaterHARD {
	  
    public static int trap(int[] height) {
        int totalWaterUnits =0;
        int maxLeft = 0;
        int maxRight = 0; 
        int puddle = 0; 
        for(int i=0; i<height.length; i++)
        {
            if(i==0)
            {
                maxLeft = height[i];
                continue; 
            }
            if(i==height.length)
                continue; 
            if(maxLeft<=height[i])
            {
                maxLeft = height[i];
                totalWaterUnits+=puddle; 
                puddle = 0; 
            }else{
                puddle+=(maxLeft-height[i]);
            }

        }
        return totalWaterUnits; 
    }
    
    public static void main(String[] args) {
		int[] argArray = {0,1,0,2,1,0,1,3,2,1,2,1}; 
		System.out.println(trap(argArray));
	}
}
