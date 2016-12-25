package com.wrapper.classes;

public class VarArg {

	static void test(String... strings) {
		System.out.println("From VarArgMethod:::-");
		System.out.println("No of arguments passed to method :::-"
				+ strings.length);

		for (String string : strings) {
			System.out.println("From varArgMethod::" + string);

		}
	}

	public static void main(String[] args) {

		test();
		test("rahul", "amit", "narendra");
		test("A", "B", "C", "D", "E", "F", "G", "H");
	}

}
