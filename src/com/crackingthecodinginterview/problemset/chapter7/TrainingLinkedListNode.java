package com.crackingthecodinginterview.problemset.chapter7;

public class TrainingLinkedListNode {
	
	public TrainingLinkedListNode(int val) {
		this.val = val;
	}
	
	int val = Integer.MIN_VALUE; 
	TrainingLinkedListNode next = null; 
	TrainingLinkedListNode prev = null;
	
	/**
	 * Add a Integer to the beggining of the list
	 * 
	 * @param node
	 */
	public void add(int nodeVal)
	{
		add(nodeVal,0); 
	}
	
	/**
	 * Insert the Integer in the list at specified index 
	 * 
	 * @param nodeVal
	 * @param index
	 */
	public void add(int nodeVal, int index)
	{
		
	}
	
	/**
	 * Replaces the node at specified index with nodeVal
	 * the old value that was in-place is returned
	 * 
	 * @param nodeVal
	 * @param index
	 * @return
	 */
	public Integer set(int nodeVal, int index)
	{
		return null; 
	}
	
	/*
	 * Returns Integer value at specifide List index
	 * 
	 */
	public Integer get(int index)
	{
		return null; 
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public TrainingLinkedListNode getNext() {
		return next;
	}
	public void setNext(TrainingLinkedListNode next) {
		this.next = next;
	}
	public TrainingLinkedListNode getPrev() {
		return prev;
	}
	public void setPrev(TrainingLinkedListNode prev) {
		this.prev = prev;
	} 

}
