package com.leetcode.problemset;

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
