package com.leetcode.problemset;

/**
 * 693. Binary Number with Alternating Bits
 * @author dylan
 *
 */
public class BinaryNumberAlternateBits {
	
	public boolean hasAlternatingBits(int n) {
        Integer bit = null;
        int index = 0;
        int m = n;
        
        //Finding the index of the last 1 from right to left
        for(int i = 0; i < 32; i++){
            if((m & 1) == 1){
                index = i;
            }
            m = m >>> 1;
        }
        
        //Looping till index found in above loop to check alternate bits
        for(int i = 0; i <= index; i++){
            if(bit != null && bit == (n & 1)) {
                return false;
            }
            bit = n & 1;
            n = n >>> 1;
        }
        
        return true;
    }

}
