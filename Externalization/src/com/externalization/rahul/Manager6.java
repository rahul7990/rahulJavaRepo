package com.externalization.rahul;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manager6 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		E e1 = new E();
		e1.i=10;
		e1.j=20.5;
		
		E e2 = new E();
		e2.i=40;
		e2.j=45.7;
		
		FileOutputStream out = new FileOutputStream("multipleObject.txt");
		ObjectOutputStream obj = new ObjectOutputStream(out);
		obj.writeInt(e1.i);
		obj.writeDouble(e1.j);
		obj.writeInt(e2.i);
		obj.writeDouble(e2.j);
		
		FileInputStream input = new FileInputStream("multipleObject.txt");
		ObjectInputStream objin = new ObjectInputStream(input);
		int i = objin.read();
		double j = objin.read();
		int k = objin.read();
		double l = objin.read();
		
		System.out.println(i);System.out.println(j);System.out.println(k);System.out.println(l);
		
	}
}
