package com.string.java;

public class FrequencyCount {

	public static void main(String[] args) {
		
		String string = "Hi how are you";
		int length = string.length();
		
		String charString = string.toLowerCase();
		int count = 0;
		for(char i='a'; i<'z';i++)
		{   
			count =0;
			for(int j=0;j<length;j++){
				if(charString.charAt(j)==i)
					count++;
			}
			
			if(count!=0)
			System.out.println(i+"="+count);
		}
	}
}

