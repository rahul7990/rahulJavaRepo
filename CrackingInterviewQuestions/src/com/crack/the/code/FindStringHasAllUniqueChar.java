package com.crack.the.code;

/*
Implement an algorithm to determine if a string has all unique characters. 
What if you can not use additional data structures?

*/

public class FindStringHasAllUniqueChar {
public static void main(String[] args) {
	String str = "qwertyuiopasdfghjjkl;'.,mnbvcxz";
	System.out.println(isUniqueChars2(str));
}

public static boolean isUniqueChars2(String str) {
 boolean[] char_set = new boolean[256];
 for (int i = 0; i < str.length(); i++) {
 int val = str.charAt(i);
 if (char_set[val]) return false;
 char_set[val] = true;
 }
 return true;
 }
}
