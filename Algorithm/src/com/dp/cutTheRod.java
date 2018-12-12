package com.dp;
/**
 * given rod with cost cut the rod to maximize profit
 * @author Mechy
 *
 */
public class cutTheRod {
	
	public static int solveDP(int[] cost){
		int[] store = new int[cost.length];
		store[0] = 0;
		store[1] = cost[1];
		for(int i=2;i<cost.length;i++){
			int max = 0;
			store[i] = cost[i];
			for(int j=1;j<i;j++){
				store[i] = Math.max(store[i],store[j]+store[i-j]);
			}
		}
		return store[cost.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = {0,1,5,8,9,10,17,17,20};
		System.out.println(solveDP(cost));
	}

}
