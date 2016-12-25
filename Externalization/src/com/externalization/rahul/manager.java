package com.externalization.rahul;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class manager {
public static void main(String[] args) throws IOException, ClassNotFoundException {
	
	externalization();
	deExternalization();
	
}

public static void externalization() throws IOException{
	
	Watermalon watermalon = new Watermalon();
	
	FileOutputStream output = new FileOutputStream("Watermalon.txt");
	ObjectOutputStream obj = new ObjectOutputStream(output);
	watermalon.writeExternal(obj);
}

public static void deExternalization() throws IOException, ClassNotFoundException{
	Watermalon watermalon= new Watermalon();
	FileInputStream input = new FileInputStream("Watermalon.txt");
	ObjectInputStream obj = new ObjectInputStream(input);
	
	
	watermalon.readExternal(obj);
}



}
