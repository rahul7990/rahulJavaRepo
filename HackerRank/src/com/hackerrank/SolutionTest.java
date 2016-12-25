package com.hackerrank;

import java.util.Scanner;


public class SolutionTest {
	

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
	    	StringBuffer Alice=new StringBuffer();
	    	StringBuffer Bob=new StringBuffer();
	    	boolean alice=false;
	    	boolean bob=false;
	    	
	    	if(!(a0==b0)){
	    	    if(a0>b0){
	    		Alice.append("1"+" ");
	    		alice = true;
	    	            }
	    	if(b0>a0)
	    	{
	    		Bob.append("1"+" ");
	    		bob = true;
	    	}
	    	}
	    
	    	
	    if(!(a1==b1)){
	    	    if(a1>b1){
	    	    	if(alice){
	    		Alice.append("1"+" ");
	    		}
	    	       else{
	    	    Alice.append("1"+" ");
	    	    alice = true;
	    	    }
	    	          }
	    	if(b1>a1){
	    		if(bob){
	    		Bob.append("1"+" ");
	    		}
	    		else{
	    		Bob.append("1"+" ");
	    		bob = true;
	    	        }
	    		}
	    	}
	    	

		
	    if(!(a2==b2)){
	    	    if(a2>b2){
	    	    	if(alice){
	    		Alice.append("1"+" ");
	    		}
	    	       else{
	    	    Alice.append("1"+" ");
	    	    }
	    	          }
	    	if(b2>a2){
	    		if(bob){
	    		Bob.append("1"+" ");
	    		}
	    		else{
	    		Bob.append("1"+" ");
	    	        }
	    		}
	    	}
	    
	   return Alice.append(Bob);
		
	    
}
}
	

