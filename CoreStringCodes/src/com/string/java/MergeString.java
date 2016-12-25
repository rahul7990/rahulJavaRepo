package com.string.java;

public class MergeString {
	public static void main(String[] args) {

		String s1 = "abc";
		String s2 = "efghkl";
        
		int i=0, j=0, k=0, m = 0;

		int counter = 0;
		int l1 = s1.length();
		int l2 = s2.length();

		char[] arr = new char[l1+l2];
		
		if (l1 < l2)
			counter = l1;
		else
			counter = l2;
		
		while(m<counter){
			arr[i++] = s1.charAt(j++);
			arr[i++] = s2.charAt(k++);
			m++;
		}

		while(k < l2){
			arr[i++] = s2.charAt(k++);
		}
		
		while(j < l1){
			arr[i++] = s1.charAt(j++);
		}
		
		System.out.println(arr);
	}

}
