package com.dp;
/**
 * solution to coin change problem DP way 
 * @author Mechy
 *
 */
public class coinChange {

	public static int solveDP(int[] coin,int sum){
		int max = Integer.MAX_VALUE;
		int[] store = new int[sum+1];
		store[0] = 0;
		for(int i=1;i<=sum;i++){
			max =  Integer.MAX_VALUE;
			for(int j=0;j<coin.length;j++){
				int temp = Integer.MAX_VALUE;
				if(i-coin[j]>=0){
					temp = store[i-coin[j]];
				}
				if(temp!=Integer.MAX_VALUE){
					max = Math.min(temp+1, max);
				}
			}
			store[i] = max;
		}
		return store[sum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coin = {3,2,7,1};
		System.out.println(solveDP(coin,6));
	}

}
