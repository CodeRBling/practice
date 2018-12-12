package com.hackerrank;

import java.util.Arrays;

/**
 * Problem statement: Given an array of integers, find the subset of non-adjacent elements with the maximum sum.
 * Calculate the sum of that subset.
 * @author Mechy
 *
 */
public class MaxArraySum {
	static int[] store;
	static int count = 0;
	/**
	 * calculate max sum of non-adjacent values 
	 * @param arr
	 * @return
	 */
	static int maxSubsetSum(int[] arr) {
		for(int k=arr.length-1;k>=0;k--){
			int max = store[k];
			if(k+2 < arr.length){
				int res = arr[k] + store[k+2];
				max = Math.max(max,res);
			}
			if(k+3 < arr.length){
				int res = arr[k] + store[k + 3];
				max = Math.max(max, res);
	        }
			store[k] = max;
		}
		return Math.max(store[0], store[1]);
    }
	
	
	public static void main(String[] args) {
		int[] arr = {3,7,4,6,5}; //13
		//int[] arr = {2,1,5,8,4}; //11
		//int[] arr = {3,5,-7,8,10}; //15
		store = arr.clone();
		System.out.println(maxSubsetSum(arr));
		System.out.println("call count :"+count);
	}

}
