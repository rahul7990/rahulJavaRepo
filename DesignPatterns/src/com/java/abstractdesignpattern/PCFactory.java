package com.java.abstractdesignpattern;

public class PCFactory extends ComputerAbstractFactory{

	private String RAM;
	private String HDD;
	private String Memory;
	
	public PCFactory(String RAM, String HDD,String Memory){
		this.RAM=RAM;
		this.HDD=HDD;
		this.Memory=Memory;
	}
	
	
	@Override
	public Computor createComputor() {
		
		return new PC(RAM,HDD,Memory);
	}

}
