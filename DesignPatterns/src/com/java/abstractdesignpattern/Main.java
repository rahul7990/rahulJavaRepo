package com.java.abstractdesignpattern;

import com.java.factorydesignpattern.ComputerFactory;

public class Main {
public static void main(String[] args) {
	
	Computor PC = ComputorFactory.getComputor(new PCFactory("PCRAM", "PCHDD", "PCMemory"));
	Computor Server = ComputorFactory.getComputor(new ServerFactory("ServerRAM", "ServerHDD", "ServerMemory"));
	
	System.out.println("PC="+PC);
	System.out.println("***************************************");
	System.out.println("Server="+Server);
}
}
