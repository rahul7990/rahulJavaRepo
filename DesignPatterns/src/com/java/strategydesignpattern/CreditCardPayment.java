package com.java.strategydesignpattern;

public class CreditCardPayment implements PaymentStrategy{

	int ccv;
	int cardnumber;
	String name;
	String bank;
	
	
	
	public CreditCardPayment(int ccv, int cardnumber, String name, String bank) {
		super();
		this.ccv = ccv;
		this.cardnumber = cardnumber;
		this.name = name;
		this.bank = bank;
	}



	@Override
	public void pay(int ammount) {
		System.out.println("Ammount Paid via credit card:");
		
	}

}
