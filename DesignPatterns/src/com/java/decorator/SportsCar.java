package com.java.decorator;

public class SportsCar extends CarDecorator{

	SportsCar(Car car) {
		super(car);
		
	}

	public void assemble(){
		super.assemble();
		System.out.println("Adding feature of Sport Car:::");
	}
	
}
