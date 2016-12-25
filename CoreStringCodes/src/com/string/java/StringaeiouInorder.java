package com.string.java;

public class StringaeiouInorder {

	public static void main(String[] args) {
		
		String s1 = "aeiou";
		String s2 = "aaezkiouefua";
		StringBuffer result = new StringBuffer();
		
		char [] arr1 = s1.toCharArray();
		char [] arr2 = s2.toCharArray();
		
		
		for(int i= 0 ; i< arr1.length;i++){
			
			for(int j = 0;j<arr2.length;j++){
				
				if(arr1[i]==arr2[j])
					result.append(arr1[i]);
			}
		}
		
		System.out.println(result.toString());
	}
}
