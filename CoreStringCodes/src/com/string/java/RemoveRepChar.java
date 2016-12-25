package com.string.java;

/*Enter the String:
input:--jaaavvvvvvvvvvvvakkkkkkkkkkkkkkhhhhhhhhh
output:--javakh
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveRepChar {
public static void main(String[] args) throws IOException {
	
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Enter the String:");
		String s1 = bf.readLine();
		String string = s1+" ";
		int length = string.length();
		String ans = "";
		char ch1,ch2;
 
	for(int i=0;i<length-1;i++){
		    ch1 = string.charAt(i);
			ch2 = string.charAt(i+1);
			
			if(ch1!=ch2){
				ans = ans + ch1;
			}
		
		
	}
	
	System.out.println(ans);
	
}
}
