package com.crackingthecodinginterview.problemset.chapter4;

/**
 * 
 * @author dystout
 *
 */
public class BSTNode {
	
	BSTNode left, right; 
	int data; 
	public BSTNode(int data)
	{
		this.data=data; 
	}
	
	/**
	 * Insert a value as node into the BST, this will 
	 * look at the node value to determine which path to take 
	 * when inserting
	 * 
	 * @param value
	 */
	public void insert(int value)
	{
		if(value<=data) // 
		{
			if(left==null){
				left = new BSTNode(value); 
			}else{
				left.insert(value);
			}
		}else{
			if(right==null){
				right= new BSTNode(value); 
			}else{
				right.insert(value);
			}
		}
	}
	
	/**
	 * User inorder traversal of tree to see if the given value 
	 * exists in the tree. 
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(int value)
	{
		if(value==data){
			return true; 
		}else if (value< data)
		{
			if(left==null){
				return false; 
			}else{
				return left.contains(value); 
			}
		}else{
			if(right==null){
				return false; 
			}else{
				return right.contains(value); 
			}
		}
	}
	/**
	 * Print left subtree, root node, right subtree 
	 * (Prints nodes in-order from smallest to largest)
	 */
	public void printInorderTraversal(){
		if(left!=null){
			left.printInorderTraversal(); 
		}
		System.out.println(data);
		if(right!=null){
			right.printInorderTraversal();
		}
	}
	/**
	 * Print root node, and then left subtree, then right subtree
	 */
	public void printPreorderTraversal(){
		System.out.println(data); // there would need to be a conditional check here to determine if this is the root node
		if(left!=null){
			left.printInorderTraversal(); 
		}
		System.out.println(data);
		if(right!=null){
			right.printInorderTraversal();
		}
	}
	
	/**
	 * Print left subtree, right subtree, then root node
	 */
	public void printPostorderTraversal(){
		
	}
	

}
