package com.serialization.customization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializeEmployee {

	public static void main(String[] args) {

		try {
			Employee emp;
			FileInputStream fin = new FileInputStream("Employee.txt");
			ObjectInputStream objinp = new ObjectInputStream(fin);
            Object obj;
			while (!((obj = objinp.readObject()) instanceof EndOfFileIndecator)) {
                emp = (Employee)obj;
				System.out.println(emp);
			}
			
			objinp.close();

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		 System.out.println("Object DeSerialization completed.");
		 

	}
}
