package com.universityofutah.problemset;

import java.util.Random;

public class ArraySum {
	
	/**
	 * Generates randomized nxn 2d array
	 * @param n
	 * @return
	 */
	public static int[][] generateRandom2dArray(int n)
	{
		Random rand = new Random(); 
		int[][] A = new int[n][n]; 
		for(int row=0; row<n; row++)
		{
			for(int col=0; col<n; col++)
			{
				A[row][col] = rand.nextInt(); 
			}
		}
		return A; 
	}
	
	public static void sumRows(int[][] A)
	{
		for(int row = 0; row<A.length; row++)
		{
			int rowTotal = 0; 
			for(int col = 0; col<A.length; col++)
			{
				rowTotal+=A[row][col]; 
			}
			//System.out.println("Row Total: " + rowTotal);
		}
	}
	
	public static void sumCols(int[][] A)
	{
		for(int col=0; col<A[0].length; col++)
		{
			int colTotal = 0; 
			for(int row=0; row<A.length; row++)
			{
				colTotal+=A[row][col]; 
			}
			//System.out.println("Column Total: " + colTotal);
		}
	}

	
	public static void main(String[] args) {
		 int[][] testArr = generateRandom2dArray(10000); 
		
		 long startTimeRows = System.currentTimeMillis();
		 sumRows(testArr); 
		 long elapsedTimeRowsMillis = System.currentTimeMillis() - startTimeRows;
		 System.out.println("Time elapsed for adding rows: " + elapsedTimeRowsMillis);
		 
		 long startTimeCols = System.currentTimeMillis();
		 sumCols(testArr); 
		 long elapsedTimeColsMillis = System.currentTimeMillis() - startTimeCols;
		 System.out.println("Time elapsed for adding columns: " + elapsedTimeColsMillis);

	}
}
