package com.leetcode.problemset;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/n-queens-ii/description/
 * 
 * 52. N-Queens II
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * 
 * Example:
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
	[
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]
 *
 * @author dylan
 *
 */
public class NQueensII {

    public static int TOTAL_SOLUTIONS = 0; 
    public static HashSet<Integer> attackedColumns = new HashSet<Integer>(); 
    public static HashSet<Integer> attackedRows = new HashSet<Integer>(); 
	public static boolean[][] board = null; 
    
    /**
     * First call made in recursive backtracking algorithm. Sets up an NxN 2D boolean 
     * array for keeping track of queen positions. Makes call to recursive backtrack algorithm
     * to find queen combinations through brute force permutations. 
     * 
     * The first queen's position is important since it is the root point of our recursive tree. 
     * 
     * @param n
     * @return
     */
	public static int totalNQueens(int n) {
		
		// instantiate the board with no queens present
		board = new boolean[n][n]; 
		
		// iterate through placing the first queen in different spots in the first row
		for(int firstQueenPos = 0; firstQueenPos<n; firstQueenPos++)
		{
			board[0][firstQueenPos] = true; // mark the location of the first queen
			backtrackQueen(1,firstQueenPos,board); 
			board[0][firstQueenPos] = false; //unmark the location for next iteration
		}
		
		// Solutions will be accumulated by the recursive function adding to the total
		return TOTAL_SOLUTIONS;
	}
	
	public static boolean backtrackQueen(int row, int col, boolean[][] board)
	{
		
		for(int column = 0; column<board[row].length; column++)
		{
			
			if(isQueenSafe(row,col,board)){
				if(column == board[row].length-1){
					
					return false; //if we've reached last column in row return false
				}
			}
		}
	    board[row][col] = true; // set the queen 
		return false; 
	}

	/**
	 * Determine if a Queen placed at a given row, column is under attack. 
	 * Pass in the board that has the queen positions. 
	 * 
	 * @param row - row of the queen position
	 * @param col - column of the queen position
	 * @param board  - current state of the board
	 * @return - true | the queen is safe -- false | the queen is under attack
	 */
	private static boolean isQueenSafe(int row, int col, boolean[][] board) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
