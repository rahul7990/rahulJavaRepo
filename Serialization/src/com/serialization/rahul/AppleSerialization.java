package com.serialization.rahul;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppleSerialization {

	public static void main(String[] args) throws IOException {
		Apple apple = new Apple();
		OutputStream fout = new FileOutputStream("apple.txt");
		ObjectOutputStream obj = new ObjectOutputStream(fout);
		obj.writeObject(apple);
	}
}
