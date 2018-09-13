package com.crackingthecodinginterview.problemset.chapter7;

import java.util.EmptyStackException;

public class TrainingStack<T>{
	private class StackNode<T>{
		private T data; 
		private StackNode<T> next; 
		
		public StackNode(T data) {
			this.data = data; 
		}
	}
	
	private StackNode<T> top; 
	
	public T pop() {
		if(top==null) throw new EmptyStackException(); 
		T item = top.data; 
		top = top.next; 
		return item; 
	}
	
	public void push(T value) {
		StackNode<T> lastTop = top; 
		top = new StackNode<T>(value); 
		top.next = lastTop; 
	}
	
	public T peek() {
		if(top==null) throw new EmptyStackException(); 
		return top.data; 
	}
	
	public boolean isEmpty() {
		return top==null; 
	}
}
