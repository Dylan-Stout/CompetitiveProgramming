package com.crackingthecodinginterview.problemset.chapter7;

public class TrainingLinkedListNode {
	
	public TrainingLinkedListNode(int val) {
		this.val = val;
	}
	
	int val = Integer.MIN_VALUE; 
	TrainingLinkedListNode next = null; 
	TrainingLinkedListNode prev = null;
	
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
