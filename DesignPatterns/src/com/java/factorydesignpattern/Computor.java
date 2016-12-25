package com.java.factorydesignpattern;

public abstract class Computor {

	
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getMemory();
	
	public String toString(){
		return "RAM="+this.getRAM()+" HDD="+this.getHDD()+" Memory="+this.getMemory();
		
	}
	
}
