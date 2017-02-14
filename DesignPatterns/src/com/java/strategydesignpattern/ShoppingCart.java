package com.java.strategydesignpattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Item> itemList;
	
	public ShoppingCart(){
		this.itemList= new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		this.itemList.add(item);
	}
	
	public void removeItem(Item item){
		this.itemList.remove(item);
	}
	
	public int calculateTotal(){
		int sum=0;
		
		for(Item item : itemList){
			sum =  sum + item.getPrice();
		}
		
		return sum;
		
	}
	
	public void pay(PaymentStrategy paymentMethod){
		
		paymentMethod.pay(calculateTotal());
	}
}
