package com.dp;
/**
 * Given string find longest sub-sequence palindrome if no sequnce found return 1
 * @author Mechy
 *
 */
public class LongestPalindromeSequnce {
	
	public static int solveR(String str,int start,int end){
		if(end<0 || start>= str.length()||str.length()==1){
			return 0;
		}else if(str.charAt(start)==str.charAt(end)){
			return solveR(str,start+1,end-1)+1;
		}else{
			return Math.max(solveR(str,start+1,end), solveR(str,start,end-1));
		}
	}
	
	public static int solveDP(String str){
		if(str.length()==1)
			return 0;
		int[][] store = new int[str.length()+1][str.length()+1];
		for(int i=str.length()-1;i>=0;i--){
			for(int j=1;j<=str.length();j++){
				if(str.charAt(i)==str.charAt(j-1)){
					store[i][j] = store[i+1][j-1]+1;
				}else{
					store[i][j] = Math.max(store[i+1][j],store[i][j-1]);
				}
			}
		}
		return store[0][str.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arg = "pppplppa";
		System.out.println(solveR(arg,0,arg.length()-1));
		System.out.println(solveDP(arg));
		String a = "apple";
		System.out.println(solveR(a,0,a.length()-1));
		System.out.println(solveDP(a));
		String b = "aba";
		System.out.println(solveR(b,0,b.length()-1));
		System.out.println(solveDP(b));
	}

}
