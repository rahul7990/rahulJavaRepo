package com.test.designpattern;

public class CarDecorator implements Car {

	protected Car car;
	
	CarDecorator(Car car){
		this.car=car;
	}
	@Override
	public void assemble() {

      this.car.assemble();
		
	}

}
