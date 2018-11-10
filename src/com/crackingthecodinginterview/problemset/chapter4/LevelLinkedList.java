package com.crackingthecodinginterview.problemset.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a BST (from TreeNode(s)) return level order linked lists
public class LevelLinkedList {
	
	public static List<List<Integer>> getLevelLinkedLists(TreeNode root)
	{
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
		getLevelLinkedListHelper(root, 0, result); 
		return result; 
	}
	
	public static void getLevelLinkedListHelper(TreeNode node, int level, ArrayList<List<Integer>> result)
	{
		if(node==null) // base case
			return; 
		
		if(level<result.size() && result.get(level)!=null)
			result.get(level).add(node.val); 
		else{
			LinkedList<Integer> levelList = new LinkedList<Integer>(); 
			levelList.add(node.val); 
			result.add(level, levelList); 
		}
		getLevelLinkedListHelper(node.left,level+1, result); 
		getLevelLinkedListHelper(node.right,level+1, result); 
			
	}

	/**
	 * Expected tree 
	 * 
	 * 				6
	 * 			5		8
	 * 		 7    8  9    10
	 *   21    20  30 60     80
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6); 
		TreeNode l20Node = new TreeNode(5); 
		TreeNode l21Node = new TreeNode(8); 
		TreeNode l30Node = new TreeNode(7); 
		TreeNode l31Node = new TreeNode(8); 
		TreeNode l32Node = new TreeNode(9); 
		TreeNode l33Node = new TreeNode(10); 
		TreeNode l40Node = new TreeNode(21); 
		TreeNode l41Node = new TreeNode(20); 
		TreeNode l42Node = new TreeNode(30); 
		TreeNode l43Node = new TreeNode(60); 
		TreeNode l44Node = new TreeNode(80); 
		root.left = l20Node; 
		root.right = l21Node; 
		l20Node.left = l30Node; 
		l20Node.right = l31Node; 
		l21Node.left = l32Node; 
		l21Node.right = l33Node; 
		l30Node.left = l40Node; 
		l31Node.left = l41Node; 
		l32Node.left = l42Node; 
		l32Node.right = l43Node; 
		l33Node.right = l44Node; 
		System.out.println("Input Tree: \n 	 * 				6\n"+
	 " 			5		8\n"+
	 " 		 7    8  9    10\n"+
	 "   21    20  30 60     80\n\n"+
	 "Expected: {{6},{5,8},{7,8,9,10},{21,20,30,60,80}}\n"+
	 "Actual: " + getLevelLinkedLists(root).toString());
	}
}
