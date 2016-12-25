package com.java.factorydesignpattern;

public class Main {

	public static void main(String[] args) {
		Computor PC = ComputerFactory.getComputer("PC", "PC_RAM", "PC_HDD", "PC_MEMORY");
		Computor Server = ComputerFactory.getComputer("Server", "Server_ram", "Server_HDD", "Server_memory");
	
		System.out.println("PC Details:::::-"+PC);
		System.out.println("Server Details:::::"+Server);
		
	
	}
}
