package com.serialization.Employee;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5739551919418169080L;

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
}
