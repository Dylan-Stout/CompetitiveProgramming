package com.crackingthecodinginterview.test.chapter7;

public class TrainingMaxPriorityQueue {
	
	public int[] heap; 
	public int size; 
	
	public TrainingMaxPriorityQueue(int maxSize) {
		heap = new int[maxSize]; 
		size = 0; 
	}
	
	public void push(int value) {
		if(size==heap.length) throw new IllegalStateException("Heap is full"); 
		heap[size] = value; //insert the value into the heap
		bubbleUp(size); //bubble to value as far up heap as needed
		size++; 
	}
	
	public int pop() {
		if(size==0) throw new IllegalStateException("Heap is empty"); 
		int topValue = heap[0]; // buffer the root node value to return
		heap[0] = heap[size-1]; //take last element in the heap and place at top of heap
		heap[size-1] = 0; // this is optional step since we dont check the value, but lets zero it out for good measure
		bubbleDown(0); //bubble to top element down until it is in the right position in the heap
		size--; 
		return topValue; 
	}
	
	public void bubbleUp(int index){
		if(index<0) throw new IndexOutOfBoundsException("Negative indexes not allowed"); 
		int pos = index; 
		while(index>0) { // while we aren't the root node check if the parent is smaller then bubble up if it is
			int parent = getParent(index); 
			if(heap[parent]>=heap[index]) break; 
			else swapIndeces(parent, index);
			pos = parent; 
			index = getParent(index); 
		}
		
	}
	public void bubbleDown(int index) {
		while(index<=size)
		{
			int child = getBiggerChildIndex(index); 
			if(child>heap.length) break; 
			if(child>size) break;
			if(heap[index] > heap[child]) break; // if this element is bigger than it's children then stop
			swapIndeces(index, child);
			index=child; 
		}
		
	}
	
	public void swapIndeces(int first, int last)
	{ 
		int buffer = heap[last]; 
		heap[last] = heap[first]; 
		heap[first] = buffer; 
	}
	
	public int getParent(int index) {
		return (index - 1) /2; 
	}
	
	public int getBiggerChildIndex(int parent)
	{
		int leftChild = parent *2+1; 
		int rightChild = leftChild+1; 
		if(leftChild>size) return leftChild; // this is an empty spot lets place it there
		if(rightChild>size) return rightChild; //this is an empty spot lets place it there
		return leftChild > rightChild ? leftChild : rightChild; 
	}
	
	public void printQueueWithoutPop() {
		for(int i=0; i<size; i++)
		{
			System.out.print(heap[i]+"|");
		}
		System.out.println();
	}
	
	
	

	
	public static void main(String[] args) {
		TrainingMaxPriorityQueue pq = new TrainingMaxPriorityQueue(20); 
		pq.push(1);
		pq.printQueueWithoutPop();
		pq.push(20);
		pq.printQueueWithoutPop();
		pq.push(19);
		pq.printQueueWithoutPop();
		pq.push(55);
		pq.printQueueWithoutPop();
		pq.push(10); 
		pq.printQueueWithoutPop();
		pq.push(199);
		pq.printQueueWithoutPop();
		pq.push(290);
		pq.printQueueWithoutPop();
		pq.push(99999);
		pq.printQueueWithoutPop();
		pq.push(5565);
		pq.printQueueWithoutPop();
		pq.push(15670); 
		pq.printQueueWithoutPop();
		pq.push(145);
		pq.printQueueWithoutPop();
		pq.push(20234);
		pq.printQueueWithoutPop();
		pq.push(19243);
		pq.printQueueWithoutPop();
		pq.push(4455);
		pq.printQueueWithoutPop();
		pq.push(14564); 
		pq.printQueueWithoutPop();
		System.out.println(pq.pop());
		pq.printQueueWithoutPop();
		System.out.println(pq.pop());
		pq.printQueueWithoutPop();
		System.out.println(pq.pop());
		pq.printQueueWithoutPop();
		System.out.println(pq.pop());
		pq.printQueueWithoutPop();
	}
}
