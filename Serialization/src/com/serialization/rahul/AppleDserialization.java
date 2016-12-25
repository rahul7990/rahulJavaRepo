package com.serialization.rahul;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class AppleDserialization {
	public static void main(String[] args) {

		try {
			InputStream iput = new FileInputStream("apple.txt");
			ObjectInputStream obj = new ObjectInputStream(iput);
			Apple apple;

			try {
				apple = (Apple) obj.readObject();
				System.out.println(apple.color);
				System.out.println(apple.price);
				System.out.println(apple.test);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
