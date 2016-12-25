package com.rahul.stack;

import java.util.Scanner;
import java.util.Stack;


class Parser{
	
	public boolean isBalanced(String s){
		 Stack<Character> stack  = new Stack<Character>();
	        for(int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if(c == '[' || c == '(' || c == '{' ) {

	                stack.push(c);

	            }else if(c == ']') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '[') return false;

	            }else if(c == ')') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '(') return false;

	            }else if(c == '}') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '{') return false;
	            }

	        }
	        return stack.isEmpty();
	}
}
public class Solution {
public static void main(String[] args) {
	
	Parser parser = new Parser();
	Scanner in = new Scanner(System.in);
	
	while(in.hasNext()){
		
		System.out.println(parser.isBalanced(in.next()));
	}
	
	in.close();
}
}
