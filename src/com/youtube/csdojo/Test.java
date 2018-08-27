package com.youtube.csdojo;

import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> x-y); 
		pq.offer(10); 
		pq.add(11); 
		pq.add(10); 
		pq.add(9); 
		pq.add(8); 
		pq.add(7); 
		pq.add(9); 
		pq.add(9); 
		pq.add(99); 
		pq.add(999); 
		pq.add(9999); 
		pq.poll(); 
		pq.poll();
		pq.poll(); 
		pq.poll();
		pq.poll();
		pq.poll(); 
		
		Integer o = 1; 
	    Integer x = 2; 
		int compare = o.compareTo(x);  
		
		
	}
	
}
