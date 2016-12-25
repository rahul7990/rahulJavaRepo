package com.rahul.stack;

import java.util.Arrays;

public class ArrayStack {
private int top;
private int capacity;
private int [] array;

ArrayStack(){
	capacity = 1;
	this.array = new int[capacity];
	top = -1;
}


ArrayStack(int capacity){
	this.capacity= capacity;
	this.array = new int[capacity];
	top = -1;
}


public boolean isEmpty(){
	return (top==-1);
}

public boolean isStackFull(){
	return (top==capacity-1);
}

public void push(int data){
	if(isStackFull())
		System.out.println("Stack is Overflow:");
	else
		array[++top]=data;
	System.out.println(data+" Pushed to stack:");
}

public int pop(){
	if(isEmpty()){
		System.out.println("Stack is Empty:");
	return 0;
	}
	else
	{   
		System.out.println(array[top]+" has poped:");
		return array[top--];
		
	}
	
}

public int size(){
	
	return top+1;//++top will create index out of bound exception becuase pop() will remove top element which is not there ++top means 4. because capacity is 4.
}



@Override
public String toString() {
	return "ArrayStack [array=" + Arrays.toString(array) + "]";
}


	
}

