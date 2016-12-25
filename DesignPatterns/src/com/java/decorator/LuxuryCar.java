package com.java.decorator;

public class LuxuryCar extends CarDecorator{

	LuxuryCar(Car car) {
		super(car);
		
	}
	
	public void assemble(){
		super.assemble();
		System.out.println("Adding feature of Luxury Car:::");
	}

}
