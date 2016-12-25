package com.test;

public class LocalVariable {
	static int b;//Globle Variable
	public static void main(String[] args) {
		int a=1;
		//The local variables are not initialized to any default value, neither primitives nor object references.
		System.out.println(a);
		System.out.println(b);
	}

}
