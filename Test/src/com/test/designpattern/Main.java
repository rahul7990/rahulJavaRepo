package com.test.designpattern;

public class Main {
public static void main(String[] args) {
	
	Car sportsCar = new SportsCar(new BasicCar());
	sportsCar.assemble();
	
	System.out.println("*******************************");
	
	Car SportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
	SportsLuxuryCar.assemble();

}
}
