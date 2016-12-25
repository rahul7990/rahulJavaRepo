package com.haker.rank;

public class Main {
	public static void main(String[] args) {
	
FoodFactory myFoods = new FoodFactory();
Food food1 = myFoods.getFood("FastFood");
Food food2 = myFoods.getFood("Fruit");

System.out.println("my name is: "+ food1.getClass().getName());
System.out.println("my name is: "+ food2.getClass().getName());
System.out.println("our Super class is: "+ food1.getClass().getSuperclass().getName());

food1.serveFood();
food2.serveFood();
}
}
