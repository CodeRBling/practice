package com.dp;
/**
 * Given two string find number of operations it will take to make both equal 
 * Operations :
 * remove 
 * replace 
 * insert
 * @author Mechy
 *
 */
public class Edit {
	/**
	 * Recursive solution of problem
	 * @return
	 */
	static int solveR(String str1,String str2,int i,int j){
		System.out.println("("+i+","+j+")");
		//when both string reaches end 
		if(i==str1.length() && j==str2.length()){
			return 0;
		}
		//if str1 already reaches end
		else if(i==str1.length()){
			//perform deletion on str2 
			return solveR(str1,str2,i,j+1)+1;
		}else if(j==str2.length()){
			//perform deletion on str1
			return solveR(str1,str2,i+1,j)+1;
		}else if(str1.charAt(i)!=str2.charAt(j)){//character at i and j are not equal 
			//do remove operation
			int remove = 	 solveR(str1,str2,i+1,j)+1;
			//do replacement 
			int replace = 	 solveR(str1,str2,i+1,j+1)+1;
			//insert element 
			int insert = solveR(str1,str2,i,j+1)+1;
			return Math.min(remove,  Math.min(replace,insert));
			
		}else{
			return solveR(str1,str2,i+1,j+1);
		}
	}
	
	/**
	 * DP (bottom-up solution)
	 * @param args
	 */
	static int solveDP(String str1,String str2){
		int[][] store = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<=str1.length();i++){
			store[i][0] = i;
		}
		for(int i=0;i<=str2.length();i++){
			store[0][i] = i;
		}
		for(int i=1;i<=str1.length();i++){
			for(int j=1;j<=str2.length();j++){
				store[i][j] = Math.min(store[i-1][j-1], Math.min(store[i-1][j], store[i][j-1]));
				if(str1.charAt(i-1)!=str2.charAt(j-1)){
					store[i][j] += 1;
				}
			}
		}
		
		return store[str1.length()-1][str2.length()-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(solveR("sort","sport",0,0));
		//System.out.println(solveR("cat","cartt",0,0));
		//System.out.println(solveR("sunday","saturday",0,0));
		
		System.out.println(solveDP("sort","sport"));
		System.out.println(solveDP("cat","cartt"));
		System.out.println(solveDP("sunday","saturday"));
	}

}
