package com.dp;
/**
 * find longest substring such that one half of sum of string equal to other 
 * @author Mechy
 *
 */
public class subStringEqualSum {
	
	/**
	 * check for equality of sum in halves of string 
	 * @return
	 */
	boolean isEqualHalfSum(String str){
		int sumL = 0,sumR = 0;
		for(int i=0;i<str.length()/2;i++){
			sumL += Integer.parseInt(Character.toString(str.charAt(i)));
			sumR += Integer.parseInt(Character.toString(str.charAt(str.length()-i-1)));
		}
		return sumL == sumR;
	}
	
	
	
	/**
	 * longest sub-string of equal sum of half usign Dp 
	 * in this particular problem we are not saving pre-calculated data 
	 * instead of that we are simply not calculating for particular length
	 * if we already found the string of equal halves 
	 * @param args
	 */
	int longSubString(String str){
		int max = 0;
		for(int i=0;i<str.length();i++){
			for(int j = 2;i+j<=str.length();j+=2){
				if(max<=j && isEqualHalfSum(str.substring(i, i+j))){
					max = j;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subStringEqualSum obj = new subStringEqualSum();
		System.out.println(obj.longSubString("1123451"));
	}

}
