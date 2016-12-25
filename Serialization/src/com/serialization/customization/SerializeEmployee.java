package com.serialization.customization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeEmployee {

	public static void main(String[] args) throws IOException {
		
		Employee emp1 = new Employee(101, "Rahul Singh Rawat");
		Employee emp2 = new Employee(201, "Preeti");
		
		Employee emp3 = new Employee(102, "Priyanka");
		Employee emp4 = new Employee(202, "Munish");
		
		Employee emp5 = new Employee(103, " Kumar");
		Employee emp6 = new Employee(203, "Heena");
		EndOfFileIndecator endOffile = new EndOfFileIndecator();
		
		FileOutputStream fout = new FileOutputStream("Employee.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		
		objout.writeObject(emp1);
		objout.writeObject(emp2);
		objout.writeObject(emp3);
		objout.writeObject(emp4);
		objout.writeObject(emp5);
		objout.writeObject(emp6);
		objout.writeObject(endOffile);
		
		
		System.out.println("Serialization Done:");
	}
}
