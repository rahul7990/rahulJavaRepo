package com.rahul.stack;

public class MainStack {

	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack(4);
		
		stack.push(7);
		stack.push(8);
		stack.push(7);
		stack.push(8);
		System.out.println(stack.size());
		
		stack.pop();
		
		System.out.println(stack.size());
		
	}
}
