package com.serialization.customization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -5739551919418169080L;

	private Integer id;
	private String name;
	/*private String addedd;*/
	
	public Employee(Integer id, String name){
		this.id=id;
		this.name=name;
	}
	
	public String toString(){
		return "id: "+id+" name: "+name;
	}
	
	private void writeObject(ObjectOutputStream os){
		 try {
			os.writeInt(this.id);
			os.writeObject(this.name);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	private void readObject(ObjectInputStream in){
		try {
			this.id = in.readInt();
			//this.name = (String)in.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
}
