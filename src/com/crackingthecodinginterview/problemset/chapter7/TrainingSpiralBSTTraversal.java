package com.crackingthecodinginterview.problemset.chapter7;

import java.util.LinkedList;

import com.crackingthecodinginterview.problemset.chapter4.TreeNode;

public class TrainingSpiralBSTTraversal {
	
	
	public void printBreadthFirstTraversal(TreeNode root)
	{
		LinkedList<TreeNode> nodeQ = new LinkedList<TreeNode>(); 
		nodeQ.add(root); 
		boolean isLeftToRight = true; 
		TreeNode curNode = root; 
		while(curNode!=null)
		{
			curNode = nodeQ.removeFirst(); 
			if(curNode!=null){
				System.out.println(curNode.val); 
				nodeQ.addLast(curNode.left); 
				nodeQ.addLast(curNode.right);
			}


		}
	}
	
	
	public void printSpiralTraversal(TreeNode root)
	{
		LinkedList<TreeNode> nodeQ = new LinkedList<TreeNode>(); 
		nodeQ.add(root); 
		boolean isLeftToRight = true; 
		TreeNode curNode = root; 
		while(curNode!=null)
		{
			curNode = nodeQ.removeFirst(); 
			if(curNode!=null){
				System.out.println(curNode.val); 
				nodeQ.addLast(curNode.left); 
				nodeQ.addLast(curNode.right);
			}


		}
	}
	
	public static void main(String[] args)
	{
		TrainingSpiralBSTTraversal test = new TrainingSpiralBSTTraversal(); 
		test.printBreadthFirstTraversal(test.buildBSTDepth3()); 
	}
	
	//breadth first would pring 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
	//spiral order would print  1,3,2,4,5,6,7,15,14,13,12,11,10,9,8
	public TreeNode buildBSTDepth3()
	{
		TreeNode root = new TreeNode(1); 
		TreeNode l10 = new TreeNode(2); 
		TreeNode l11 = new TreeNode(3); 
		TreeNode l20 = new TreeNode(4); 
		TreeNode l21 = new TreeNode(5); 
		TreeNode l22 = new TreeNode(6); 
		TreeNode l23 = new TreeNode(7); 
		TreeNode l30 = new TreeNode(8); 
		TreeNode l31 = new TreeNode(9); 
		TreeNode l32 = new TreeNode(10); 
		TreeNode l33 = new TreeNode(11); 
		TreeNode l34 = new TreeNode(12); 
		TreeNode l35 = new TreeNode(13); 
		TreeNode l36 = new TreeNode(14); 
		TreeNode l37 = new TreeNode(15); 
		root.left = l10; 
		root.right = l11; 
		l10.left = l20; 
		l10.right = l21; 
		l11.left = l22; 
		l11.right = l23; 
		l20.left = l30; 
		l20.right = l31; 
		l21.left = l32; 
		l21.right = l33; 
		l22.left = l34; 
		l22.right = l35; 
		l23.left = l36; 
		l23.right = l37; 
		return root; 
	}

}
