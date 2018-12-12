package com.dp;

import java.util.Arrays;

/**
 * class to calculate combination C(n,k)
 * @author Mechy
 *
 */
public class Combination {
	static long[][] combinationValue;
	/**
	 * calculate C(n,k)
	 * @param args
	 */
	long combination(int n,int k){
		if(n==k || k==0){
			combinationValue[n][k] = 1;
		}else{
			long firstValue,secondValue;
			
			if(combinationValue[n-1][k-1]!=0){
				firstValue = combinationValue[n-1][k-1];
			}else{
				firstValue = combination(n-1,k-1);
			}
			
			if(combinationValue[n-1][k]!=0){
				secondValue = combinationValue[n-1][k];
			}else{
				secondValue = combination(n-1,k);
			}
			combinationValue[n][k] = firstValue+secondValue;
		}
		return combinationValue[n][k];
	}
	
	
	public static void main(String[] args){
		combinationValue =new long[11][3];
		Combination C = new Combination();
		System.out.println(C.combination(10,2));
	}
}
