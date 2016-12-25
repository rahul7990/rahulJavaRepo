package com.basic;


class A{
	
	static void method(){
		System.out.println("From A Class :");
	}
	
}
public class StaticMethods extends A {

	static void method(){
		System.out.println("From StaticMethods Class :");
	}
	public static void main(String[] args) {
		
		A st = new StaticMethods();
		st.method();
		StaticMethods.method();
		A.method();
	}
}
