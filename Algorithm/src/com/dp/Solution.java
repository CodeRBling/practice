package com.dp;

import java.util.Arrays;

public class Solution {
	 // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] assign = new int[n];
        Arrays.fill(assign, 1);
        //L -> R
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] < arr[i+1] && assign[i+1] <= assign[i]){
                assign[i+1] = assign[i]+1;
            }
        }
        //R -> L
        for(int i = arr.length-1;i>=1;i--){
            if(arr[i] < arr[i-1] && assign[i] >= assign[i-1]){
                assign[i-1] = assign[i]+1;
            }
        }
        //sum all candies 
        long sum = 0;
        for(int i=0;i<assign.length;i++){
            sum+=assign[i];
        }
        return sum;
    }

    public static void main(String[] args) {
    	Solution sln = new Solution();
    	int[] arr = {2,4,2,6,1,7,8,9,2,1};
    	System.out.println(sln.candies(10, arr));
    }
}
