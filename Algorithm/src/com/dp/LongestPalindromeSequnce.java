package com.dp;
/**
 * Given string find longest sub-sequence palindrome
 * @author Mechy
 *
 */
public class LongestPalindromeSequnce {
	
	public static int solveR(String str,int start,int end){
		if(end<0 || start>= str.length()){
			return 0;
		}else if(str.charAt(start)==str.charAt(end)){
			return solveR(str,start+1,end-1)+1;
		}else{
			return Math.max(solveR(str,start+1,end), solveR(str,start,end-1));
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arg = "pppplppa";
		System.out.println(solveR(arg,0,arg.length()-1));
	}

}
