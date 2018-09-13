package com.crackingthecodinginterview.problemset.chapter2;

import java.util.LinkedList;

/**
 * Write code to remove duplicates from an unsorted linked list
 * 
 * @author dylan
 *
 */
public class RemoveDups {

	
	public static void main(String[] args) {
		TrainingSinglyLinkedList<Integer> list = new TrainingSinglyLinkedList<Integer>(1); 
		list.add(2);
		list.add(4);
		list.add(9991);
		list.add(9991);
		list.add(5);
		list.add(5);
		list.add(6);
		list.add(6);
		list.add(6);
		list.printList();
		System.out.println();
		list.removeDuplicates(); // remove duplicates		
		list.printList();
		System.out.println();
		list.removeWithValue(1); //remove with specified value
		list.printList();
	}

}
