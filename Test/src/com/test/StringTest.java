package com.test;

public class StringTest {
public static void main(String[] args) {
	
	String s1 = "aeiou";
	String s2 = "aaieeouredsa";
	
	System.out.println(findAEIOU(s1,s2));
}

private static String findAEIOU(String source, String destination){
	 
	String s1 = source;
	String s2 = destination;
	
	StringBuffer result = new StringBuffer();
	
	char [] arr1 = s1.toCharArray();
	char [] arr2 = s2.toCharArray();
	
	
	for(int i= 0 ; i< arr1.length;i++){
		
		for(int j = 0;j<arr2.length;j++){
			
			if(arr1[i]==arr2[j])
				result.append(arr1[i]);
		}
	}
	
	return result.toString();
	
}

}
