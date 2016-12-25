package com.rahul.durga;

public class StringDurga2 {

	public static void main(String[] args) {
		
		String string1 = new String("Rahul");
		String string2 = new String("Rahul");
		
		System.out.println("================String Class==================");
		System.out.println(string1==string1);
		System.out.println(string1.equals(string1));
		
		System.out.println("================String Buffer==================");
		StringBuffer sb1 = new StringBuffer("Rahul");
		StringBuffer sb2= new StringBuffer("Rahul");
		System.out.println(sb1==sb2);
		System.out.println(sb1.equals(sb2));
		
	}
}
