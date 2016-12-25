package com.customize.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Mango implements Serializable{
    
	String taste="Sweet";
	int price=150;
	String color="Yellow";
	
	
	private void readObject(ObjectInputStream objectinput){
		
		try {
			   price=objectinput.readInt();
			   try {
				taste=(String)objectinput.readObject();
				color=(String)objectinput.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
