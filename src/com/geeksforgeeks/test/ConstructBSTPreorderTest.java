package com.geeksforgeeks.test;

import org.junit.Test;

import com.crackingthecodinginterview.problemset.chapter4.BSTNode;
import com.geeksforgeeks.problemset.ConstructBSTPreorder;

/**
 * Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50

 * @author dystout
 *
 */
public class ConstructBSTPreorderTest {
	
	@Test
	public void trivialCaseTest(){
		
	}
	
	@Test
	public void onlineExampleTest(){
		ConstructBSTPreorder tree = new ConstructBSTPreorder();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        BSTNode expectedRoot = new BSTNode(10); 
        BSTNode expectedLeftSubtree = new BSTNode(5); 
        expectedLeftSubtree.setLeft(new BSTNode(1));
        expectedLeftSubtree.setRight(new BSTNode(7));
        BSTNode expectedRightSubtree = new BSTNode(40); 
        expectedRightSubtree.setRight(new BSTNode(50));
        expectedRoot.setLeft(expectedLeftSubtree);
        expectedRoot.setRight(expectedRightSubtree);
        BSTNode actualRoot = tree.constructTree(pre, size);
        expectedRoot.printInorderTraversal();
        actualRoot.printInorderTraversal();
       
	}

}
