package com.dp;
/**
 * Given matrix of M*N find total number of path between (1,1) to (M,N)
 * allowed moves are down and right
 * @author Mechy
 *
 */
public class TotalPathCount {
	/**
	 * Dp solution
	 * @param args
	 */
	public static int solveDP(int m,int n){
		int[][] paths = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 && j==0){
					paths[i][j] = 1;
				}
				else if(i==0){
					paths[i][j] = paths[i][j-1];
				}else if(j==0){
					paths[i][j] = paths[i-1][j];
				}else{
					paths[i][j] = paths[i][j-1]+ paths[i-1][j];
				}
			}
		}
		return paths[m-1][n-1];
	}
	
	/**
	 * solution for blocks 
	 */
	public static int solveDPBlocks(int m,int n,int[][] blocks){
		if(blocks[0][0]==1)
			return 0;
		int[][] paths = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 && j==0){
					paths[i][j] = 1;
				}
				else if(i==0 && blocks[i][j]==0){
					paths[i][j] = paths[i][j-1];
				}else if(j==0 && blocks[i][j]==0){
					paths[i][j] = paths[i-1][j];
				}else if(blocks[i][j]==0){
					paths[i][j] = paths[i][j-1]+ paths[i-1][j];
				}
			}
		}
		return paths[m-1][n-1];
	}
	
	/**
	 * same question but some roads are blocked given by blocks[][]
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveDP(3,4));
		//blocks define that part of road is blocked 
		int[][] blocks = new int[3][3];
		blocks[0][1] = 1;
		blocks[1][0] = 1;
		System.out.println(solveDPBlocks(3,3,blocks));
		
	}

}
