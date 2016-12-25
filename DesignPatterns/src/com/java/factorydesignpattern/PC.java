package com.java.factorydesignpattern;

public class PC extends Computor{

	private String RAM;
	private String HDD;
	private String Memory;
	
	
	public PC(String RAM,String HDD,String Memory){
		this.RAM=RAM;
		this.HDD=HDD;
		this.Memory=Memory;
	}
	
	
	@Override
	public String getRAM() {
		return this.RAM;
	}

	@Override
	public String getHDD() {
		return this.HDD;
	}

	@Override
	public String getMemory() {
		return this.Memory;
	}

}
