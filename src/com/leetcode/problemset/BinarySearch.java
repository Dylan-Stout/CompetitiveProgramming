package com.leetcode.problemset;

public class BinarySearch {
	
	public static int search(int[] arr, int key)
	{
		return binarySearch(0, arr.length, arr, key); 
	}
	
	public static int binarySearch(int left, int right, int[] arr, int key)
	{
		if(left>right) 
			return -1; 
		if(right==left) 
			return (arr[left]==key) ? left : -1; 
		
		int mid = (left + right) / 2 ; 
		if(key==arr[mid]) 
			return mid; 
		if(key<arr[mid])
			return binarySearch(left, mid-1, arr, key); 
		else
			return binarySearch(mid+1, right, arr, key); 
		
	}
	
	public static void main(String[] args) {
		int[] sortedArr = new int[]{1,4,5,7,8,9,13,14,16,21,22}; 
		System.out.println(search(sortedArr, 14)); //7
		int[] sortedArr2 = new int[]{11,41,533,733,892,911,1322,1432,1633,2111,2222}; 
		System.out.println(search(sortedArr2, 533)); //2
		int[] sortedArr3 = new int[]{-112,-111,-41,0,533,733,892,911,1322,1432,1633,2111,2222};
		System.out.println(search(sortedArr3, -112)); // 0
		System.out.println(search(sortedArr3, 0)); //3
		int[] sortedArr5 = new int[]{-1211,-41,533,733,892,911,132332,1432333,1633333,2111111,2222111}; 
		System.out.println(search(sortedArr5, 2222111)); //10 
	}

}
