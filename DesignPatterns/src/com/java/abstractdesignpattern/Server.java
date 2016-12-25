package com.java.abstractdesignpattern;

public class Server extends Computor{


	private String RAM;
	private String HDD;
	private String Memory;
	
	
	public Server(String RAM,String HDD,String Memory){
		this.RAM=RAM;
		this.HDD=HDD;
		this.Memory=Memory;
	}
	
	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return this.RAM;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return this.HDD;
	}

	@Override
	public String getMemory() {
		// TODO Auto-generated method stub
		return this.Memory;
	}
	
	public String toString(){
		return "RAM="+this.RAM+" HDD="+this.HDD+" Memory="+Memory;
	}

}
