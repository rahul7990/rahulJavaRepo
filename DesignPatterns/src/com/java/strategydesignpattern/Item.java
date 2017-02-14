package com.java.strategydesignpattern;

public class Item {

	int price;
	String product_name;
	int quantity;
	
	public Item(int price, String product_name, int quantity) {
		super();
		this.price = price;
		this.product_name = product_name;
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
