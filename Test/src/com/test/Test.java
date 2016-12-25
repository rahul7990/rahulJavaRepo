package com.test;

public class Test{
	public static void main(String[] args) {
		
		String str = "1234";
		int l = str.length();
		
		int i = 0;
		int  resultInteger = 0;
		while(i!=l){
			resultInteger = 10 * resultInteger + (str.charAt(i)- '0');	
			i++;
		}
		
		System.out.println("Given String was "+str);
		System.out.println("Converted number is "+resultInteger);
	}
}

