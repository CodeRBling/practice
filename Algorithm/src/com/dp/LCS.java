package com.dp;
/**
 * Longest common subsequence 
 * @author Mechy
 *
 */
public class LCS {

	public static int solveDP(String str1,String str2){
		int[][] store = new int[str1.length()+1][str2.length()+1];
		char[] seq = new char[str1.length()+str2.length()];
		for(int i=1;i<=str1.length();i++){
			for(int j=1;j<=str2.length();j++){
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					store[i][j] = store[i-1][j-1]+1;
					seq[i-1] = str1.charAt(i-1);
				}else{
					store[i][j] = Math.max(store[i-1][j], store[i][j-1]);
				}
			}
		}
		return store[str1.length()][str2.length()];
	}
	
	public static int solveR(String str1,String str2,int i,int j){
		if(str1.length()==i && str2.length()==j){
			return 0;
		}else if(str2.length()==j){
			return solveR(str1,str2,i+1,j);
		}else if(str1.length()==i){
			return solveR(str1,str2,i,j+1);
		}else if(str1.charAt(i)==str2.charAt(j)){
			return solveR(str1,str2,i+1,j+1)+1;
		}else{
			return Math.max(solveR(str1,str2,i+1,j), solveR(str1,str2,i,j+1));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveDP("abc","ayb"));
		System.out.println(solveDP("aebd","abcd"));
		System.out.println(solveDP("AAACCGTGAGTTATTCGTTCTAGAA","CACCCCTAAGGTACCTTTGGTTC"));
		//System.out.println(solveR("AAACCGTGAGTTATTCGTTCTAGAA","CACCCCTAAGGTACCTTTGGTTC",0,0));
	}

}