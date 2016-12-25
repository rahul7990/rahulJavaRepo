package com.java.abstractdesignpattern;

public class ServerFactory extends ComputerAbstractFactory{
	private String RAM;
	private String HDD;
	private String Memory;
	
	public ServerFactory(String RAM, String HDD,String Memory){
		this.RAM=RAM;
		this.HDD=HDD;
		this.Memory=Memory;
	}
	
	
	@Override
	public Computor createComputor() {
		
		return new Server(RAM,HDD,Memory);
	}

}
