package com.leetcode.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.problemset.NQueensII;

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
public class NQueensIITest {

	@Test
	public void isOneQueenCorrect() {
		assertEquals(1,NQueensII.totalNQueens(1)); 
	}
	@Test
	public void isTwoQueenCorrect() {
		assertEquals(0,NQueensII.totalNQueens(2)); 
	}
	@Test
	public void isThreeQueenCorrect() {
		assertEquals(0,NQueensII.totalNQueens(3)); 
	}
	
	@Test
	public void isFourQueenCorrect() {
		assertEquals(2,NQueensII.totalNQueens(4)); 
	}

	@Test
	public void isFiveQueenCorrect() {
		assertEquals(10,NQueensII.totalNQueens(5)); 
	}

	@Test
	public void isSixQueenCorrect() {
		assertEquals(4,NQueensII.totalNQueens(6)); 
	}
	
	@Test
	public void isSevenQueenCorrect() {
		assertEquals(40,NQueensII.totalNQueens(7)); 
	}
	
	@Test
	public void isEightQueenCorrect() {
		assertEquals(92,NQueensII.totalNQueens(8)); 
	}
}
