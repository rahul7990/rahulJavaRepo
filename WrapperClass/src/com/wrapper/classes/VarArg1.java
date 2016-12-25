package com.wrapper.classes;

public class VarArg1 {
static void test(int x, String ...strings){
	System.out.println(x);
	System.out.println("String length :::-"+strings.length);
	
	for(String string : strings){
		System.out.println(string+",");
	}
}

public static void main(String[] args) {
 
//	test(); //atleast we need to give first argument which is not part of var arguments.
	test(1);
	test(1,"hello","test","rahul");
	
	
}
}
