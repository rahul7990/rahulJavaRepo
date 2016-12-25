package com.jvm.core;

public class HeapSize {
public static void main(String[] args) {
	
	System.out.println(Runtime.getRuntime().totalMemory());
	System.out.println(Runtime.getRuntime().freeMemory());
	
}
}
