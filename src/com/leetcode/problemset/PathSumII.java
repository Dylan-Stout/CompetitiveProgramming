package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
	
	   public static List<List<Integer>> pathSum(TreeNode root, int sum) {
	        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
	        ArrayList<Integer> path = new ArrayList<Integer>(); 
	        
	        bstSumHelper(root, sum, 0, result, path); 
	        return result; 
	    }
	    
	    public static void bstSumHelper(TreeNode node, int targetSum, int sum, List<List<Integer>> result, List<Integer> path )
	    {

	        sum+=node.val; 
	        if(node.left==null && node.right==null && targetSum==sum)
	            result.add(path); 
	        if(sum > targetSum)
	            return; 
	        else{
	            if(node.left!=null)
	            {
	    	        path.add(node.val); 
	                bstSumHelper(node.left, targetSum, sum, result, path); 
	                path.remove(path.size()-1); 
	            }

	            if(node.right!=null){
	            	path.add(node.val); 
	                bstSumHelper(node.right, targetSum, sum, result, path); 
	                path.remove(path.size()-1); 
	            }
	        
	        }
	    }
	    
	    public static void printBSTInOrder(TreeNode root, int level)
	    {

	    	if(root.left!=null)
	    		printBSTInOrder(root.left, level+1); 
	    	System.out.println("VAL: "+ root.val + " LEVEL: " + level + " | ");
	    	if(root.right!=null)
	    		printBSTInOrder(root.right, level+1); 
	    }
	    
	    public static void printBSTBreadthFirst(TreeNode root)
	    {
	    	int level = 0; 
	    	LinkedList<TreeNodeLevel> nodeList = new LinkedList<TreeNodeLevel>(); 
	    	
	    	TreeNodeLevel tnl = new TreeNodeLevel(root, level);
	    	nodeList.addFirst(null);
	    	nodeList.addFirst(tnl);
	    	
	    	while(!nodeList.isEmpty())
	    	{
	    		TreeNodeLevel node = nodeList.removeLast(); 
	    		if(node==null)
	    		{	level++; continue; }
	    		System.out.println("level: " + node.level + "VAL: " + node.node.val);
	    		if(node.node.left!=null)
	    			nodeList.addFirst(new TreeNodeLevel(node.node.left, level));
	    		if(node.node.right!=null)
	    			nodeList.addFirst(new TreeNodeLevel(node.node.right, level));
	    	}
	    	
	    }
	    
	   static class TreeNodeLevel
	    {
	    	TreeNode node;
	    	int level; 
	    	public TreeNodeLevel(TreeNode node, int level)
	    	{ this.node = node; this.level = level; }
	    }

	    public static void main(String[] args)
	    {
	    	TreeNode root = new TreeNode(5); 
	    	TreeNode l10 = new TreeNode(4); 
	    	TreeNode l11 = new TreeNode(8); 
	    	TreeNode l20 = new TreeNode(11); 
	    	TreeNode l21 = new TreeNode(13); 
	    	TreeNode l22 = new TreeNode(4); 
	    	TreeNode l30 = new TreeNode(7); 
	    	TreeNode l31 = new TreeNode(2); 
	    	TreeNode l32 = new TreeNode(5); 
	    	TreeNode l33 = new TreeNode(1); 
	    	
	    	/**
	    	 *        5
     				 / \
				    4   8
				   /   / \
				  11  13  4
				 /  \    / \
				7    2  5   1
				SUM = 22
	    	 * Expected [5,4,11,2],[5,8,4,5]
	    	 */
	    	root.left=l10; 
	    	root.right=l11; 
	    	l10.left=l20; 
	    	l20.left=l30; 
	    	l11.left=l21; 
	    	l11.right =l22; 
	    	l20.right=l31; 
	    	l22.left=l32; 
	    	l22.right=l33; 
	    
	    	//printBSTInOrder(root, 1);
	    	printBSTBreadthFirst(root);
	    }
}
