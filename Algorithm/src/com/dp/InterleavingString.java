package com.dp;

public class InterleavingString {
	static boolean solveDp(String a,String b,String c){
		if(a.length()+b.length()!=c.length()){
			return false;
		}else{
			String temp1 = "";
			String temp2 = "";
			int j=0;
			for(int i=0;i<c.length();i++){
				if(j<a.length() && a.charAt(j)==c.charAt(i)){
					temp1+= Character.toString(a.charAt(j));
					j++;
				}else{
					temp2+= Character.toString(c.charAt(i));
				}
			}
			if(temp1.equals(a) && temp2.equals(b))
				return true;
			return false;
		}
	}
	
	
	public static void main(String[] args){
		System.out.println(solveDp("abc","abc","aabbcc"));
		System.out.println(solveDp("abc","abc","abcabc"));
		System.out.println(solveDp("abc","xyz","axbycz"));
		System.out.println(solveDp("abc","","abc"));
		System.out.println(solveDp("","abc","abc"));
		System.out.println(solveDp("abbbc","abbc","ababbcbbc"));
		System.out.println(solveDp("","abc","abc"));
		System.out.println(solveDp("","",""));
		//negative
		System.out.println(solveDp("abbbc","abbc","ababbcbcb"));
		System.out.println(solveDp("abbbc","abc","abcdefgh"));
	}
}
