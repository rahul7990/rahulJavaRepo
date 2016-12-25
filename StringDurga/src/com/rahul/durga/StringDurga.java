package com.rahul.durga;

public class StringDurga {

	
	public static void main(String[] args) {
		String string = new String("Rahul");
		string.concat("Rawat");
		System.out.println(string);
		
		
		StringBuffer stringbuffer = new StringBuffer("Rahul");
		stringbuffer.append("Rawat");
		System.out.println(stringbuffer);
	}
}
