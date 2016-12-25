package com.lara.rahul;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manager1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		doSerialization();
		doDeserialization();
	}

	public static void doSerialization() throws IOException {

		Apple apple = new Apple();
		apple.color = "Red";
		apple.taste = "Sweet";
		apple.price = 50.5;
		
		FileOutputStream input = new FileOutputStream("fruit.txt");
		ObjectOutputStream obj = new ObjectOutputStream(input);

		obj.writeObject(apple);
		System.out.println("Serialization Done:");

	}
	
	public static void doDeserialization() throws IOException, ClassNotFoundException{
		FileInputStream output = new FileInputStream("fruit.txt");
		ObjectInputStream obj = new ObjectInputStream(output);
		
		Apple apple;
		apple=(Apple)obj.readObject();
		System.out.println("Deserialization begins.......");
		System.out.println(apple.color);
		System.out.println(apple.price);
		System.out.println(apple.taste);
		
	}
}
