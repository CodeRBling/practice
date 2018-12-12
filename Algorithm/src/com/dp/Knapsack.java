package com.dp;
/**
 * 
 * @author Mechy
 *
 */
public class Knapsack {

	public static int ks(int[] weight,int[] value,int i,int maxW) {
		if(i<0 || maxW<0){
			return 0;
		}else{
			int val1 = ((maxW - weight[i])>=0)?(ks(weight,value,i-1,maxW - weight[i]) + value[i]):0;
			int val2 = ks(weight,value,i-1,maxW);
			return Math.max(val1, val2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] weight = {1,3,5,2,4};
		int[] value = {2,4,8,3,6};
		System.out.println(ks(weight,value,4,10));
		*/
		int[] weight = {2,3,4,5};
		int[] value = {3,4,5,6};
		System.out.println(ks(weight,value,weight.length-1,5));
	}

}
