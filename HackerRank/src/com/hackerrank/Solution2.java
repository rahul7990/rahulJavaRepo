package com.hackerrank;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        System.out.println(comparison(a0,a1,a2,b0,b1,b2));
    }
    
    public static StringBuffer comparison(int a0,int a1,int a2,int b0,int b1,int b2){
    	StringBuffer output=new StringBuffer();
    	if(a0!=b0){
    		output.append(1);
    	}
    	if(a1!=b1)
    	{
    		output.append(" "+"1");
    	}
    	if(a2!=b2){
    		output.append(" "+"1");
    	}
    	
		return output;
    	
    }
}