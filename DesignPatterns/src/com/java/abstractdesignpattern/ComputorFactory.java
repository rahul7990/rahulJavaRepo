package com.java.abstractdesignpattern;

public class ComputorFactory {

	public static Computor getComputor(ComputerAbstractFactory factory){
		return factory.createComputor();
	}
}
