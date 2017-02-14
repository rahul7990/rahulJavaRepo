package com.java.strategydesignpattern;

public class PayPalPayment implements PaymentStrategy {

	
	String Paypal_loginId;
	String Paypal_Password;
	
	
	
	public PayPalPayment(String paypal_loginId, String paypal_Password) {
		super();
		Paypal_loginId = paypal_loginId;
		Paypal_Password = paypal_Password;
	}



	@Override
	public void pay(int ammount) {
		System.out.println("Payement paid via PayPal:");
	}

}
