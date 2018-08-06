package com.geeksforgeeks.problemset;

import com.crackingthecodinginterview.problemset.chapter4.BSTNode;

/**
 * Given preorder traversal of a binary search tree, construct the BST. Assume no duplicates in traversal.

	For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.
	10
   /   \
  5     40
 /  \      \
1    7      50
 * @author dystout
 *
 */
public class ConstructBSTPreorder {

/**
 * 
 * 
 * A log D complexity solution - where A is the length of the preorder traversal and D is the depth of the tree. 
 * 
 * 
 * 
 */
	/**
	 * Construct a binary search tree from a preorder traversal of size n
	 * @param preArr
	 * @param size
	 * @return
	 */
	public BSTNode constructTree(int[] preArr, int size) {
		if(preArr.length==0) return null; // trivial case where the pre-order traversal is, in fact, no traversal at all
		BSTNode root = new BSTNode(preArr[0]); 
		if(preArr.length==1) return root; //trivial case where pre-order traversal only contains the root node
		
		// at this point we know that the array is at least length 2
		// iterate through the remaining pre-order traversal array 
		// conditionally check if the entry is greater than the last value
		// if so, backtrack and determin where the node must be placed
		for(int i = 1; i<preArr.length; i++)  // O(A) 
		{
			insertNode(root, preArr[i]); //O(log D)
		}

		return root; // return the root of the BST 
	}

	/**
	 * Insert an integer into BST. Compare entry against node.data
	 * 
	 * Runtime - 
	 * 
	 * 
	 * @param node - the node for comparison agains entry
	 * @param entry
	 * @return
	 */
	private BSTNode insertNode(BSTNode node, int entry) {
		if(entry > node.getData()){
			if(node.getRight()==null)
				node.setRight(new BSTNode(entry));
			else
				node = insertNode(node.getRight(), entry); 
		}
			
		if(entry < node.getData()){
			if(node.getLeft()==null)
				node.setLeft(new BSTNode(entry));
			else
				node = insertNode(node.getLeft(), entry); 
		}			
		return node;
	}

}
