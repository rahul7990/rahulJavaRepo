package com.java.strategydesignpattern;

public class MainShoppingCart {

	public static void main(String[] args) {
		
		ShoppingCart sc = new ShoppingCart();
		
		Item item1 = new Item(100, "football", 3);
		Item item2 = new Item(600, "bat", 3);
		Item item3 = new Item(50, "ball", 3);
		
		sc.addItem(item1);
		sc.addItem(item2);
		sc.addItem(item3);
		
		sc.pay(new CreditCardPayment(777, 521465698, "Rahul", "hdfc"));
		
		sc.pay(new PayPalPayment("Rahul@PayPal", "111010"));
	}
}
