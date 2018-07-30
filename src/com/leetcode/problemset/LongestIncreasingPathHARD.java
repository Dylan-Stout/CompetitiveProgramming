package com.leetcode.problemset;

import java.util.Stack;

public class LongestIncreasingPathHARD {

	static Stack<Integer> maximumPathLengths = new Stack<Integer>(); 
	
	public static int longestIncreasingPath(int[][] matrix)
	{
		maximumPathLengths.push(Integer.MIN_VALUE); // no null pointers thanks
		for(int row = 0; row<matrix.length; row++) // iterate through the rows 
		{
			for(int column = 0; column<matrix[row].length; column++)// iterate through the columns 
			{
				int localMaxPath = searchDepthFirstIncreasing(row, column, matrix, 1); 
				if(maximumPathLengths.peek()<localMaxPath)
					maximumPathLengths.push(localMaxPath); 
			}
		}
		return maximumPathLengths.pop(); 
	}
	
	public static int searchDepthFirstIncreasing(int row, int col, int[][]matrix, int pathCounter)
	{
		//bounds checking 
		if (row<0 || col < 0 || row==matrix.length || col ==matrix[0].length )
			return 0; 
		int leftPath = pathCounter; 
		int rightPath = pathCounter; 
		int upPath = pathCounter; 
		int downPath = pathCounter; 
		boolean isLeftBoundary = col-1<0; 
		boolean isRightBoundary = col+1>=matrix[0].length; 
		boolean isUpBoundary = row-1<0; 
		boolean isDownBoundary = row+1>=matrix.length; 
		
		//check right
		if(!isRightBoundary && matrix[row][col]<matrix[row][col+1])
			rightPath+=searchDepthFirstIncreasing(row,col+1,matrix,pathCounter+1);
		//check left
		if(!isLeftBoundary && matrix[row][col]<matrix[row][col-1])
			leftPath+=searchDepthFirstIncreasing(row,col-1,matrix,pathCounter+1);
		//check up 
		if(!isUpBoundary && matrix[row][col]<matrix[row-1][col])
			upPath+=searchDepthFirstIncreasing(row-1,col,matrix,pathCounter+1);
		//check down 
		if(!isDownBoundary && matrix[row][col]<matrix[row+1][col])
			downPath+=searchDepthFirstIncreasing(row+1,col,matrix,pathCounter+1);
		return Math.max(leftPath, Math.max(rightPath, Math.max(upPath, downPath))); 
	}
	

	
	public static void main(String[] args){
		int[][] testArray = {{9,9,4},{6,6,8},{2,1,1}}; 
		System.out.println(longestIncreasingPath(testArray));
	}
}
