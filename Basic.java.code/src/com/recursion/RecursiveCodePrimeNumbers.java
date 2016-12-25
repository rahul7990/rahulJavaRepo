package com.recursion;

public class RecursiveCodePrimeNumbers {

	public static void main(String[] args) {
		
		int number = 5;
	 System.out.println(findPrimeNumber(number,2));
		
		
	}
	
	public static  boolean findPrimeNumber(int number, int i){
	    if(i<=number/2){
	    	
	    if(number%i!=0)
				return findPrimeNumber(number,++i);
	    else
	    	return true;
		
	    }
	    
	    if(number%i==0)
		    return false;
	    else
	    	return true;
	}
}
