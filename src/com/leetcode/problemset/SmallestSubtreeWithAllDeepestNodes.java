package com.leetcode.problemset;

import java.util.Stack;

public class SmallestSubtreeWithAllDeepestNodes {
	 static Stack<TreeNode> maxTreeNode = new Stack<TreeNode>(); 
	    static int maxDepth = 0; 
	    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
	        traverse(0,root); 
	        return maxTreeNode.pop();  
	    }
	    
	    public static void traverse(int counter, TreeNode node)
	    {
	        counter++; 
	        if( maxDepth<counter){
	        	if(node.left!=null||node.right !=null)
	        		maxTreeNode.push(node); 
	            maxDepth = counter; 
	        }
	            
	        if(node.left!=null)
	        {
	           traverse(counter,node.left); 
	                
	        }
	        if(node.right!=null)
	        {
	           traverse(counter,node.right); 
	        }
	    }
	    
	    public static void main(String[] args)
	    {
	    	TreeNode root = new TreeNode(1); 
	    	root.left = new TreeNode(2); 
	    	root.right = new TreeNode(3); 
	    	root.left.left = new TreeNode(4); 
	    	root.left.left.left = new TreeNode(10); 
	    	root.left.right = new TreeNode(5); 
	    	root.right.left = new TreeNode(6); 
	    	root.right.right = new TreeNode(7); 
	    	System.out.println(subtreeWithAllDeepest(root).val);
	    }
}
