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

	/**
	 * Total possible solutions for arrangements of queens on the board
	 */
    public static int TOTAL_SOLUTIONS = 0; 

    // the state of the board
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
	public static int totalNQueens(int n) 
	{
		if(n==1) return 1; 
		
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
	
	/**
	 * Recursive function to search for possible row combinations of queens on the board. 
	 * 
	 * 
	 * 
	 * @param row
	 * @param col
	 * @param board
	 * @return
	 */
	public static boolean backtrackQueen(int row, int col, boolean[][] board)
	{
		
		for(int position = 0; position<board[0].length; position++) // iterate through the columns in a row
		{
			
			if(isQueenSafe(row,position,board)){ //is the queen safe from attack at this position?
				board[row][position] = true; // mark the position of the queen on the board
			
				if(row == board[0].length-1) // at the last row? 
				{
					TOTAL_SOLUTIONS++; // this is a viable solution board, add to the count
					return true; //all queens have been placed on the board, return to last recursive branch
				}else{
					backtrackQueen(row+1,col,board); 
				}
			}else{
				if(position == board[0].length-1){
					return false; //if we've reached last column in row and the queen can't be placed here
				}
			}
		}
		return false; //we exhausted all options to place the queen in this row 
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
	private static boolean isQueenSafe(int row, int col, boolean[][] board) 
	{
		if(isColumnAttacked(col,row,board)) return false; // is this column under attack?
		return !isDiagonallyAttacked(row,col,board);
	}
	
	
	
	

/**
 *  Is the current column spot for the potential queen position under attack from another queen?
 *  Easy to check by checking up the column for other queens. We do not need to check down since 
 *  we will not have placed any queens there. 
 *  
 * @param col - proposed column for queen positioning
 * @param row - proposed row for queen positioning
 * @param board - the current game board 
 * @return true|false - if the column in question is under attack from another queen. 
 */
	private static boolean isColumnAttacked(int col, int row, boolean [][] board) 
	{
		for(int rowPos = row; rowPos>=0; rowPos--)
		{
			if(board[rowPos][col]) return true; 
		}
		return false;
	}
	
	

	/**
	 * Check the upward diagonals of the matrix for queens that have already been placed, 
	 * it will determine if the diagonals are safe. 
	 * 
	 * @param row - row spot of potential queen being placed
	 * @param col - col spot of potential queen being placed
	 * @param board - already placed queen positions
	 * @return is the potential queen's spot being attacked? 
	 */
	private static boolean isDiagonallyAttacked(int row, int col, boolean[][] board)
	{
		//check up/right (starting at the position up and to the right of the query position
		if(row-1>=0 && col+1<=board[col].length-1)
		{
			for(int r=row-1, c=col+1; (c>=0 && r>=0) && (c<=board[col].length-1 && r<=board[row].length-1); c++, r--)
			{
				if(board[r][c]) return true; 
			}
		}
		
		//check up/left TODO -- something is wrong here with the if condition
		if(row-1>=0&& col-1>=board[col].length-1)
		{
			for(int r=row-1, c=col-1; (c>=0 && r>=0) && (c<=board[col].length-1 && r<=board[row].length-1); c--, r--)
			{
				if(board[r][c]) return true; 
			}
		}
		
		// we didnt find any queens in the upwards diagonal check, so return safe
		return false; 
	}
	

}
