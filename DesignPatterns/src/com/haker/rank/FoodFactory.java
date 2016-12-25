package com.haker.rank;


public class FoodFactory {
	public static Food getFood(String type){
		if("FastFood".equalsIgnoreCase(type)) return new FastFood();
		else if("Fruit".equalsIgnoreCase(type)) return new Fruit();
		
		return null;
	}
	
}
